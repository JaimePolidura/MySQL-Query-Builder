package es.jaimetruman.select;

import es.jaimetruman.Utils;

import static es.jaimetruman.Utils.formatValue;

public final class SelectOptionCompare extends Select {
    private final StringBuilder builder;

    public SelectOptionCompare(String query, String... toAppend) {
        this.builder = new StringBuilder();

        this.builder.append(query).append(Utils.buildString(toAppend));
    }

    public SelectOptionFull equal (Object value) {
        return new SelectOptionFull(builder.toString(), "= ", formatValue(value), " ");
    }

    public SelectOptionFull bigger(Object value) {
        return new SelectOptionFull(builder.toString(), "> ", formatValue(value), " ");
    }

    public SelectOptionFull smaller(Object value) {
        return new SelectOptionFull(builder.toString(), "< ", formatValue(value), " ");
    }

    public SelectOptionFull smallerOrEqual (Object value) {
        return new SelectOptionFull(builder.toString(), "<= ", formatValue(value), " ");
    }

    public SelectOptionFull biggerOrEqual(Object value) {
        return new SelectOptionFull(builder.toString(), ">= ", formatValue(value), " ");
    }
}
