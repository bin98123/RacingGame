package utils;

import com.google.gson.Gson;

import java.util.Random;

public final class Utils {
    private static final Utils INSTANCE = new Utils();
    private final Random random;
    public final Gson GSON;

    private Utils() {
        random = new Random();
        GSON = new Gson();
    }

    public static Utils getInstance() {
        return INSTANCE;
    }

    public int nextInt(int limit) {
        return random.nextInt(limit);
    }
}
