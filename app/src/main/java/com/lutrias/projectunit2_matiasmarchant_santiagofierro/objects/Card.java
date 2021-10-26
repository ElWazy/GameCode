package com.lutrias.projectunit2_matiasmarchant_santiagofierro.objects;

public class Card {
    private int id;
    private int stock;
    private String[] tarjeta = {"Tarjeta bronce", "Tarjeta plata", "Tarjeta Oro", "Tarjeta Platino"};
    private int[] precios = {2500, 5000, 12000, 25000};

    public Card() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String[] getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String[] tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
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
