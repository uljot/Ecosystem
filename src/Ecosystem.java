import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ecosystem extends JFrame{
    private static final int DIM_X = 800;
    private static final int DIM_Y = 600;
    private static final int UPDATE = 20;
    JButton smallButton, largeButton;
    private Canvas canvas;

    private Timer timer;

    public Ecosystem(){
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(DIM_X, DIM_Y));
        this.setContentPane(canvas);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Ecosystem");
        this.pack();
        this.setVisible(true);
        setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("grass-pattern-CROP.png"));
        add(background);
        background.setLayout(new FlowLayout());
        smallButton=new JButton("Add a small animal!");
        largeButton=new JButton("Add a large animal!");
        background.add(smallButton);
        background.add(largeButton);
        ActionListener zadanie = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                update();
                repaint();
            }
        };
        timer = new Timer(UPDATE, zadanie);
        timer.start();
    }

    public void update(){}

    private class Canvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.WHITE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ecosystem();
            }
        });
    }
}
