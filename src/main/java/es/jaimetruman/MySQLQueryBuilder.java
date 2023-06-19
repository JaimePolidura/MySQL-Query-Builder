package es.jaimetruman;

import es.jaime.javaddd.domain.database.DatabaseTypeSerializer;
import es.jaimetruman._shared.DatabaseTypeSerializerMapper;
import es.jaimetruman._shared.serializers.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

public final class MySQLQueryBuilder {
    private final static DatabaseTypeSerializerMapper DATABASE_TYPE_SERIALIZER_MAPPER;

    static {
        DATABASE_TYPE_SERIALIZER_MAPPER = new DatabaseTypeSerializerMapper();
        DATABASE_TYPE_SERIALIZER_MAPPER.addSerializer(Boolean.class, new BooleanSerialzier());
        DATABASE_TYPE_SERIALIZER_MAPPER.addSerializer(Collection.class, new CollectionSerializer());
        DATABASE_TYPE_SERIALIZER_MAPPER.addSerializer(Enum.class, new EnumSerializer());
        DATABASE_TYPE_SERIALIZER_MAPPER.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        DATABASE_TYPE_SERIALIZER_MAPPER.addSerializer(String.class, new StringSerializer());
        DATABASE_TYPE_SERIALIZER_MAPPER.addSerializer(UUID.class, new UUIDSerializer());
        DATABASE_TYPE_SERIALIZER_MAPPER.addSerializer(Integer.class, new IntegerSerializer());
        DATABASE_TYPE_SERIALIZER_MAPPER.addSerializer(Double.class, new DoubleSerializer());
        DATABASE_TYPE_SERIALIZER_MAPPER.addSerializer(Short.class, new ShortSerializer());
        DATABASE_TYPE_SERIALIZER_MAPPER.addSerializer(Long.class, new LongSerializer());
        DATABASE_TYPE_SERIALIZER_MAPPER.addSerializer(Float.class, new FloatSerializer());
    }

    public static <T> void addCustomSerializer(Class<? extends T> type, DatabaseTypeSerializer<T> serializer) {
        DATABASE_TYPE_SERIALIZER_MAPPER.addSerializer(type, serializer);
    }

    public static DatabaseTypeSerializerMapper getDatabaseTypeSerializerMapper() {
        return DATABASE_TYPE_SERIALIZER_MAPPER;
    }
}
