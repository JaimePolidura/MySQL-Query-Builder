package es.jaimetruman.update;

import es.jaimetruman.Utils;

import static es.jaimetruman.Utils.formatValue;

public final class UpdateOptionCompare extends Update{
    private final StringBuilder builder;

    public UpdateOptionCompare(StringBuilder builder, String... toAppend) {
        this.builder = builder;

        this.builder.append(Utils.buildString(toAppend))
                .append(" ");
    }

    public UpdateOptionFull2 equal (Object value) {
        return new UpdateOptionFull2(builder, "= ", formatValue(value), " ");
    }

    public UpdateOptionFull2 bigger(Object value) {
        return new UpdateOptionFull2(builder, "> ", formatValue(value));
    }

    public UpdateOptionFull2 smaller(Object value) {
        return new UpdateOptionFull2(builder, "< ", formatValue(value));
    }

    public UpdateOptionFull2 smallerOrEqual (Object value) {
        return new UpdateOptionFull2(builder, "<= ", formatValue(value));
    }

    public UpdateOptionFull2 biggerOrEqual(Object value) {
        return new UpdateOptionFull2(builder, ">= ", formatValue(value));
    }

}
