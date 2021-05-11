package es.jaimetruman.select;

import static es.jaimetruman.Utils.formatValue;

public final class SelectOptionCompare extends Select {
    private final StringBuilder builder;

    public SelectOptionCompare(String query, String... toAppend) {
        StringBuilder builder = new StringBuilder();
        builder.append(query);

        for (String wordToAppend : toAppend) {
            builder.append(wordToAppend);
        }

        builder.append(" ");

        this.builder = builder;
    }

    public SelectOptionFull equal (Object value) {
        return new SelectOptionFull(build(), "= ", formatValue(value));
    }

    public SelectOptionFull bigger(Object value) {
        return new SelectOptionFull(build(), ">", formatValue(value));
    }

    public SelectOptionFull smaller(Object value) {
        return new SelectOptionFull(build(), "<", formatValue(value));
    }

    public SelectOptionFull smallerOrEqual (Object value) {
        return new SelectOptionFull(build(), "<=", formatValue(value));
    }

    public SelectOptionFull biggerOrEqual(Object value) {
        return new SelectOptionFull(build(), ">=", formatValue(value));
    }

    @Override
    public String build() {
        return builder.toString();
    }
}
