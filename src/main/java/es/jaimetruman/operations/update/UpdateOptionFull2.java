package es.jaimetruman.operations.update;


import es.jaimetruman.Utils;

public final class UpdateOptionFull2 {
    private final StringBuilder builder;

    public UpdateOptionFull2(StringBuilder builder, String... toAppend) {
        this.builder = builder;

        builder.append(Utils.buildString(toAppend));
    }

    public UpdateOptionCompare and (String value) {
        return new UpdateOptionCompare(builder, "AND ", value);
    }

    public UpdateOptionCompare or (String value) {
        return new UpdateOptionCompare(builder, "OR ", value);
    }

    public String build () {
        return builder.toString();
    }
}
