package es.jaimetruman._shared.serializers;

import es.jaime.javaddd.domain.database.DatabaseTypeSerializer;

public final class DoubleSerializer implements DatabaseTypeSerializer<Double> {
    @Override
    public String serialize(Double aDouble) {
        return aDouble.toString();
    }
}
