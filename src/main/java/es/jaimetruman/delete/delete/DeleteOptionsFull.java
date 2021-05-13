package es.jaimetruman.delete.delete;

import es.jaimetruman.Utils;

public final class DeleteOptionsFull extends Delete{
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

    public String build () {
        return builder.toString();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
