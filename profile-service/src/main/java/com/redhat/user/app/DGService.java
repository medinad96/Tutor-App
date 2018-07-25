package com.redhat.user.app;
import com.redhat.user.profile.Student;
import com.redhat.user.profile.Tutor;
import com.redhat.user.profile.User;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.marshall.ProtoStreamMarshaller;
import org.infinispan.protostream.SerializationContext;
import org.infinispan.protostream.annotations.ProtoSchemaBuilder;
import org.infinispan.query.remote.client.ProtobufMetadataManagerConstants;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DGService {

    private RemoteCacheManager cacheManager;

    public DGService() throws Exception {

        ConfigurationBuilder config = new ConfigurationBuilder()
                .addServer()
                .host("datagrid-hotrod")
                .port(11333)
                .marshaller(new ProtoStreamMarshaller());

        cacheManager = new RemoteCacheManager(config.build());

        SerializationContext serCtx =
                ProtoStreamMarshaller.getSerializationContext(cacheManager);

        // generate and register a Protobuf schema and marshallers based
        // on Note class and the referenced classes (User class)
        ProtoSchemaBuilder protoSchemaBuilder = new ProtoSchemaBuilder();
        String generatedSchema = protoSchemaBuilder
                .fileName("tutor.proto")
                .packageName("com.redhat.user.profile")
                .addClass(User.class)
                .addClass(Tutor.class)
                .addClass(Student.class)
                .build(serCtx);

        // the types can be marshalled now
        System.out.println("Can we marshal? " + serCtx.canMarshall(Student.class));

        // register the schemas with the server too
        RemoteCache<String, String> metadataCache = cacheManager.getCache(ProtobufMetadataManagerConstants.PROTOBUF_METADATA_CACHE_NAME);
        metadataCache.put("tutor.proto", generatedSchema);
        String errors = metadataCache.get(ProtobufMetadataManagerConstants.ERRORS_KEY_SUFFIX);
        if (errors != null) {
            throw new IllegalStateException("Some Protobuf schema files contain errors:\n" + errors);
        }

        // display the schema file
        System.out.println(generatedSchema);

      //  cacheManager.getCache("foo");

    }

    public RemoteCache<String, Student> getStudents() {
        return cacheManager.getCache("student");
    }

    public RemoteCache<String, Tutor> getTutors() {
        return cacheManager.getCache("tutor");
    }







}
