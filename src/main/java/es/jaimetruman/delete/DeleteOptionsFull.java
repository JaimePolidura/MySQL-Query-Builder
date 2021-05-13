package es.jaimetruman.delete;

import es.jaimetruman.Utils;
import es.jaimetruman.CanBuildQuery;

public final class DeleteOptionsFull extends Delete implements CanBuildQuery {
    private final StringBuilder builder;

    public DeleteOptionsFull(StringBuilder builder, String... toAppend) {
        this.builder = builder;

        this.builder.append(Utils.buildString(toAppend));
    }

    public DeleteOptionsCompare and (String field) {
        return new DeleteOptionsCompare(builder, "AND ", field, " ");
    }

    public DeleteOptionsCompare or (String field) {
        return new DeleteOptionsCompare(builder, "OR ", field, " ");
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
