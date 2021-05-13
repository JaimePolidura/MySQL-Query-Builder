package es.jaimetruman.delete.update;

import es.jaimetruman.Utils;

import static es.jaimetruman.Utils.formatValue;

public class UpdateOptionFull1 extends Update{
    protected final StringBuilder builder;

    public UpdateOptionFull1(StringBuilder builder, String... toAppend) {
        this.builder = builder;

        builder.append(Utils.buildString(toAppend)).append(" ");
    }

    public UpdateOptionFull1 andSet (String field, Object value) {
        return new UpdateOptionFull1(builder, ", ", field, " = ", formatValue(value));
    }

    public UpdateOptionCompare where (String value) {
        return new UpdateOptionCompare(builder, "WHERE ", value);
    }
}
