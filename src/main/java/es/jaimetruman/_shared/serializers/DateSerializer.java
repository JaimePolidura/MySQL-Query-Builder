package es.jaimetruman._shared.serializers;

import es.jaime.javaddd.domain.database.DatabaseTypeSerializer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSerializer implements DatabaseTypeSerializer<Date> {
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String serialize(Date date) {
        return date == null ? "0000-00-00 00:00:00" : String.format("'%s'", FORMATTER.format(date));
    }
}
