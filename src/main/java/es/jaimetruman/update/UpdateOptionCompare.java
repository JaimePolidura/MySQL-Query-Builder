package es.jaimetruman.update;

import es.jaimetruman.MySQLQueryBuilder;
import es.jaimetruman.Utils;

import java.util.Arrays;
import java.util.stream.Collectors;

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

    public UpdateOptionFull2 isTrue() {
        return new UpdateOptionFull2(builder.toString(), "IS TRUE ", "");
    }

    public UpdateOptionFull2 isFalse() {
        return new UpdateOptionFull2(builder.toString(), "IS FALSE ", "");
    }

    public UpdateOptionFull2 isNull() {
        return new UpdateOptionFull2(builder.toString(), "IS NULL ", "");
    }

    public UpdateOptionFull2 isNotNull() {
        return new UpdateOptionFull2(builder.toString(), "IS NOT NULL ", "");
    }

    public UpdateOptionFull2 in(Object... objects) {
        String inQueryPart = String.format("IN (%s)", Arrays.stream(objects)
                .map(it -> MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(it))
                .collect(Collectors.joining(", ")));

        return new UpdateOptionFull2(builder.toString(), inQueryPart + " ", "");
    }
}
