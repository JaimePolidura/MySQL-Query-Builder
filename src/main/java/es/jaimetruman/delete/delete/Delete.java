package es.jaimetruman.delete.delete;

public abstract class Delete {
    public static DeleteOptionsInitial from (String table) {
        return new DeleteOptionsInitial(table);
    }
}
