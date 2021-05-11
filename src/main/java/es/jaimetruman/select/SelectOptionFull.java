package es.jaimetruman.select;

public final class SelectOptionFull extends SelectOptionInitial {
    public SelectOptionFull(String query, String... toAppend) {
        super(query, toAppend);
    }

    public SelectOptionCompare and (String value) {
        return new SelectOptionCompare(build(), "AND ", value);
    }

    public SelectOptionCompare or (String value) {
        return new SelectOptionCompare(build(), "OR ", value);
    }
}
