package es.jaimetruman.update;


import es.jaimetruman.CanBuildQuery;
import es.jaimetruman.Utils;

public final class UpdateOptionFull2 extends Update implements CanBuildQuery {
    private final StringBuilder builder;

    public UpdateOptionFull2(String query, String... toAppend) {
        this.builder = new StringBuilder();
        this.builder.append(query);

        builder.append(Utils.buildString(toAppend));
    }

    public UpdateOptionCompare and (String value) {
        return new UpdateOptionCompare(builder, "AND ", value);
    }

    public UpdateOptionCompare or (String value) {
        return new UpdateOptionCompare(builder, "OR ", value);
    }

    @Override
    public String build() {
        return builder.toString();
    }

    @Override
    public String toString () {
        return build();
    }
}
