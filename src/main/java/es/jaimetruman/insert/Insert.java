package es.jaimetruman.insert;

import es.jaimetruman.WriteQuery;

public abstract class Insert implements WriteQuery {
    public static InsertOptionInitial table(String table) {
        return new InsertOptionInitial(table);
    }
}
