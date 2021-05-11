package es.jaimetruman.select;

import es.jaimetruman.QueryBuilder;
import es.jaimetruman.Utils;

import static es.jaimetruman.Utils.*;

public final class Select extends QueryBuilder {
    private final StringBuilder builder;

    public static Select from (String table) {
        return new Select(table);
    }

    public static Select fromDistinct (String table) {
        return new Select(table, "DISTINCT");
    }

    private Select(String table) {
        this.builder = new StringBuilder();

        builder.append("SELECT * FROM ").append(table).append(" ");
    }

    private Select(String table, String otherword) {
        this.builder = new StringBuilder();

        builder.append("SELECT ").append(otherword).append(" * ").append(table).append(" ");
    }

    private Select(String query, String... toAppend) {
        StringBuilder builder = new StringBuilder();
        builder.append(query);

        for (String wordToAppend : toAppend) {
            builder.append(wordToAppend);
        }

        builder.append(" ");

        this.builder = builder;
    }

    public Select where (String value) {
        return new Select(build(), "WHERE ", value);
    }

    public Select equal (Object value) {
        return new Select(build(), "= ", formatValue(value));
    }

    public Select bigger(Object value) {
        return new Select(build(), ">", formatValue(value));
    }

    public Select smaller(Object value) {
        return new Select(build(), "<", formatValue(value));
    }

    public Select smallerOrEqual (Object value) {
        return new Select(build(), "<=", formatValue(value));
    }

    public Select biggerOrEqual(Object value) {
        return new Select(build(), ">=", formatValue(value));
    }

    public Select isNotNull (String field) {
        return new Select(build(), field, " IS NOT NULL");
    }

    public Select like (String value) {
        return new Select(build(), "LIKE ", value);
    }

    public Select and (String value) {
        return new Select(build(), "AND ", value);
    }

    public Select or (String value) {
        return new Select(build(), "OR ", value);
    }

    public Select orderBy (String field, Order orderType) {
        return new Select(build(), "ORDER BY ", field, " ", orderType.toString());
    }

    public Select groupBy (String field) {
        return new Select(build(), "GROUP BY ", field);
    }

    public Select limit (int limit) {
        return new Select(build(), "LIMIT ", String.valueOf(limit));
    }

    @Override
    public String build() {
        return builder.toString();
    }
}
