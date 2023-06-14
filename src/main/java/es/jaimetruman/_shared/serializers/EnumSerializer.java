package es.jaimetruman._shared.serializers;

import es.jaime.javaddd.domain.database.DatabaseTypeSerializer;

public final class EnumSerializer implements DatabaseTypeSerializer<Enum> {
    @Override
    public String serialize(Enum anEnum) {
        return String.format("'%s'", anEnum.toString());
    }
}
