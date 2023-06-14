package es.jaimetruman;

import es.jaimetruman.select.Select;

public final class Main {
    public static void main(String[] args) {
        Select.from("jaime").where("nombre").equal("jaime");
    }
}
