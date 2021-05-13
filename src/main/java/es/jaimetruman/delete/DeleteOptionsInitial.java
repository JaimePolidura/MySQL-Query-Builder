package es.jaimetruman.delete;

import es.jaimetruman.CanBuildQuery;

public final class DeleteOptionsInitial extends Delete implements CanBuildQuery {
    private final StringBuilder builder;

    public DeleteOptionsInitial (String table) {
        this.builder = new StringBuilder().append("DELETE FROM ")
                .append(table)
                .append(" ");
    }

    public DeleteOptionsCompare where (String field) {
        return new DeleteOptionsCompare(builder, "WHERE ", field, " ");
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
