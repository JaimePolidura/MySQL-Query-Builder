package es.jaimetruman.delete;

import es.jaimetruman.QueryBuilder;

import static es.jaimetruman.Utils.formatValue;

public final class Delete extends QueryBuilder {
    private final StringBuilder builder;

    public static Delete from (String table) {
        return new Delete(table);
    }

    private Delete(String table) {
        this.builder = new StringBuilder();

        builder.append("DELETE FROM ").append(table).append(" ");
    }

    private Delete(String query, String... toAppend) {
        StringBuilder builder = new StringBuilder();
        builder.append(query);

        for (String wordToAppend : toAppend) {
            builder.append(wordToAppend);
        }

        builder.append(" ");

        this.builder = builder;
    }

    public Delete where (String value) {
        return new Delete(build(), "WHERE ", value);
    }

    public Delete equal (Object value) {
        return new Delete(build(), "= ", formatValue(value));
    }

    public Delete bigger(Object value) {
        return new Delete(build(), ">", formatValue(value));
    }

    public Delete smaller(Object value) {
        return new Delete(build(), "<", formatValue(value));
    }

    public Delete smallerOrEqual (Object value) {
        return new Delete(build(), "<=", formatValue(value));
    }

    public Delete biggerOrEqual(Object value) {
        return new Delete(build(), ">=", formatValue(value));
    }

    public Delete like (String value) {
        return new Delete(build(), "LIKE ", value);
    }

    public Delete and (String value) {
        return new Delete(build(), "AND ", value);
    }

    public Delete or (String value) {
        return new Delete(build(), "OR ", value);
    }

    @Override
    public String build() {
        return builder.toString();
    }
}
