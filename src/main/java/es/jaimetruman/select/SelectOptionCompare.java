package es.jaimetruman.select;

import es.jaimetruman.MySQLQueryBuilder;
import es.jaimetruman.Utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class SelectOptionCompare extends Select {
    private final StringBuilder builder;

    public SelectOptionCompare(String query, String... toAppend) {
        this.builder = new StringBuilder();

        this.builder.append(query).append(Utils.buildString(toAppend));
    }

    public SelectOptionFull equal (Object value) {
        return new SelectOptionFull(builder.toString(), "= ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value), " ");
    }

    public SelectOptionFull bigger(Object value) {
        return new SelectOptionFull(builder.toString(), "> ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value), " ");
    }

    public SelectOptionFull smaller(Object value) {
        return new SelectOptionFull(builder.toString(), "< ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value), " ");
    }

    public SelectOptionFull smallerOrEqual (Object value) {
        return new SelectOptionFull(builder.toString(), "<= ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value), " ");
    }

    public SelectOptionFull biggerOrEqual(Object value) {
        return new SelectOptionFull(builder.toString(), ">= ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value), " ");
    }

    public SelectOptionFull isTrue() {
        return new SelectOptionFull(builder.toString(), "IS TRUE ", "");
    }

    public SelectOptionFull isFalse() {
        return new SelectOptionFull(builder.toString(), "IS FALSE ", "");
    }

    public SelectOptionFull isNull() {
        return new SelectOptionFull(builder.toString(), "IS NULL ", "");
    }

    public SelectOptionFull isNotNull() {
        return new SelectOptionFull(builder.toString(), "IS NOT NULL ", "");
    }

    public SelectOptionFull in(Object... objects) {
        String inQueryPart = String.format("IN (%s)", Arrays.stream(objects)
                .map(it -> MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(it))
                .collect(Collectors.joining(", ")));

        return new SelectOptionFull(builder.toString(), inQueryPart + " ", "");
    }
}
