package es.jaimetruman.insert;

import es.jaimetruman.QueryBuilder;
import es.jaimetruman.Utils;

import java.util.*;

import static java.util.stream.Collectors.*;

public final class Insert extends QueryBuilder {
    private final String table;
    private final List<String> fields;
    private final List<Object> values;

    public Insert(String table) {
        this.table = table;
        this.fields = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public static Insert of (String table) {
        return new Insert(table);
    }

    public Insert fields(String... names){
        this.fields.addAll(Arrays.asList(names));

        return this;
    }

    public String values (Object... valuesToAdd) {
        this.values.addAll(Arrays.asList(valuesToAdd));

        return build();
    }

    @Override
    public String build() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("INSERT INTO ")
                .append(table)
                .append(" (");

        stringBuilder.append(String.join(", ", fields));
        stringBuilder.append(") VALUES (");
        appendValuesToStringBuilder(stringBuilder);
        stringBuilder.append(")");

        return stringBuilder.toString();
    }

    private void appendValuesToStringBuilder (StringBuilder stringBuilder) {
        stringBuilder.append(
            values.stream()
                .map(Utils::formatValue)
                .collect(joining(", "))
        );
    }
}
