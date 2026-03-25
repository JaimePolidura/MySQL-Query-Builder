package es.jaimetruman.select;

import es.jaimetruman.CanBuildQuery;
import es.jaimetruman.Utils;

public final class SelectLogicalStep extends SelectInitialStep implements CanBuildQuery {
    private final StringBuilder builder;

    public SelectLogicalStep(String query, String... toAppend) {
        this.builder = new StringBuilder();
        this.builder.append(query).append(Utils.buildString(toAppend));
    }

    public SelectComparationStep and(String value) {
        return new SelectComparationStep(build(), "AND ", value, " ");
    }

    public SelectComparationStep or(String value) {
        return new SelectComparationStep(build(), "OR ", value, " ");
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
