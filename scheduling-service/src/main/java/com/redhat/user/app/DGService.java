package com.redhat.user.app;

import com.redhat.user.model.Appointment;

import org.infinispan.client.hotrod.RemoteCache;
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
                .packageName("com.redhat.user.model")
                .addClass(Appointment.class)
                .build(serCtx);

        // the types can be marshalled now
        System.out.println("Can we marshal? " + serCtx.canMarshall(Appointment.class));

        // display the schema file
        System.out.println(generatedSchema);

        //  cacheManager.getCache("foo");


    }

    public RemoteCache<String, Appointment> getAppointments() {
        return cacheManager.getCache("appointment");
    }


}
