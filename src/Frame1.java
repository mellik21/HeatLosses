import javax.swing.*;

public class Frame1 extends JFrame{
    private JPanel panel;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JTabbedPane tabbedPane4;
    private JTabbedPane tabbedPane5;
    private JTabbedPane tabbedPane6;
    private JTabbedPane tabbedPane7;
    private JTabbedPane tabbedPane8;
    private JTabbedPane tabbedPane9;

    public Frame1(){
        add(panel);
        setSize(400,400);
       // DisplayImage(tabbedPane1,"1.jpg");
        setVisible(true);
    }

    private static void DisplayImage(JPanel jp, String url) {
        JLabel jl=new JLabel();
        jl.setIcon(new javax.swing.ImageIcon(Frame1.class.getResource(url)));
        jp.add(jl);
    }
}
