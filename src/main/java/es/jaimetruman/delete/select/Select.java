package es.jaimetruman.delete.select;

import es.jaimetruman.delete.select.options.SelectOptionInitial;

public abstract class Select {
    public static SelectOptionInitial from (String table) {
        return new SelectOptionInitial("SELECT * FROM ", table, " ");
    }

    public static SelectOptionInitial fromDistinct (String table) {
        return new SelectOptionInitial("SELECT DISTINC FROM ", table, " ");
    }
}
