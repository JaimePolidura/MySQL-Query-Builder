package es.jaimetruman._shared.serializers;

import es.jaime.javaddd.domain.database.DatabaseTypeSerializer;

public final class LongSerializer implements DatabaseTypeSerializer<Long> {
    @Override
    public String serialize(Long aLong) {
        return aLong.toString();
    }
}
