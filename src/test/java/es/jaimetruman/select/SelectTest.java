package es.jaimetruman.select;

import org.junit.Assert;
import org.junit.Test;

public final class SelectTest {
    @Test
    public void testSelect1 () {
        String query = Select.from("jugadores")
                .where("dinero").equal(10)
                .and("nombre").equal("jaimetruman")
                .build();

        Assert.assertEquals(query, "SELECT * FROM jugadores WHERE dinero = 10 AND nombre = 'jaimetruman' ");
    }

    @Test
    public void testSelect2 () {
        String query = Select.from("jugadores")
                .orderBy("dinero", Order.ASC)
                .limit(3)
                .build();

        Assert.assertEquals(query, "SELECT * FROM jugadores ORDER BY dinero ASC LIMIT 3 ");
    }
}
