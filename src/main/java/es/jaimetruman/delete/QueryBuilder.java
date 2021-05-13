package es.jaimetruman.delete;

public abstract class QueryBuilder {
    public abstract String build();

    @Override
    public String toString () {
        return build();
    }
}
