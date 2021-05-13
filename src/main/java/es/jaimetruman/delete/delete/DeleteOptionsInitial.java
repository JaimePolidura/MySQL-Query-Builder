package es.jaimetruman.delete.delete;

public final class DeleteOptionsInitial extends Delete {
    private final StringBuilder builder;

    public DeleteOptionsInitial (String table) {
        this.builder = new StringBuilder().append("DELETE FROM ")
                .append(table)
                .append(" ");
    }

    public DeleteOptionsCompare where (String field) {
        return new DeleteOptionsCompare(builder, "WHERE ", field, " ");
    }

    public String build () {
        return builder.toString();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
