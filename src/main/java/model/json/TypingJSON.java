package model.json;

public class TypingJSON {
    public String roomId;
    public String letter;

    public TypingJSON(String roomId, String letter) {
        this.roomId = roomId;
        this.letter = letter;
    }

    @Override
    public String toString() {
        return "TypingJSON{" +
                "roomId='" + roomId + '\'' +
                ", letter='" + letter + '\'' +
                '}';
    }
}
