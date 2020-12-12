package model;

import java.util.StringTokenizer;

public class Typing {
    private int index;
    private String text;

    private Player player;

    // first typing, first letter
    private long start = 0;
    /**
     * - Word typing current
     */
    private int word = 1;

    /**
     * counter total mistake when typing
     */
    private int mistake = 0;

    private Typing(Player player, String text) {
        this.player = player;
        this.text = text;
        this.index = 0;
    }


    public static Typing of(Player player, String text) {
        return new Typing(player, text);
    }


    public boolean type(String letter) {
        if (!getPlayer().complete && String.valueOf(text.charAt(index)).equals(letter)) {

            // check complete one word
            if (letter.equals(" ")) {
                word++;
            }
            // increase index
            index++;
            // check complete
            checkCompleted();
            return true;
        }
        return false;
    }

    private void checkCompleted() {
        if (index >= text.length()) {
            player.setComplete(true);
        }
    }


    public int percentage() {
        return (int) ((index / (float) text.length()) * 100);
    }

    public int getIndex() {
        return index;
    }

    public void increase() {
        this.index++;

        checkCompleted();
    }

    public int speed() {
        final long current = System.currentTimeMillis();
        final long duration = current - start;
        final float second = duration / (float) 1000;
        // word per minute
        final float wordPerSecond = second / word;
        return (int) (60 / wordPerSecond);
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getWords() {
        return text.split(" ");
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public int getWord() {
        return word;
    }

    public float actual() {
        int correct = text.length() - mistake;
        return (correct / (float) text.length()) * 100;
    }
}
