package es.jaimetruman._shared.serializers;

import es.jaime.javaddd.domain.database.DatabaseTypeSerializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class LocalDateTimeSerializer implements DatabaseTypeSerializer<LocalDateTime> {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public String serialize(LocalDateTime localDateTime) {
        return localDateTime == null ? "0000-00-00 00:00:00" : String.format("'%s'", localDateTime.format(formatter));
    }
}
