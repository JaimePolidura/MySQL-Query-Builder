package es.jaimetruman.insert;


public final class InsertOptionInitial extends Insert {
    private final StringBuilder builder;

    public InsertOptionInitial(String table) {
        this.builder = new StringBuilder()
                .append("INSERT INTO ")
                .append(table)
                .append(" (");
    }

    public InsertOptionFinal fields (String... fields) {
        this.builder.append(String.join(", ", fields))
                .append(") VALUES (");

        return new InsertOptionFinal(builder);
    }
}
