package model;

import utils.Utils;

public class AI extends Player {
    protected AI(Room room) {
        super(room, null);
        this.name = "AI";
        this.id = String.valueOf(Utils.getInstance().nextInt(9999999));

    }

    @Override
    public void startTyping() {
        super.startTyping();
        final int rdWPM = Utils.getInstance().nextInt(30) + 30;
        autoType(rdWPM).start();
    }

    @Override
    public void sendProfile() {
        // do nothing
    }

    @Override
    public void type(String letter) {

        System.out.println("I'am AI");
    }

    public Thread autoType(int wpm) {
        String[] words = typing.getWords();

        final float WORLD_PER_MILI = (60 / (float) wpm) * 1000;

        return new Thread(() -> {
            while (!complete) {
                try {

                    int size = words.length;
                    long time = (long) (WORLD_PER_MILI / size);
                    for (int i = 0; i < size; i++) {
                        typing.increase();
                        Thread.sleep(time);
                    }

                    typing.increase();
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("AI " + id + "complete!!");
        });
    }


    @Override
    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
