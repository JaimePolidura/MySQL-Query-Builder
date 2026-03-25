package es.jaimetruman.select;

import es.jaimetruman.CanBuildQuery;
import es.jaimetruman.Utils;

public class SelectInitialStep extends Select implements CanBuildQuery {
    private final StringBuilder builder;

    public SelectInitialStep(String... toAppend) {
        this.builder = new StringBuilder(Utils.buildString(toAppend));
    }

    public SelectComparationStep where(String value) {
        return new SelectComparationStep(build(), "WHERE ", value, " ");
    }

    public SelectInitialStep isNotNull(String field) {
        return new SelectInitialStep(build(), field, " IS NOT NULL ");
    }

    public SelectInitialStep like(String value) {
        return new SelectInitialStep(build(), "LIKE ", value, " ");
    }

    public SelectInitialStep orderBy(String field, Order orderType) {
        return new SelectInitialStep(build(), "ORDER BY ", field, " ", orderType.toString(), " ");
    }

    public SelectInitialStep groupBy(String field) {
        return new SelectInitialStep(build(), "GROUP BY ", field, " ");
    }

    public SelectInitialStep limit(int limit) {
        return new SelectInitialStep(build(), "LIMIT ", String.valueOf(limit), " ");
    }

    public SelectInitialStep limit(int limit, int offset) {
        return new SelectInitialStep(build(), "LIMIT ", String.valueOf(limit), " ,", String.valueOf(offset), " ");
    }

    @Override
    public String build() {
        return builder.toString();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
