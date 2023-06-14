package es.jaimetruman.update;

import es.jaimetruman.MySQLQueryBuilder;
import es.jaimetruman.Utils;

public class UpdateOptionFull1 extends Update{
    protected final StringBuilder builder;

    public UpdateOptionFull1(String string, String... toAppend) {
        this.builder = new StringBuilder(string);

        builder.append(Utils.buildString(toAppend)).append(" ");
    }

    public UpdateOptionFull1 andSet (String field, Object value) {
        return new UpdateOptionFull1(builder.toString(), ", ", field, " = ", MySQLQueryBuilder.getDatabaseTypeMapper().map(value));
    }

    public UpdateOptionCompare where (String value) {
        return new UpdateOptionCompare(builder.toString(), "WHERE ", value);
    }
}
