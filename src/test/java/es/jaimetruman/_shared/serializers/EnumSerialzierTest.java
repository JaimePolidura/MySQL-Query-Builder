package es.jaimetruman._shared.serializers;

import org.junit.Assert;
import org.junit.Test;

public final class EnumSerialzierTest {
    @Test
    public void enumSerializer() {
        EnumSerializer enumSerializer = new EnumSerializer();

        Assert.assertEquals("'VALOR1'", enumSerializer.serialize(EjemploEnum.VALOR1));;
    }

    public enum EjemploEnum {
        VALOR1, VALOR2
    }
}
