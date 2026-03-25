package es.jaimetruman.select;

import es.jaimetruman.MySQLQueryBuilder;
import es.jaimetruman.Utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class SelectComparationStep extends Select {
    private final StringBuilder builder;

    public SelectComparationStep(String query, String... toAppend) {
        this.builder = new StringBuilder();

        this.builder.append(query).append(Utils.buildString(toAppend));
    }

    public SelectLogicalStep equal (Object value) {
        return new SelectLogicalStep(builder.toString(), "= ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value), " ");
    }

    public SelectLogicalStep bigger(Object value) {
        return new SelectLogicalStep(builder.toString(), "> ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value), " ");
    }

    public SelectLogicalStep smaller(Object value) {
        return new SelectLogicalStep(builder.toString(), "< ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value), " ");
    }

    public SelectLogicalStep smallerOrEqual (Object value) {
        return new SelectLogicalStep(builder.toString(), "<= ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value), " ");
    }

    public SelectLogicalStep biggerOrEqual(Object value) {
        return new SelectLogicalStep(builder.toString(), ">= ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value), " ");
    }

    public SelectLogicalStep isTrue() {
        return new SelectLogicalStep(builder.toString(), "IS TRUE ", "");
    }

    public SelectLogicalStep isFalse() {
        return new SelectLogicalStep(builder.toString(), "IS FALSE ", "");
    }

    public SelectLogicalStep isNull() {
        return new SelectLogicalStep(builder.toString(), "IS NULL ", "");
    }

    public SelectLogicalStep isNotNull() {
        return new SelectLogicalStep(builder.toString(), "IS NOT NULL ", "");
    }

    public SelectLogicalStep in(Object... objects) {
        String inQueryPart = String.format("IN (%s)", Arrays.stream(objects)
                .map(it -> MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(it))
                .collect(Collectors.joining(", ")));

        return new SelectLogicalStep(builder.toString(), inQueryPart + " ", "");
    }
}
