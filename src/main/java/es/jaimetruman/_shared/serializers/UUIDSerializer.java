package es.jaimetruman._shared.serializers;

import es.jaime.javaddd.domain.database.DatabaseTypeSerializer;

import java.util.UUID;

public final class UUIDSerializer implements DatabaseTypeSerializer<UUID> {
    @Override
    public String serialize(UUID uuid) {
        return String.format("'%s'", uuid.toString());
    }
}
