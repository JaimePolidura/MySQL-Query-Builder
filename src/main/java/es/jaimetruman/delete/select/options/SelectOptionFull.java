package es.jaimetruman.delete.select.options;

import es.jaimetruman.Utils;
import es.jaimetruman.delete.select.Select;

public final class SelectOptionFull extends Select {
    private final StringBuilder builder;

    public SelectOptionFull(String query, String... toAppend) {
        this.builder = new StringBuilder();

        this.builder.append(query).append(Utils.buildString(toAppend));
    }

    public SelectOptionCompare and (String value) {
        return new SelectOptionCompare(build(), "AND ", value, " ");
    }

    public SelectOptionCompare or (String value) {
        return new SelectOptionCompare(build(), "OR ", value, " ");
    }

    public String build () {
        return builder.toString();
    }

    @Override
    public String toString () {
        return this.builder.toString();
    }
}
