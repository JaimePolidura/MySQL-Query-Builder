package es.jaimetruman._shared.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.jaime.javaddd.domain.database.DatabaseTypeSerializer;
import lombok.SneakyThrows;

import java.util.Collection;

public final class CollectionSerializer implements DatabaseTypeSerializer<Collection> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @SneakyThrows
    public String serialize(Collection objects) {
        return String.format("'%s'", objectMapper.writeValueAsString(objects));
    }
}
