package model.json;

public class CompleteJSON {
    public int speed;
    public float actual;
    public int races; // total race

    public CompleteJSON(int speed, float actual, int races) {
        this.speed = speed;
        this.actual = actual;
        this.races = races;
    }
}
