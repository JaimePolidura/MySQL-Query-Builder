package es.jaimetruman.select;

import es.jaimetruman.ReadQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Select implements ReadQuery {
    public static SelectFromStep columns(String first_column, String ...rest_columns) {
        List<String> columns = new ArrayList<>();
        columns.add(first_column);
        columns.addAll(Arrays.asList(rest_columns));
        String columnsAsString = String.join(", ", columns);
        return new SelectFromStep("SELECT ", columnsAsString, " ");
    }

    public static SelectInitialStep from(String table) {
        return new SelectInitialStep("SELECT * FROM ", table, " ");
    }

    public static SelectInitialStep fromDistinct (String table) {
        return new SelectInitialStep("SELECT DISTINC FROM ", table, " ");
    }
}
