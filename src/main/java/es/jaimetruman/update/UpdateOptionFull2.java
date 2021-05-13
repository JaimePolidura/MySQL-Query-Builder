package es.jaimetruman.update;


import es.jaimetruman.Utils;
import es.jaimetruman.CanBuildQuery;

public final class UpdateOptionFull2 extends Update implements CanBuildQuery {
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

    @Override
    public String build () {
        return builder.toString();
    }

    @Override
    public String toString () {
        return this.builder.toString();
    }
}
