package es.jaimetruman.operations.select.options;

import es.jaimetruman.operations.select.Order;
import es.jaimetruman.operations.select.Select;

public class SelectOptionInitial extends Select {
    private final StringBuilder builder;

    public SelectOptionInitial(String table) {
        this.builder = new StringBuilder()
                .append("SELECT * FROM ")
                .append(table)
                .append(" ");
    }

    public SelectOptionInitial(String query, String... toAppend) {
        StringBuilder builder = new StringBuilder();
        builder.append(query);

        for (String wordToAppend : toAppend) {
            builder.append(wordToAppend);
        }

        builder.append(" ");

        this.builder = builder;
    }

    public SelectOptionCompare where (String value) {
        return new SelectOptionCompare(build(), "WHERE ", value);
    }

    public SelectOptionInitial isNotNull (String field) {
        return new SelectOptionInitial(build(), field, " IS NOT NULL");
    }

    public SelectOptionInitial like (String value) {
        return new SelectOptionInitial(build(), "LIKE ", value);
    }

    public SelectOptionInitial orderBy (String field, Order orderType) {
        return new SelectOptionInitial(build(), "ORDER BY ", field, " ", orderType.toString());
    }

    public SelectOptionInitial groupBy (String field) {
        return new SelectOptionInitial(build(), "GROUP BY ", field);
    }

    public SelectOptionInitial limit (int limit) {
        return new SelectOptionInitial(build(), "LIMIT ", String.valueOf(limit));
    }

    @Override
    public String build() {
        return builder.toString();
    }
}
