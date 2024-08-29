import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class HorizontalLines {
    public static void drawImage(Graphics graphics) {
        // Create a function that takes 3 parameters and draws a single line
        // Parameters: the x and y coordinates of the line's starting point and the graphics
        // The function shall draw a 50-pixel long horizontal line from that point
        // Draw at least 3 lines with that function using a loop

    int x = 80;
    int y = 240;
    int x1 = 80;
    int y1 = 80;
    horizonal(x, y, x1, y1, graphics);

    }
public static void  horizonal (int x, int y, int x1, int y1, Graphics graphics1) {

    for (int i = 0; i < 3; i++) {
        graphics1.drawLine(x, y, x1,  y1 );
        x += 80;
        x1 += 80;


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