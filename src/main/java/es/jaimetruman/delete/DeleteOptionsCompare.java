package es.jaimetruman.delete;

import es.jaimetruman.MySQLQueryBuilder;
import es.jaimetruman.Utils;

public final class DeleteOptionsCompare extends Delete {
    private final StringBuilder builder;

    public DeleteOptionsCompare(String query, String... toAppend) {
        this.builder = new StringBuilder(query);

        this.builder.append(Utils.buildString(toAppend));
    }

    public DeleteOptionsFull equal (Object value) {
        return new DeleteOptionsFull(builder.toString(), "= ", MySQLQueryBuilder.getDatabaseTypeMapper().map(value), " ");
    }

    public DeleteOptionsFull bigger(Object value) {
        return new DeleteOptionsFull(builder.toString(), "> ", MySQLQueryBuilder.getDatabaseTypeMapper().map(value), " ");
    }

    public DeleteOptionsFull smaller(Object value) {
        return new DeleteOptionsFull(builder.toString(), "< ", MySQLQueryBuilder.getDatabaseTypeMapper().map(value), " ");
    }

    public DeleteOptionsFull smallerOrEqual (Object value) {
        return new DeleteOptionsFull(builder.toString(), "<= ", MySQLQueryBuilder.getDatabaseTypeMapper().map(value), " ");
    }

    public DeleteOptionsFull biggerOrEqual(Object value) {
        return new DeleteOptionsFull(builder.toString(), ">= ", MySQLQueryBuilder.getDatabaseTypeMapper().map(value), " ");
    }
}
