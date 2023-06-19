package es.jaimetruman._shared.serializers;

import es.jaime.javaddd.domain.database.DatabaseTypeSerializer;

public final class IntegerSerializer implements DatabaseTypeSerializer<Integer> {
    @Override
    public String serialize(Integer integer) {
        return integer.toString();
    }
}
