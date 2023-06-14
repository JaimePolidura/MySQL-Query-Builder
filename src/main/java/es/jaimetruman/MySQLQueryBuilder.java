package es.jaimetruman;

import es.jaime.javaddd.domain.database.DatabaseTypeMapper;

public final class MySQLQueryBuilder {
    private static DatabaseTypeMapper databaseTypeMapper = new DefaultDatabaseTypeMapper();

    public static void setDatabaseTypeMapper(final DatabaseTypeMapper newDatabaseTypeMapper) {
        databaseTypeMapper = newDatabaseTypeMapper;
    }

    public static DatabaseTypeMapper getDatabaseTypeMapper() {
        return databaseTypeMapper;
    }
}
