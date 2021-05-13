package es.jaimetruman.select;

import es.jaimetruman.ReadQuery;

public abstract class Select implements ReadQuery {
    public static SelectOptionInitial from (String table) {
        return new SelectOptionInitial("SELECT * FROM ", table, " ");
    }

    public static SelectOptionInitial fromDistinct (String table) {
        return new SelectOptionInitial("SELECT DISTINC FROM ", table, " ");
    }
}
