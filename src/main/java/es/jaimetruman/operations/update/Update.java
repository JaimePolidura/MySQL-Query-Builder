package es.jaimetruman.operations.update;

public abstract class Update {
    public static UpdateOptionInitial table (String table) {
        return new UpdateOptionInitial(table);
    }
}
