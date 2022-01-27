package es.jaimetruman;

import es.jaimetruman.insert.Insert;
import es.jaimetruman.insert.InsertOptionFinal;

public class Porro {
    public static void main(String[] args) {
        InsertOptionFinal insert = Insert.table("mitable")
                .fields("nombre", "dinero", "porro");

        String query1 = insert.values("jaime", 10, false);
        System.out.println(query1);

        String query2 = insert.values("juan", 2, true);
        System.out.println(query2);
    }
}
