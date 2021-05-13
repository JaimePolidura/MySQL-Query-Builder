package es.jaimetruman.delete.delete;

import es.jaimetruman.Utils;
import es.jaimetruman.delete.update.UpdateOptionFull2;

import static es.jaimetruman.Utils.formatValue;

public final class DeleteOptionsCompare extends Delete {
    private final StringBuilder builder;

    public DeleteOptionsCompare(StringBuilder builder, String... toAppend) {
        this.builder = builder;

        this.builder.append(Utils.buildString(toAppend));
    }

    public UpdateOptionFull2 equal (Object value) {
        return new UpdateOptionFull2(builder, "= ", formatValue(value), " ");
    }

    public UpdateOptionFull2 bigger(Object value) {
        return new UpdateOptionFull2(builder, "> ", formatValue(value), " ");
    }

    public UpdateOptionFull2 smaller(Object value) {
        return new UpdateOptionFull2(builder, "< ", formatValue(value), " ");
    }

    public UpdateOptionFull2 smallerOrEqual (Object value) {
        return new UpdateOptionFull2(builder, "<= ", formatValue(value), " ");
    }

    public UpdateOptionFull2 biggerOrEqual(Object value) {
        return new UpdateOptionFull2(builder, ">= ", formatValue(value), " ");
    }
}
