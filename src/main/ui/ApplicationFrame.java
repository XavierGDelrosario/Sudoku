package ui;

import javax.swing.*;
import java.awt.*;

public class ApplicationFrame extends JFrame {
    public static int FRAME_WIDTH = 700;
    public static int FRAME_HEIGHT = 700;

    public ApplicationFrame() {
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(206, 206, 206));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
