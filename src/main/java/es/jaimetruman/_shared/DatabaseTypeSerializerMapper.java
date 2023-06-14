package es.jaimetruman._shared;

import es.jaime.javaddd.domain.database.DatabaseTypeSerializer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class DatabaseTypeSerializerMapper {
    private final Map<Class<?>, DatabaseTypeSerializer> mappings;

    public DatabaseTypeSerializerMapper() {
        this.mappings = new ConcurrentHashMap<>();
    }

    public <T> void addSerializer(Class<? extends T> type, DatabaseTypeSerializer<T> serializer) {
        this.mappings.put(type, serializer);
    }

    public <T> String serialize(T t) {
        if(t == null){
            return "";
        }
        if(!mappings.containsKey(t.getClass())){
            return t.toString();
        }

        return this.mappings.get(t.getClass())
                .serialize(t);
    }
}
