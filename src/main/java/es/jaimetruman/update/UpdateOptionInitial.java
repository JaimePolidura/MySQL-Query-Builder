package es.jaimetruman.update;

import es.jaimetruman.MySQLQueryBuilder;

public final class UpdateOptionInitial extends Update{
    private final StringBuilder builder;

    public UpdateOptionInitial (String table) {
        this.builder = new StringBuilder()
                .append("UPDATE ")
                .append(table)
                .append(" ");
    }

    public UpdateOptionFull1 set (String field, Object value) {
        return new UpdateOptionFull1(builder.toString(), "SET ", field, " = ", MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value));
    }
}
