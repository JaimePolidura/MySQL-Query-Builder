package es.jaimetruman._shared.serializers;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public final class LocalDateTimeSerializerTest {
    @Test
    public void localdatetime() {
        LocalDateTimeSerializer serializer = new LocalDateTimeSerializer();
        String serialized =  serializer.serialize(LocalDateTime.of(2000, 12, 20 , 20, 20, 0));
        
        Assert.assertEquals("'2000-12-20 20:20:00'", serialized);
    }
}
