package es.jaimetruman.operations;

import es.jaimetruman.operations.delete.Delete;
import org.junit.Assert;
import org.junit.Test;

public final class DeleteTest {
    @Test
    public void deleteTest() {
        String query = Delete.from("jugadores")
                .where("nombre").equal("jaimetruman")
                .build();

        Assert.assertEquals(query, "DELETE FROM jugadores WHERE nombre = 'jaimetruman' ");
    }
}
