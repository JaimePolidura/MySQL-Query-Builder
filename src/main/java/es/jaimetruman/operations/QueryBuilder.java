package es.jaimetruman.operations;

public abstract class QueryBuilder {
    public abstract String build();

    @Override
    public String toString () {
        return build();
    }
}
