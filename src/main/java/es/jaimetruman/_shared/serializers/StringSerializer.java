package es.jaimetruman._shared.serializers;

import es.jaime.javaddd.domain.database.DatabaseTypeSerializer;

public final class StringSerializer implements DatabaseTypeSerializer<String> {
    @Override
    public String serialize(String s) {
        return String.format("'%s'", s);
    }
}
