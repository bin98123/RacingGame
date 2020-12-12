package model.json;

public class ProfileJSON extends JSONObject {
    public String roomId;

    public ProfileJSON(String roomId) {
        super();
        this.roomId = roomId;
    }
}
