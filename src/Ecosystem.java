import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Ecosystem extends JFrame{
    private static final int DIM_X = 800;
    private static final int DIM_Y = 600;
    private static final int UPDATE = 20;
    JButton smallButton, largeButton, foodButton;

    private ArrayList<SmallAnimal> smallAnimals;
    private ArrayList<LargeAnimal> largeAnimals;
    private ArrayList<Corpse> food;

    private Canvas canvas;

    private Timer timer;

    public Ecosystem(int smAn){
        smallAnimals = new ArrayList(smAn);
        for (int i=0; i < smallAnimals.size(); i++){
            smallAnimals.add(new SmallAnimal(i));
            smallAnimals.get(i).setPosX((int)Math.random()*800 + 1);
            smallAnimals.get(i).setPosY((int)Math.random()*600 + 1);
        }
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
        smallButton = new JButton("Add a small animal!");
        largeButton = new JButton("Add a large animal!");
        foodButton = new JButton("Add some food!");
        background.add(smallButton);
        background.add(largeButton);
        background.add(foodButton);
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                update();
                repaint();
            }
        };
        timer = new Timer(UPDATE, task);
        timer.start();
    }

    public void update(){}

    private class Canvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (SmallAnimal animal:smallAnimals
                 ) {
                animal.getPic().paintIcon(this, g, animal.getPosX(), animal.getposY());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ecosystem(5);
            }
        });
    }
}
