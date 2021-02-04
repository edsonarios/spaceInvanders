package org.fundacionjala.at13.spaceinvaders;

import java.awt.*;
import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;

public class Window extends JFrame {
    public static JFrame frame = new JFrame();
    public static JPanel panel = new JPanel();
    public static JLabel TITULO = new JLabel("", SwingConstants.CENTER);
    public static JLabel text = new JLabel("", SwingConstants.CENTER);
    public static JLabel ship = new JLabel(new ImageIcon("resources/spaceship.png"));
    public static JTextField caja = new JTextField();
    public static final int TOTAL = 75;
    public static int shipPositionX = TOTAL / 2;

    public Window() {

        init();

    }

    private void init() {

        Runnable r = new Runnable() {

            @Override
            public void run() {

                frame.getContentPane().add(panel);

                panel.setFocusable(true);
                panel.requestFocusInWindow();
                panel.setLayout(null);
                panel.setBackground(Color.BLACK);

                frame.setSize(new Dimension(500, 500));
                frame.setVisible(true);
                frame.setTitle("Jala AT13 - Space Invanders");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                text.setFont(new Font("arial", Font.PLAIN, 20));
                text.setBounds(10, 430, 460, 10);
                text.setForeground(Color.WHITE);
                panel.add(text);
                title();
                setText();
                SpaceShip();

            }

        };

        SwingUtilities.invokeLater(r);
        eventKey();

    }

    public void SpaceShip() {
        ship.setBounds(shipPositionX, 300, 20, 20);

        panel.add(ship);
    }

    public void eventKey() {
        KeyListener mov = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // System.out.println("keytyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // System.out.println("keyPressed");
                // System.out.println(" --- >> " + e.getKeyCode());
                if (e.getKeyCode() == 37) {

                    moveLeft();
                }
                if (e.getKeyCode() == 39) {
                    moveRight();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // System.out.println("keyReleased");

            }

        };
        panel.addKeyListener(mov);
    }

    public void setText() {
        String shipPosition = "";
        for (int i = 0; i < TOTAL; i++) {
            if (i == 0 || i == (TOTAL - 1)) {
                shipPosition += "|";
            } else {
                if (i == shipPositionX) {
                    shipPosition += "A";
                } else {
                    shipPosition += " ";
                }
            }

        }
        text.setText(shipPosition);
        ship.setBounds(shipPositionX, 300, 20, 20);
    }

    public void moveRight() {
        if (shipPositionX < (TOTAL - 2)) {

            shipPositionX++;
        }
        setText();
    }

    public void moveLeft() {
        if (shipPositionX > 1) {

            shipPositionX--;
        }
        setText();
    }

    public void title() {
        TITULO.setFont(new Font("arial", Font.PLAIN, 30));
        TITULO.setBounds(10, 10, 460, 30);
        TITULO.setForeground(Color.WHITE);
        TITULO.setText("AT13 - SPACE INVANDERS");
        panel.add(TITULO);
    }

}
