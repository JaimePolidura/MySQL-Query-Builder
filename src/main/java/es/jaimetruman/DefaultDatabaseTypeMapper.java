package es.jaimetruman;

import es.jaime.javaddd.domain.database.DatabaseTypeMapper;

import java.util.Collection;
import java.util.UUID;

public final class DefaultDatabaseTypeMapper implements DatabaseTypeMapper {
    @Override
    public <T> String map(T value) {
        String formatted;

        if(value == null){
            return "null";
        }else if(value instanceof String || value instanceof UUID){
            formatted = "'" + value.toString() + "'";
        }else if (value instanceof Boolean) {
            formatted = (Boolean) value ? "1" : "0";
        }else if(value instanceof Enum){
            formatted = "'" + value.toString()+  "'";
        }else if(value instanceof Collection){
            formatted = "'" + value.toString() + "'";
        }else{
            formatted = value.toString();
        }

        return formatted;
    }
}
