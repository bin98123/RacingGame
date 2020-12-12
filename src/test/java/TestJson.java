import com.google.gson.Gson;

import javax.json.Json;


class PlayerJSON {
    public String name;
    public float percentage;
}

public class TestJson {


    public static void main(String[] args) {
        PlayerJSON playerJSON = new PlayerJSON();
        playerJSON.name = "khang";
        playerJSON.percentage = 2;
        String json = new Gson().toJson(playerJSON);
        System.out.println("json = " + json);
    }
}
