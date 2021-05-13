package es.jaimetruman.delete;

import es.jaimetruman.CanBuildQuery;
import es.jaimetruman.Utils;

public final class DeleteOptionsFull extends Delete implements CanBuildQuery {
    private final StringBuilder builder;

    public DeleteOptionsFull(String query, String... toAppend) {
        this.builder = new StringBuilder().append(query);

        this.builder.append(Utils.buildString(toAppend));
    }

    public DeleteOptionsCompare and (String field) {
        return new DeleteOptionsCompare(builder.toString(), "AND ", field, " ");
    }

    public DeleteOptionsCompare or (String field) {
        return new DeleteOptionsCompare(builder.toString(), "OR ", field, " ");
    }

    @Override
    public String build () {
        return builder.toString();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
