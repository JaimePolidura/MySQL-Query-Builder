package es.jaimetruman.delete;

import org.junit.Assert;
import org.junit.Test;

public final class DeleteTest {
    @Test
    public void deleteTest() {
        String query = Delete.from("jugadores")
                .where("nombre").equal("jaimetruman")
                .build();

        Assert.assertEquals("DELETE FROM jugadores WHERE nombre = 'jaimetruman' ", query);
    }
}
