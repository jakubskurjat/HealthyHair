package com.example.healthyhair;

public class Cosmetic {

    private String cosmeticName;

    private String cosmeticSpec;

    private String cosmeticType;

    private String cosmeticComposition;

    private String cosmeticPorosity;

    private int cosmeticImage;

    public Cosmetic(String cosmeticName, String cosmeticSpec, String cosmeticType, String cosmeticComposition, String cosmeticPorosity, int cosmeticImage) {
        this.cosmeticName = cosmeticName;
        this.cosmeticSpec = cosmeticSpec;
        this.cosmeticType = cosmeticType;
        this.cosmeticComposition = cosmeticComposition;
        this.cosmeticPorosity = cosmeticPorosity;
        this.cosmeticImage = cosmeticImage;
    }

    public String getCosmeticName() {
        return cosmeticName;
    }

    public String getCosmeticSpec() {
        return cosmeticSpec;
    }

    public String getCosmeticType() {
        return cosmeticType;
    }

    public String getCosmeticComposition() {
        return cosmeticComposition;
    }

    public String getCosmeticPorosity() {
        return cosmeticPorosity;
    }

    public int getCosmeticImage() {
        return cosmeticImage;
    }
}
