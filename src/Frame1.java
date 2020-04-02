import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Frame1 extends JFrame {


    public Frame1() {
        super("Тестовое окно");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Verdana", Font.PLAIN, 10);
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        JPanel panel2 = getResultPane1();
        JPanel panel3 = new JPanel();
        JPanel panel4 = getResultPane2();
        JPanel panel5 = new JPanel();
        JPanel panel6 = getResultPane3();

        addImage("src/res/theory2.jpg", panel1);
        addImage("src/res/theory3.jpg", panel3);
        addImage("src/res/theory4.jpg", panel5);

        JScrollPane p5 = new JScrollPane(panel5, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        tabbedPane.addTab("1. Теория ", panel1);
        tabbedPane.addTab("1. Практика ", panel2);
        tabbedPane.addTab("2. Теория ", panel3);
        tabbedPane.addTab("2. Практка ", panel4);
        tabbedPane.addTab("3. Теория ", p5);
        tabbedPane.addTab("3. Практика ", panel6);

        content.add(tabbedPane, BorderLayout.CENTER);

        getContentPane().add(content);

        setPreferredSize(new Dimension(600, 400));
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
        //  panel.setBackground(Color.WHITE);
    }

    private JPanel getResultPane1() {
        JPanel result = new JPanel();
        JPanel left = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        left.add(new JLabel("Толщина кирпича(δ,м):"), gbc);

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

        left.setBackground(Color.WHITE);
        result.add(left);
        result.setLayout(new GridLayout(0, 2));

        JPanel r = new JPanel(new FlowLayout());
        addImage("src/res/example1.jpg", r);
        JLabel form = new JLabel("Плотность теплового потока рассчитывается");
        JLabel form1 = new JLabel("по формуле:\n");
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


        JButton button = new JButton("Рассчитать");
        r.add(button);

        JLabel answer = new JLabel();
        r.add(answer);

        r.setBackground(Color.WHITE);
        result.add(r);



        button.addActionListener(e -> {

            double thickness = getDouble(f1.getText());
            double tOutside = getDouble(f2.getText());
            double tInside  = getDouble(f3.getText());
            double thermalConductivity = getDouble(f4.getText());

            double res = (thermalConductivity/thickness)*(tInside-tOutside);
            answer.setText(String.valueOf(res));
            System.out.println(res);
        });
        result.setBackground(Color.WHITE);
        return result;
    }
    private double getDouble(String s){
        if(s.contains(",")){
            s = s.replace(",",".");
        }
        if(s.isEmpty()){
            return 0;
        }
       return Double.parseDouble(s);
    }

    private JPanel getResultPane2(){
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


    //    gbc.anchor = GridBagConstraints.NORTHEAST;
      //  gbc.fill = GridBagConstraints.HORIZONTAL;

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

        JButton button = new JButton("Рассчитать");
        r.add(button);

        JLabel answer = new JLabel();
        r.add(answer);

        r.setBackground(Color.WHITE);
        result.add(r);



        button.addActionListener(e -> {

            double thickness = getDouble(f1.getText());
            double tOutside = getDouble(f2.getText());
            double tInside  = getDouble(f3.getText());
            double thermalConductivity = getDouble(f4.getText());

            double res = (thermalConductivity/thickness)*(tInside-tOutside);
            answer.setText(String.valueOf(res));
            System.out.println(res);
        });

        return result;

    }

    private JPanel getResultPane3(){
        JPanel result = new JPanel();
        JPanel left = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        left.add(new JLabel("Толщина стены(δ,м):"), gbc);

        gbc.gridy++;
        left.add(new JLabel("Теплопроводность стены(λ,Вт/(м·К)):"), gbc);

        gbc.gridy++;
        left.add(new JLabel("Толщина утеплителя(δ,м):"), gbc);

        gbc.gridy++;
        left.add(new JLabel("Теплопроводность утеплителя(λ,Вт/(м·К):"), gbc);


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

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

        left.setBackground(Color.WHITE);
        result.add(left);

        result.setLayout(new GridLayout(0, 2));

        JPanel r = new JPanel(new FlowLayout());
        JLabel form1 = new JLabel("Коэффициент инфильтрации вычисляется по формуле:");

        r.add(form1);

        BufferedImage img1 = null;
        try {
            img1 = ImageIO.read(new File("src/res/form4.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        JLabel label2 = new JLabel();
        label2.setIcon(new ImageIcon(img1));
        r.add(label2, gbc);

        JButton button = new JButton("Рассчитать");
        r.add(button);

        JLabel answer = new JLabel();
        r.add(answer);

        r.setBackground(Color.WHITE);
        result.add(r);



        button.addActionListener(e -> {

            double thickness = getDouble(f1.getText());
            double tOutside = getDouble(f2.getText());
            double tInside  = getDouble(f3.getText());
            double thermalConductivity = getDouble(f4.getText());

            double res = (thermalConductivity/thickness)*(tInside-tOutside);
            answer.setText(String.valueOf(res));
            System.out.println(res);
        });

        return result;

    }
}

