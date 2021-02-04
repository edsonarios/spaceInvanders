package org.fundacionjala.at13.spaceinvaders;

public final class Main {

    private Main() {
    }

    public static void main(final String[] args) throws InterruptedException {
        System.out.println("Space Invaders!!! by AT13" + "\n");
        Window v1 = new Window();
        v1.setVisible(true);

        for (int i = 0; i < 10; i++) {
            // v1.text.setText(i + "");
            // System.out.println(i);
            // Thread.sleep(1400);
        }
    }
}
