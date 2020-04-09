import com.sun.org.apache.xml.internal.security.utils.JDKXPathAPI;
import javafx.scene.control.Hyperlink;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Frame1 extends JFrame {


    public Frame1() {
        super("Потери теплоты в зданиях и сооружениях");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Verdana", Font.PLAIN, 10);
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());

        JPanel panel0 = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = getResultPane1();
        JPanel panel3 = new JPanel();
        JPanel panel4 = getResultPane2();
        JPanel panel5 = new JPanel();
        JPanel panel6 = getResultPane3();
        JPanel panel7 = getResultPane7();

        addImage("src/res/theory1.jpg",panel0);
        addImage("src/res/theory2.jpg", panel1);
        addImage("src/res/theory3.jpg", panel3);
        addImage("src/res/theory4.jpg", panel5);

        JScrollPane p5 = new JScrollPane(panel5, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane p0 = new JScrollPane(panel0, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tabbedPane.addTab("Теория", p0);
        tabbedPane.addTab("1. Теория ", panel1);
        tabbedPane.addTab("1. Практика ", panel2);
        tabbedPane.addTab("2. Теория ", panel3);
        tabbedPane.addTab("2. Практка ", panel4);
        tabbedPane.addTab("3. Теория ", p5);
        tabbedPane.addTab("3. Практика ", panel6);
        tabbedPane.addTab("Литература", panel7);

        content.add(tabbedPane, BorderLayout.CENTER);

        getContentPane().add(content);

        Dimension locked = new Dimension(700, 700);
        setPreferredSize(locked);
        setMaximumSize(locked);
        setPreferredSize(locked);
        setResizable(false);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addImage(String url, JPanel panel) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(url));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        JLabel label1 = new JLabel();
        label1.setIcon(new ImageIcon(img));
        panel.add(label1);
        panel.setBackground(Color.WHITE);
    }

    private JPanel getResultPane1() {
        JPanel result = new JPanel();
        JPanel left = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        left.add(new JLabel("Толщина кирпича(δ,м): "), gbc);
        gbc.gridy++;

        left.add(new JLabel("Наружная температура(tн,°С):"), gbc);
        gbc.gridy++;

        left.add(new JLabel("Температура в помещении(tв,°С):"), gbc);

        gbc.gridy++;
        left.add(new JLabel("Теплопроводность(λ,Вт/(м·К)):"), gbc);

        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx++;
        gbc.gridy = 0;
        JTextField f1 = new JTextField(10);
        left.add(f1, gbc);

        gbc.gridy++;
        JTextField f2 = new JTextField(10);
        left.add(f2, gbc);
        gbc.gridy++;
        JTextField f3 = new JTextField(10);
        left.add(f3, gbc);
        gbc.gridy++;
        JTextField f4 = new JTextField(10);
        left.add(f4, gbc);


        gbc.gridy++;
        JLabel br = new JLabel("<html> <br> <br> <br> </html>");
        left.add(br, gbc);
        gbc.gridy++;
        JButton button = new JButton("Рассчитать");
        gbc.gridx = 0;
        gbc.gridwidth = 200;
        gbc.gridy++;
        left.add(button, gbc);


        JLabel br1 = new JLabel("<html> <br> <br> <br> </html>");
        left.add(br1, gbc);
        gbc.gridwidth = 200;
        gbc.gridy++;

        JLabel resultLabel = new JLabel("Плотность теплового потока:");
        JTextField res1 = new JTextField(10);
        left.add(resultLabel, gbc);
        gbc.gridy++;
        left.add(res1, gbc);

        left.setBackground(Color.WHITE);
        result.add(left);


        result.setLayout(new GridLayout(1, 2));

        JPanel r = new JPanel(new FlowLayout());
        addImage("src/res/example1.jpg", r);
        JLabel form = new JLabel("Плотность теплового потока рассчитывается");
        JLabel form1 = new JLabel("по формуле:");
        r.add(form);
        r.add(form1);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/res/form1.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        JLabel label1 = new JLabel();
        label1.setIcon(new ImageIcon(img));
        r.add(label1, gbc);


        r.setBackground(Color.WHITE);
        result.add(r);


        button.addActionListener(e -> {
            res1.setText("");
            double thickness = getDouble(f1.getText());
            double tOutside = getDouble(f2.getText());
            double tInside = getDouble(f3.getText());
            double thermalConductivity = getDouble(f4.getText());

            double res = (thermalConductivity / thickness) * (tInside - tOutside);
            res1.setText(String.valueOf(res));

        });
        result.setBackground(Color.WHITE);
        return result;
    }

    private double getDouble(String s) {
        if (s.contains(",")) {
            s = s.replace(",", ".");
        }
        if (s.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(s);
    }

    private JPanel getResultPane2() {
        JPanel result = new JPanel();
        JPanel left = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        left.add(new JLabel("Толщина стены(δ,м):"), gbc);

        gbc.gridy++;
        left.add(new JLabel("Теплопроводность стены(λ,Вт/(м·К)):"), gbc);

        gbc.gridy++;
        left.add(new JLabel("Толщина утеплителя(δ,м):"), gbc);

        gbc.gridy++;
        left.add(new JLabel("<html>Теплопроводность <br> утеплителя(λ,Вт/(м·К):</html>"), gbc);

        gbc.gridy++;
        left.add(new JLabel("αв:"),gbc);
        gbc.gridy++;
        left.add(new JLabel("αн:"),gbc);

        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx++;
        gbc.gridy = 0;
        JTextField f1 = new JTextField(10);
        left.add(f1, gbc);
        gbc.gridy++;
        JTextField f2 = new JTextField(10);
        left.add(f2, gbc);
        gbc.gridy++;
        JTextField f3 = new JTextField(10);
        left.add(f3, gbc);
        gbc.gridy++;
        JTextField f4 = new JTextField(10);
        left.add(f4, gbc);
        gbc.gridy++;
        JTextField f5 = new JTextField(10);
        left.add(f5, gbc);
        gbc.gridy++;
        JTextField f6 = new JTextField(10);
        left.add(f6, gbc);

        gbc.gridy++;
        JLabel br = new JLabel("<html> <br> <br> <br> </html>");
        left.add(br, gbc);
        gbc.gridy++;
        JButton button = new JButton("Рассчитать");
        gbc.gridx = 0;
        gbc.gridwidth = 200;
        gbc.gridy++;
        left.add(button, gbc);

        JLabel br1 = new JLabel("<html> <br> <br> <br> </html>");
        left.add(br1, gbc);
        gbc.gridwidth = 200;
        gbc.gridy++;

        JLabel resultLabel = new JLabel("Термическое сопротивлеие:");
        JTextField res1 = new JTextField(10);
        left.add(resultLabel, gbc);
        gbc.gridy++;
        left.add(res1, gbc);

        JLabel br2 = new JLabel("<html> <br> <br> <br> </html>");
        left.add(br2, gbc);
        gbc.gridwidth = 200;
        gbc.gridy++;

        JLabel resultLabel1 = new JLabel("Коэффициент теплопередачи:");
        JTextField res2 = new JTextField(10);
        left.add(resultLabel1, gbc);
        gbc.gridy++;
        left.add(res2, gbc);


        left.setBackground(Color.WHITE);
        result.add(left);

        result.setLayout(new GridLayout(0, 2));

        JPanel r = new JPanel(new FlowLayout());
        addImage("src/res/example2.jpg", r);
        JLabel form1 = new JLabel("<html> <Термическое сопроивление утепленной стены <br> вычисляется по формуле: </html>");
        JLabel form2 = new JLabel("<html> Коэффициент теплопередачи утепленной <br> бетонной стены вычисляется по формуле:</html> ");

        r.add(form1);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/res/form2.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        JLabel label1 = new JLabel();
        label1.setIcon(new ImageIcon(img));
        r.add(label1, gbc);

        r.add(form2);
        BufferedImage img1 = null;
        try {
            img1 = ImageIO.read(new File("src/res/form3.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        JLabel label2 = new JLabel();
        label2.setIcon(new ImageIcon(img1));
        r.add(label2, gbc);

        JLabel answer = new JLabel();
        r.add(answer);

        r.setBackground(Color.WHITE);
        result.add(r);


        button.addActionListener(e -> {
            res1.setText("");
            res2.setText("");
            double ts = getDouble(f1.getText());
            double tu = getDouble(f3.getText());

            double teps = getDouble(f2.getText());
            double tepu = getDouble(f4.getText());

            double av = getDouble(f5.getText());
            double an = getDouble(f6.getText());

            double rst = ts/teps + tu/tepu;
            double k = Math.pow(((1/av)+rst+(1/an)),-1);

            res1.setText(String.valueOf(rst));
            res2.setText(String.valueOf(k));

        });

        return result;
    }

    private JPanel getResultPane3() {
        JPanel panel = new JPanel(new GridLayout(0, 2));
        JPanel result = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        result.add(new JLabel("Температура в помещении(tп,°С):"), gbc);

        gbc.gridy++;
        result.add(new JLabel("Температура снаружи(tн,°С):"), gbc);

        gbc.gridy++;
        result.add(new JLabel("Объем помещения(Vп,м³):"), gbc);

        gbc.gridy++;
        result.add(new JLabel("Потери теплоты(Qн,Вт):"), gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;

        gbc.gridx++;
        gbc.gridy = 0;
        JTextField f1 = new JTextField(10);
        result.add(f1, gbc);
        gbc.gridy++;
        JTextField f2 = new JTextField(10);
        result.add(f2, gbc);
        gbc.gridy++;
        JTextField f3 = new JTextField(10);
        result.add(f3, gbc);
        gbc.gridy++;
        JTextField f4 = new JTextField(10);
        result.add(f4, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy++;
        gbc.gridx = 0;

        JLabel br2 = new JLabel("<html> <br> <br> <br> </html>");
        result.add(br2, gbc);


        JLabel form1 = new JLabel("Коэффициент инфильтрации вычисляется по формуле:");
        result.add(form1, gbc);

        BufferedImage img1 = null;
        try {
            img1 = ImageIO.read(new File("src/res/form4.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        gbc.gridy++;
        gbc.gridx++;
        JLabel label2 = new JLabel();
        label2.setIcon(new ImageIcon(img1));
        result.add(label2, gbc);

        gbc.gridx=0;
        gbc.gridy++;
        JButton button = new JButton("Рассчитать");
        result.add(button, gbc);

        gbc.gridy++;
        JLabel br1 = new JLabel("<html> <br> </html>");
        result.add(br1, gbc);
        gbc.gridy++;
        JLabel resultLabel = new JLabel("Термическое сопротивление:");
        result.add(resultLabel, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        JTextField res1 = new JTextField(10);
        result.add(res1, gbc);

        button.addActionListener(e -> {

            double tp = getDouble(f1.getText());
            double tn = getDouble(f2.getText());
            double v = getDouble(f3.getText());
            double q = getDouble(f4.getText());

            double res = (3*q) / (v*(tp-tn));
            res1.setText(String.valueOf(res));
            System.out.println(res);
        });


        result.setBackground(Color.WHITE);
        panel.add(result);
        panel.setBackground(Color.WHITE);
        return panel;

    }

    private JPanel getResultPane7(){
        JPanel result = new JPanel();
        JLabel label = new JLabel("<html> <br> <br> <br> Энергосбережение : учеб.-метод. пособие для студентов <br>" +
                "химико-технологических специальностей / А. С. Дмитриченко </html>");
        JLabel link = new JLabel("<html> <br> <br> <br> <font color='blue'> Читать книгу онлайн </font> </html>");
        String url = "https://elib.belstu.by/bitstream/123456789/25974/1/Jenergosberezhenie_Dmitrichenko_2018.pdf";

        link.setCursor(new Cursor(Cursor.HAND_CURSOR));
        link.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (URISyntaxException | IOException ex) {

                }
            }
        });
        result.add(label);
        result.add(link);
        result.setBackground(Color.WHITE);
        return result;
    }
}

