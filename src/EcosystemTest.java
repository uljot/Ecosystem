import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EcosystemTest extends JFrame {
    //public static void main(String args[]) {
    //SmallAnimal T1 = new SmallAnimal( "swistak", 100);
    //    T1.start();
    //}
        private static final int DIM_X = 640;
        private static final int DIM_Y = 480;
        private static final int UPDATE = 20;
        private Canvas canvas;
        private int[] tableX, tableY;
        private int[] tableXSpeed, tableYSpeed;
        private Color[] tablicaKolorow;
        private int liczbaPilek;
        private int rozmiar = 50;
        private int maxXSpeed = 5;
        private int maxYSpeed = 7;
        private Timer timer;
        public EcosystemTest(int liczbaPilek) {
            this.liczbaPilek = liczbaPilek;
            this.tableX = new int[liczbaPilek];
            this.tableY = new int[liczbaPilek];
            this.tableXSpeed = new int[liczbaPilek];
            this.tableYSpeed = new int[liczbaPilek];
            this.tablicaKolorow = new Color[liczbaPilek];
            for(int i=0;i<liczbaPilek;i++) {
                tableX[i] = (int)(Math.random()*(DIM_X-(2*rozmiar))+rozmiar);
                tableY[i] = (int)(Math.random()*(DIM_Y-(2*rozmiar))+rozmiar);
                tableXSpeed[i] = (int)(Math.random()*maxXSpeed+1);
                tableYSpeed[i] = (int)(Math.random()*maxYSpeed+1);
                tablicaKolorow[i] = new Color((float)Math.random(), (float)Math.random(),
                        (float)Math.random());
            }
            canvas = new Canvas();
            canvas.setPreferredSize(new Dimension(DIM_X, DIM_Y));
            this.setContentPane(canvas);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setTitle("EcosystemTest");
            this.pack();
            this.setVisible(true);
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
        public void update() {
            for(int i=0;i<liczbaPilek;i++) {
                tableX[i] += tableXSpeed[i];
                tableY[i] += tableYSpeed[i];
                if (tableX[i] > DIM_X - rozmiar || tableX[i] < 0) {
                    tableXSpeed[i] = -tableXSpeed[i];
                }
                if (tableY[i] > DIM_Y - rozmiar || tableY[i] < 0) {
                    tableYSpeed[i] = -tableYSpeed[i];
                }
            }
        }
        private class Canvas extends JPanel {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(Color.WHITE);
                for(int i=0;i<liczbaPilek;i++) {
                    g.setColor(tablicaKolorow[i]);
                    g.fillOval(tableX[i], tableY[i], rozmiar, rozmiar);
                }
            }
        }
        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new EcosystemTest(50);
                }
            });
        }
}