package es.jaimetruman._shared.serializers;

import es.jaime.javaddd.domain.database.DatabaseTypeSerializer;

public final class BooleanSerialzier implements DatabaseTypeSerializer<Boolean> {
    @Override
    public String serialize(Boolean bool) {
        return bool == Boolean.TRUE ? "1" : "0";
    }
}
