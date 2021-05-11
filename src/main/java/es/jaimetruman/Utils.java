package es.jaimetruman;

public final class Utils {
    private Utils () {}

    public static String formatValue (Object value) {
        String formatted;

        if(value instanceof String){
            formatted = "'" + value.toString() + "'";

        }else if (value instanceof Boolean){
            formatted = (Boolean) value ?
                    "1" :
                    "0";
        }else{
            formatted = value.toString();
        }

        return formatted;
    }
}
