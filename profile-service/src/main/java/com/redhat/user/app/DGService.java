package com.redhat.user.app;
import com.redhat.user.profile.Student;
import com.redhat.user.profile.Tutor;
import com.redhat.user.profile.User;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.marshall.ProtoStreamMarshaller;
import org.infinispan.protostream.SerializationContext;
import org.infinispan.protostream.annotations.ProtoSchemaBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DGService {

    private RemoteCacheManager cacheManager;

    public DGService() throws Exception {

        Configuration config = new ConfigurationBuilder()
                .addServer()
                .host("datagrid-hotrod")
                .port(11333)
                .build();

        cacheManager = new RemoteCacheManager(config);

        SerializationContext serCtx =
                ProtoStreamMarshaller.getSerializationContext(cacheManager);

        // generate and register a Protobuf schema and marshallers based
        // on Note class and the referenced classes (User class)
        ProtoSchemaBuilder protoSchemaBuilder = new ProtoSchemaBuilder();
        String generatedSchema = protoSchemaBuilder
                .fileName("tutor.proto")
                .packageName("com.redhat.user")
                .addClass(User.class)
                .build(serCtx);

        // the types can be marshalled now
        System.out.println("Can we marshal? " + serCtx.canMarshall(User.class));

        // display the schema file
        System.out.println(generatedSchema);

        cacheManager.getCache("foo");

    }

    public Map<String, Student> getStudents() {
        return cacheManager.getCache("student");
    }

    public Map<String, Tutor> getTutors() {
        return cacheManager.getCache("tutor");
    }







}
