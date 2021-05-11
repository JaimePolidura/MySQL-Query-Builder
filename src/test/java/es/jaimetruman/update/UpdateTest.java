package es.jaimetruman.update;

import org.junit.Assert;
import org.junit.Test;

public final class UpdateTest {
    @Test
    public void testUpdate () {
        String query = Update
                .table("jugadores")
                    .set("dinero", 10)
                    .andSet("npagos", 1)
                .where("nombre")
                    .equal("jaimetruman")
                .build();

        Assert.assertEquals(query, "UPDATE jugadores SET dinero = 10 , npagos = 1 WHERE nombre = 'jaimetruman' ");
    }
}
