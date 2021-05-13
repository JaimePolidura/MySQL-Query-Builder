package es.jaimetruman.update;

import es.jaimetruman.delete.update.Update;
import org.junit.Assert;
import org.junit.Test;

public final class UpdateTest {
    @Test
    public void testUpdate () {
        String query = Update.table("jugadores")
                    .set("dinero", 10)
                    .andSet("npagos", 1)
                .where("nombre")
                    .equal("jaimetruman")
                    .and("dinero")
                    .biggerOrEqual(10)
                .build();

        Assert.assertEquals(query, "UPDATE jugadores SET dinero = 10 , npagos = 1 WHERE nombre = 'jaimetruman' AND dinero >= 10");
    }
}
