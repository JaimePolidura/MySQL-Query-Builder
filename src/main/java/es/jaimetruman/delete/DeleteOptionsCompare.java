package es.jaimetruman.delete;

import es.jaimetruman.MySQLQueryBuilder;
import es.jaimetruman.Utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class DeleteOptionsCompare extends Delete {
    private final StringBuilder builder;

    public DeleteOptionsCompare(String query, String... toAppend) {
        this.builder = new StringBuilder(query);

        this.builder.append(Utils.buildString(toAppend));
    }

    public DeleteOptionsFull equal (Object value) {
        return new DeleteOptionsFull(builder.toString(), "= ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value), " ");
    }

    public DeleteOptionsFull bigger(Object value) {
        return new DeleteOptionsFull(builder.toString(), "> ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value), " ");
    }

    public DeleteOptionsFull smaller(Object value) {
        return new DeleteOptionsFull(builder.toString(), "< ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value), " ");
    }

    public DeleteOptionsFull smallerOrEqual (Object value) {
        return new DeleteOptionsFull(builder.toString(), "<= ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value), " ");
    }

    public DeleteOptionsFull biggerOrEqual(Object value) {
        return new DeleteOptionsFull(builder.toString(), ">= ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value), " ");
    }

    public DeleteOptionsFull isTrue() {
        return new DeleteOptionsFull(builder.toString(), "IS TRUE ", "");
    }

    public DeleteOptionsFull isFalse() {
        return new DeleteOptionsFull(builder.toString(), "IS FALSE ", "");
    }

    public DeleteOptionsFull isNull() {
        return new DeleteOptionsFull(builder.toString(), "IS NULL ", "");
    }

    public DeleteOptionsFull isNotNull() {
        return new DeleteOptionsFull(builder.toString(), "IS NOT NULL ", "");
    }

    public DeleteOptionsFull in(Object... objects) {
        String inQueryPart = String.format("IN (%s)", Arrays.stream(objects)
                .map(it -> MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(it))
                .collect(Collectors.joining(", ")));

        return new DeleteOptionsFull(builder.toString(), inQueryPart + " ", "");
    }
}
