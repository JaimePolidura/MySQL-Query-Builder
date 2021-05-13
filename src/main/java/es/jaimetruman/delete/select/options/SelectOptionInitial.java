package es.jaimetruman.delete.select.options;

import es.jaimetruman.Utils;
import es.jaimetruman.delete.select.Order;
import es.jaimetruman.delete.select.Select;

public class SelectOptionInitial extends Select {
    private final StringBuilder builder;

    public SelectOptionInitial(String... toAppend) {
        this.builder = new StringBuilder(Utils.buildString(toAppend));
    }

    public SelectOptionCompare where (String value) {
        return new SelectOptionCompare(build(), "WHERE ", value, " ");
    }

    public SelectOptionInitial isNotNull (String field) {
        return new SelectOptionInitial(build(), field, " IS NOT NULL ");
    }

    public SelectOptionInitial like (String value) {
        return new SelectOptionInitial(build(), "LIKE ", value, " ");
    }

    public SelectOptionInitial orderBy (String field, Order orderType) {
        return new SelectOptionInitial(build(), "ORDER BY ", field, " ", orderType.toString(), " ");
    }

    public SelectOptionInitial groupBy (String field) {
        return new SelectOptionInitial(build(), "GROUP BY ", field, " ");
    }

    public SelectOptionInitial limit (int limit) {
        return new SelectOptionInitial(build(), "LIMIT ", String.valueOf(limit), " ");
    }

    public String build() {
        return builder.toString();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
