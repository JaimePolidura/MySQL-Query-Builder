package es.jaimetruman.select;

import es.jaimetruman.Utils;

public final class SelectFromStep {
    private final StringBuilder stringBuilder;

    public SelectFromStep(String ...toAppend) {
        this.stringBuilder = new StringBuilder(Utils.buildString(toAppend));
    }

    public SelectInitialStep from(String table) {
        return new SelectInitialStep(stringBuilder.toString(), "FROM ", table, " ");
    }
}
