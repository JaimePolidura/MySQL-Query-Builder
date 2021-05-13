package es.jaimetruman.operations.update;

import es.jaimetruman.Utils;

public final class UpdateOptionInitial {
    private final StringBuilder builder;

    public UpdateOptionInitial (String table) {
        this.builder = new StringBuilder()
                .append("UPDATE ")
                .append(table)
                .append(" ");
    }

    public UpdateOptionFull1 set (String field, Object value) {
        return new UpdateOptionFull1(builder, "SET ", field, " = ", Utils.formatValue(value));
    }
}
