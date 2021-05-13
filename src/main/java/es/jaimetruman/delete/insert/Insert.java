package es.jaimetruman.delete.insert;

import es.jaimetruman.delete.insert.options.InsertOptionInitial;


public abstract class Insert {
    public static InsertOptionInitial table(String table) {
        return new InsertOptionInitial(table);
    }
}
