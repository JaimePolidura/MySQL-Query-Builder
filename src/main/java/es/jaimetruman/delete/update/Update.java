package es.jaimetruman.delete.update;

public abstract class Update {
    public static UpdateOptionInitial table (String table) {
        return new UpdateOptionInitial(table);
    }
}
