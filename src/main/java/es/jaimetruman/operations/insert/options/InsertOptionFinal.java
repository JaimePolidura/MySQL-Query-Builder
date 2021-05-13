package es.jaimetruman.operations.insert.options;

import es.jaimetruman.Utils;
import es.jaimetruman.operations.insert.Insert;

import java.util.stream.Collectors;
import java.util.stream.Stream;


public final class InsertOptionFinal extends Insert {
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
}
