package es.jaimetruman;

public final class Utils {
    private Utils () {}

    public static String buildString (String... strings) {
        StringBuilder builder = new StringBuilder();

        for (String string : strings) {
            builder.append(string);
        }

        return builder.toString();
    }
}
