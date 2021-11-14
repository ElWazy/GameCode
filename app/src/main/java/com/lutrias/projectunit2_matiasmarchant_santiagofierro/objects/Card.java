package com.lutrias.projectunit2_matiasmarchant_santiagofierro.objects;

public class Card {
    private int id;
    private int stock;
    private String[] tarjeta = {"Tarjeta bronce", "Tarjeta plata", "Tarjeta Oro", "Tarjeta Platino"};
    private int[] precios = {2500, 5000, 12000, 25000};

    public Card() {
    }

    public String[] getTarjeta() {
        return tarjeta;
    }

    public int cal(int val1, String val2) {
        switch (val2){
            case "Tarjeta bronce":
                return precios[0] * val1;
            case "Tarjeta plata":
                return precios[1] * val1;
            case "Tarjeta Oro":
                return precios[2] * val1;
            case "Tarjeta Platino":
                return precios[3] * val1;
            default:
                return 0;
        }


    }
}
