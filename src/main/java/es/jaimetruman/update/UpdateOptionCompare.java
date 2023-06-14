package es.jaimetruman.update;

import es.jaimetruman.MySQLQueryBuilder;
import es.jaimetruman.Utils;

public final class UpdateOptionCompare extends Update{
    private final StringBuilder builder;

    public UpdateOptionCompare(String string, String... toAppend) {
        this.builder = new StringBuilder(string);

        this.builder.append(Utils.buildString(toAppend))
                .append(" ");
    }

    public UpdateOptionFull2 equal (Object value) {
        return new UpdateOptionFull2(builder.toString(), "= ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value), " ");
    }

    public UpdateOptionFull2 bigger(Object value) {
        return new UpdateOptionFull2(builder.toString(), "> ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value));
    }

    public UpdateOptionFull2 smaller(Object value) {
        return new UpdateOptionFull2(builder.toString(), "< ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value));
    }

    public UpdateOptionFull2 smallerOrEqual (Object value) {
        return new UpdateOptionFull2(builder.toString(), "<= ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value));
    }

    public UpdateOptionFull2 biggerOrEqual(Object value) {
        return new UpdateOptionFull2(builder.toString(), ">= ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value));
    }

}
