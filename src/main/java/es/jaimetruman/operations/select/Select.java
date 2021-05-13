package es.jaimetruman.operations.select;

import es.jaimetruman.operations.QueryBuilder;
import es.jaimetruman.operations.select.options.SelectOptionInitial;

public abstract class Select extends QueryBuilder {
    public static SelectOptionInitial from (String table) {
        return new SelectOptionInitial(table);
    }

    public static SelectOptionInitial fromDistinct (String table) {
        return new SelectOptionInitial(table, "DISTINCT");
    }
}
