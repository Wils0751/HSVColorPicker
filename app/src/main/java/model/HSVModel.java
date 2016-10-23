package model;


import java.util.Observable;

/**
 * Created by ShannonWilson on 2016-10-12.
 */

public class HSVModel extends Observable {

    public static final float MIN_HUE = 0.0f;
    public static final float MIN_SAT = 0.0f;
    public static final float MIN_VAL = 0.0f;
    public static final float MAX_HUE = 359.0f;
    public static final float MAX_SAT = 100f;
    public static final float MAX_VAL = 100f;


    private float hue;
    private float saturation;
    private float value;

    public HSVModel() {
        this(MIN_HUE, MIN_SAT, MIN_VAL);
    }

    public HSVModel(float hue, float saturation, float value) {
        super();

        this.hue = hue;
        this.saturation = saturation;
        this.value = value;
    }

    public void asBlack() {
        this.setHSV(0, 0, 0);
    }

    public void asRed() {
        this.setHSV(0, 100, 100);
    }

    public void asLime() {
        this.setHSV(120, 100, 100);
    }

    public void asBlue() {
        this.setHSV(240, 100, 100);
    }

    public void asYellow() {
        this.setHSV(60, 100, 100);
    }

    public void asCyan() {
        this.setHSV(180, 100, 100);
    }

    public void asMagenta() {
        this.setHSV(300, 100, 100);
    }

    public void asSilver() {
        this.setHSV(0, 0, 75);
    }

    public void asGray() {
        this.setHSV(0, 0, 50);
    }

    public void asMaroon() {
        this.setHSV(0, 100, 50);
    }

    public void asOlive() {
        this.setHSV(60, 100, 50);
    }

    public void asGreen() {
        this.setHSV(120, 100, 50);
    }

    public void asPurple() {
        this.setHSV(300, 100, 50);
    }

    public void asTeal() {
        this.setHSV(180, 100, 50);
    }

    public void asNavy() {
        this.setHSV(240, 100, 50);
    }

    //Getters
    public float getHue() {
        return hue;
    }

    public float getSaturation() {
        return saturation;
    }

    public float getValue() {
        return value;
    }


    //Setters
    public void setHue(float hue) {
        this.hue = hue;
        this.updateObservers();

    }

    public void setSaturation(float saturation) {
        this.saturation = saturation / 100f;

        this.updateObservers();
    }

    public void setValue(float value) {
        this.value = value / 100f;
        this.updateObservers();
    }

    public void setHSV(float hue, float saturation, float value) {
        this.hue = hue;
        this.saturation = saturation / 100;
        this.value = value / 100;

        this.updateObservers();
    }

    private void updateObservers() {
        this.setChanged();
        this.notifyObservers();
    }


    @Override
    public String toString() {
        return "HSV [H=" + hue + " S=" + saturation + " V=" + value;
    }


}

