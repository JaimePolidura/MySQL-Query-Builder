package es.jaimetruman.select;

import es.jaimetruman.Utils;
import es.jaimetruman.CanBuildQuery;

public final class SelectOptionFull extends Select implements CanBuildQuery {
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

    @Override
    public String build() {
        return builder.toString();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
