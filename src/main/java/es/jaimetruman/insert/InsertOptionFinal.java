package es.jaimetruman.insert;

import es.jaimetruman.Utils;
import es.jaimetruman.CanBuildQuery;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InsertOptionFinal extends Insert implements CanBuildQuery {
    private final StringBuilder builder;

    public InsertOptionFinal (StringBuilder builder) {
        this.builder = builder;
    }

    public String values (Object... values) {
        this.builder.append(
                        Stream.of(values)
                        .map(Utils::formatValue)
                        .collect(Collectors.joining(", ")))
                .append(")");

        return builder.toString();
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
