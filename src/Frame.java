import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Frame extends JFrame  {
    JLabel labName = new JLabel("Потери теплоты в зданиях и сооружениях");

    public Frame() {

        super("Потери теплоты в зданиях и сооружениях");
       // setSize(new Dimension(300,500));
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Verdana", Font.PLAIN, 11);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Меню");
        menu.setFont(font);
        JPanel panel = new JPanel(new GridLayout(1,1));


        panel.add(labName);

        JMenuItem theory = new JMenuItem("Общая теория");
        theory.setFont(font);
        menu.add(theory);
        theory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();

               BufferedImage img1 = null;
                try {
                    img1 = ImageIO.read(new File("src/res/theory1.jpg"));

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                JLabel label1 = new JLabel();
                label1.setIcon(new ImageIcon(img1));
                panel.add(label1);
                panel.setBackground(Color.WHITE);
            }
        });


        JMenu lab1 = new JMenu("Теплопроводность через однослойную и многослойную плоскую стенку ");
        lab1.setFont(font);
        JMenuItem theory1 = new JMenuItem("Теория");
        JMenuItem prog1 = new JMenuItem("Расчеты");
        theory1.setFont(font);
        prog1.setFont(font);
        lab1.add(theory1);
        lab1.add(prog1);
        menu.add(lab1);

        theory1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();

                BufferedImage img1 = null;
                try {
                    img1 = ImageIO.read(new File("src/res/theory2.jpg"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                JLabel label1 = new JLabel();
                label1.setIcon(new ImageIcon(img1));
                panel.add(label1);
                panel.setBackground(Color.WHITE);
            }
        });
        prog1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                BufferedImage img1 = null;
                try {
                    img1 = ImageIO.read(new File("src/res/example1.jpg"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                JLabel label1 = new JLabel("Толщина стены(мм):");
                panel.add(label1);
                JTextField textField1 = new JTextField(10);
                panel.add(textField1);
                JLabel label2 = new JLabel("Наружная температура(t):");
                panel.add(label2);
                JTextField textField2 = new JTextField(10);
                panel.add(textField2);
                JLabel label3 = new JLabel("Температура в помещении (t):");
                panel.add(label3);
                JTextField textField3 = new JTextField(10);
                panel.add(textField3);
                JLabel label4 = new JLabel("Теплопроводность , Вт/(м·К):");
                panel.add(label4);
                JTextField textField4 = new JTextField(10);
                panel.add(textField4);
                JButton button = new JButton("Рассчитать");
                panel.add(button);

                JLabel label10 = new JLabel();
                label10.setIcon(new ImageIcon(img1));

                JLabel label5 = new JLabel("Плотность теплового потока:");
                panel.add(label5);
                JTextField textField5 = new JTextField(10);
                panel.add(textField5);
                panel.add(label10);
                panel.setBackground(Color.WHITE);
            }
        });

        JMenu lab2 = new JMenu("Теплопередача через многослойную плоскую стенку ");
        lab2.setFont(font);
        JMenuItem theory2 = new JMenuItem("Теория");
        JMenuItem prog2 = new JMenuItem("Расчеты");
        theory2.setFont(font);
        prog2.setFont(font);
        lab2.add(theory2);
        lab2.add(prog2);
        menu.add(lab2);
        theory2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();

                BufferedImage img1 = null;
                try {
                    img1 = ImageIO.read(new File("src/res/theory3.jpg"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                JLabel label1 = new JLabel();
                label1.setIcon(new ImageIcon(img1));
                panel.add(label1);
                panel.setBackground(Color.WHITE);
            }
        });
        prog2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JMenu lab3 = new JMenu(" Инфильтрация");
        lab3.setFont(font);
        JMenuItem theory3 = new JMenuItem("Теория");
        JMenuItem prog3 = new JMenuItem("Расчеты");
        theory3.setFont(font);
        prog3.setFont(font);
        lab3.add(theory3);
        lab3.add(prog3);
        menu.add(lab3);
        theory3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();

                BufferedImage img1 = null;
                try {
                    img1 = ImageIO.read(new File("src/res/theory4.jpg"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                JLabel label1 = new JLabel();
                label1.setIcon(new ImageIcon(img1));
                panel.add(label1);
                panel.setBackground(Color.WHITE);
            }
        });
        prog3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        menu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Выход");
        exitItem.setFont(font);
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(menu);

        setJMenuBar(menuBar);

        JScrollPane scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(400,900));
        add(scrollPane);

      //  add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}