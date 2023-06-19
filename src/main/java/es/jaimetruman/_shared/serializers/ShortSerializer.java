package es.jaimetruman._shared.serializers;

import es.jaime.javaddd.domain.database.DatabaseTypeSerializer;

public final class ShortSerializer implements DatabaseTypeSerializer<Short> {
    @Override
    public String serialize(Short aShort) {
        return aShort.toString();
    }
}
