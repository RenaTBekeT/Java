import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Checkerboard {
    public static void drawImage(Graphics graphics) {
        // Fill the canvas with a checkerboard pattern
        int x = 0;
        int y = 0;
        int x1 = 40;
        int y1 = 0;

        for (int i = 0; i < 4; i++) {
            graphics.setColor(Color.black);
            graphics.fillRect(x, y, 40, 40);
            graphics.setColor(Color.white);
            graphics.fillRect(x1, y1, 40, 40);
            graphics.setColor(Color.black);
            graphics.fillRect(x + 80, y, 40, 40);
            graphics.setColor(Color.white);
            graphics.fillRect(x1 + 80, y1, 40, 40);
            graphics.setColor(Color.black);
            graphics.fillRect(x + 160, y, 40, 40);
            graphics.setColor(Color.white);
            graphics.fillRect(x1 + 160, y1, 40, 40);
            graphics.setColor(Color.black);
            graphics.fillRect(x + 240, y, 40, 40);
            graphics.setColor(Color.white);
            graphics.fillRect(x1 + 240, y1, 40, 40);
            graphics.setColor(Color.black);

            graphics.setColor(Color.white);
            graphics.fillRect(x, y + 40, 40, 40);
            graphics.setColor(Color.black);
            graphics.fillRect(x1, y1 + 40, 40, 40);
            graphics.setColor(Color.white);
            graphics.fillRect(x + 80, y + 40, 40, 40);
            graphics.setColor(Color.black);
            graphics.fillRect(x1 + 80, y1 + 40, 40, 40);
            graphics.setColor(Color.white);
            graphics.fillRect(x + 160, y + 40, 40, 40);
            graphics.setColor(Color.black);
            graphics.fillRect(x1 + 160, y1 + 40, 40, 40);
            graphics.setColor(Color.white);
            graphics.fillRect(x + 240, y + 40, 40, 40);
            graphics.setColor(Color.black);
            graphics.fillRect(x1 + 240, y1 + 40, 40, 40);
            graphics.setColor(Color.white);
            y += 80;
            y1 += 80;

        }
    }


    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            drawImage(graphics);
        }
    }
}