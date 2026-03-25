package es.jaimetruman.select;

public final class Count {
    public static String count(String column) {
        return String.format("COUNT(%s) ", column);
    }

    public static String countAll() {
        return "COUNT(*) ";
    }
}
