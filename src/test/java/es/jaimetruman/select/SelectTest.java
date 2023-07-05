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

    @Test
    public void testSelect3() {
        String query = Select.from("jugadores").where("nombre")
                .isNull()
                .and("onilne")
                .isTrue()
                .toString();

        Assert.assertEquals(query, "SELECT * FROM jugadores WHERE nombre IS NULL AND onilne IS TRUE ");
    }

    @Test
    public void testSelect4() {
        String query = Select.from("jugadores").where("nombre")
                        .in("JaimeTruman", "MOLONXX7", "walo002")
                .toString();

        Assert.assertEquals(query, "SELECT * FROM jugadores WHERE nombre IN ('JaimeTruman', 'MOLONXX7', 'walo002') ");
    }
}
