package es.jaimetruman.insert;

import es.jaimetruman.delete.insert.Insert;
import org.junit.Assert;
import org.junit.Test;

public final class InsertTest {
    @Test
    public void testInsert () {
        String query = Insert.table("jugadores")
                .fields("nombre", "dinero")
                .values("JaimeTruman", 10);

        Assert.assertEquals(query, "INSERT INTO jugadores (nombre, dinero) VALUES ('JaimeTruman', 10)");
    }

}
