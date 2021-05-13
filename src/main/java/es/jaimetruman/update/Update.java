package es.jaimetruman.update;

import es.jaimetruman.WriteQuery;

public abstract class Update implements WriteQuery {
    public static UpdateOptionInitial table (String table) {
        return new UpdateOptionInitial(table);
    }
}
