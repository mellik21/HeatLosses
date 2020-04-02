import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;



public class Test {
    public static void main(String[] s) {
        JFrame frame = new JFrame("JFrame Example");
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText("<html>Str1</html>");

        panel.add(label);

        frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        for(int i = 0; i < 5; i++) {
            String currentText = label.getText();
            String newText = currentText.substring(0, currentText.length()-7);
            label.setText(newText + "<br>New Line " + i + "</html>");
        }
    }
}