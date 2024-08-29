import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {

    public static void drawImage(Graphics graphics) {
        // Draw four different size and color rectangles
        // Avoid code duplication!
        int x = 10;
        int y = 10;
        int x1 = 40;
        int y1 = 40;


        ArrayList <Color> colors = new ArrayList<>();
        Collections.addAll(colors, Color.blue, Color.red, Color.green, Color.gray);
        for (int i = 0; i < 4; i++) {
            graphics.setColor(colors.get(i));
            graphics.drawRect(x, y, x1, y1);

            x += 50;
            y1 += 10;
        }
    }


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