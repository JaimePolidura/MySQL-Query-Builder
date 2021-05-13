package es.jaimetruman.operations.insert;

import es.jaimetruman.operations.insert.options.InsertOptionInitial;


public abstract class Insert {
    public static InsertOptionInitial of (String table) {
        return new InsertOptionInitial(table);
    }
}
