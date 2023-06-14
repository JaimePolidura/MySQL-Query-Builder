package es.jaimetruman.insert;

import es.jaimetruman.CanBuildQuery;
import es.jaimetruman.MySQLQueryBuilder;
import es.jaimetruman.Utils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InsertOptionFinal extends Insert implements CanBuildQuery {
    private final StringBuilder builder;

    public InsertOptionFinal (StringBuilder builder) {
        this.builder = builder;
    }

    public String values (Object... values) {
        StringBuilder newStringBuilder = new StringBuilder(this.builder);

        newStringBuilder.append(Stream.of(values)
                        .map(value -> MySQLQueryBuilder.getDatabaseTypeMapper().map(value))
                        .collect(Collectors.joining(", ")))
                .append(")");

        return newStringBuilder.toString();
    }

    @Override
    public String build() {
        return builder.toString();
    }

    @Override
    public String toString () {
        return this.builder.toString();
    }
}
