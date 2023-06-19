package es.jaimetruman._shared.serializers;

import es.jaimetruman.insert.Insert;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public final class Complete {
    @Test
    public void completeSerializerTest() {
        List<String> fields = Arrays.asList("nombre", "tipo", "dinero");
        List<Object> values = Arrays.asList("Jaime", EnumSerialzierTest.EjemploEnum.VALOR1, 10.2d);

        String update = Insert.table("tabla")
                .fields(fields.toArray(new String[0]))
                .values(values.toArray(new Object[0]));

        Assert.assertEquals("INSERT INTO tabla (nombre, tipo, dinero) VALUES ('Jaime', 'VALOR1', 10.2)", update);
    }
}
