package es.jaimetruman.delete;

import es.jaimetruman.WriteQuery;

public abstract class Delete implements WriteQuery {
    public static DeleteOptionsInitial from (String table) {
        return new DeleteOptionsInitial(table);
    }
}
