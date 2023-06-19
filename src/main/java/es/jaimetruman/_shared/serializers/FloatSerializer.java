package es.jaimetruman._shared.serializers;

import es.jaime.javaddd.domain.database.DatabaseTypeSerializer;

public final class FloatSerializer implements DatabaseTypeSerializer<Float> {
    @Override
    public String serialize(Float aFloat) {
        return aFloat.toString();
    }
}
