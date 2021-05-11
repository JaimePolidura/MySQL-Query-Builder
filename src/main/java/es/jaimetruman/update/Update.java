package es.jaimetruman.update;


import es.jaimetruman.QueryBuilder;

import static es.jaimetruman.Utils.formatValue;

public final class Update extends QueryBuilder {
    private final StringBuilder builder;

    public static Update table (String table) {
        return new Update(table);
    }

    private Update(String table) {
        this.builder = new StringBuilder();

        builder.append("UPDATE ").append(table).append(" ");
    }

    private Update(String query, String... toAppend) {
        StringBuilder builder = new StringBuilder();
        builder.append(query);

        for (String wordToAppend : toAppend) {
            builder.append(wordToAppend);
        }

        builder.append(" ");

        this.builder = builder;
    }

    public Update set (String field, Object value) {
        return new Update(build(), "SET ", field, " = ", formatValue(value));
    }

    public Update andSet (String field, Object value) {
        return new Update(build(), ", ", field, " = ", formatValue(value));
    }

    public Update where (String value) {
        return new Update(build(), "WHERE ", value);
    }

    public Update equal (Object value) {
        return new Update(build(), "= ", formatValue(value));
    }

    public Update bigger(Object value) {
        return new Update(build(), ">", formatValue(value));
    }

    public Update smaller(Object value) {
        return new Update(build(), "<", formatValue(value));
    }

    public Update smallerOrEqual (Object value) {
        return new Update(build(), "<=", formatValue(value));
    }

    public Update biggerOrEqual(Object value) {
        return new Update(build(), ">=", formatValue(value));
    }

    public Update like (String value) {
        return new Update(build(), "LIKE ", value);
    }

    public Update and (String value) {
        return new Update(build(), "AND ", value);
    }

    public Update or (String value) {
        return new Update(build(), "OR ", value);
    }

    @Override
    public String build() {
        return builder.toString();
    }
}
