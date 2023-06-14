package es.jaimetruman._shared.serializers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public final class CollectionSerializerTest {
    @Test
    public void collectionSerializer() {
        CollectionSerializer collectionSerializer = new CollectionSerializer();

        String serialized = collectionSerializer.serialize(Arrays.asList(
                new ColletionSerializerObject("jaime", 3),
                new ColletionSerializerObject("pedro", 12)
        ));

        Assert.assertEquals("'[{\"nombre\":\"jaime\",\"puntos\":3.0},{\"nombre\":\"pedro\",\"puntos\":12.0}]'", serialized);
    }

    @AllArgsConstructor
    public static class ColletionSerializerObject {
        @Getter private String nombre;
        @Getter private double puntos;
    }
}
