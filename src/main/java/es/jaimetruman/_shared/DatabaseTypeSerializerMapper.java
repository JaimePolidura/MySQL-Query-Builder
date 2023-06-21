package es.jaimetruman._shared;

import es.jaime.javaddd.domain.database.DatabaseTypeSerializer;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class DatabaseTypeSerializerMapper {
    private final Map<Class<?>, DatabaseTypeSerializer> mappings;

    public DatabaseTypeSerializerMapper() {
        this.mappings = new ConcurrentHashMap<>();
    }

    public <T> void addSerializer(Class<? extends T> type, DatabaseTypeSerializer<T> serializer) {
        this.mappings.put(type, serializer);
    }

    public <T> String serialize(T toSerialize) {
        if(toSerialize == null){
            return "";
        }

        Optional<DatabaseTypeSerializer> typeSerializerOptional = findTypeSerializer(toSerialize.getClass());
        if(!typeSerializerOptional.isPresent()){
            return String.format("'%s'", toSerialize);
        }

        return typeSerializerOptional.get()
                .serialize(toSerialize);
    }

    private Optional<DatabaseTypeSerializer> findTypeSerializer(Class<?> clazz) {
        Class<?> actual = clazz;
        
        while (actual != Object.class) {
            if(mappings.containsKey(actual)){
                return Optional.of(mappings.get(actual));
            }

            actual = actual.getSuperclass();
        }

        return Optional.empty();
    }
}
