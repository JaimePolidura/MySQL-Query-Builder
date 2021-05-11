package es.jaimetruman.select;

import es.jaimetruman.QueryBuilder;

public abstract class Select extends QueryBuilder {
    public static SelectOptionInitial from (String table) {
        return new SelectOptionInitial(table);
    }

    public static SelectOptionInitial fromDistinct (String table) {
        return new SelectOptionInitial(table, "DISTINCT");
    }

}
