import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ecosystem extends JFrame {
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
        public Ecosystem(int liczbaPilek) {
            this.liczbaPilek = liczbaPilek;
            this.tablicaX = new int[liczbaPilek];
            this.tablicaY = new int[liczbaPilek];
            this.tablicaXSpeed = new int[liczbaPilek];
            this.tablicaYSpeed = new int[liczbaPilek];
            this.tablicaKolorow = new Color[liczbaPilek];
            for(int i=0;i<liczbaPilek;i++) {
                tablicaX[i] = (int)(Math.random()*(ROZMIAR_X-(2*rozmiar))+rozmiar);
                tablicaY[i] = (int)(Math.random()*(ROZMIAR_Y-(2*rozmiar))+rozmiar);
                tablicaXSpeed[i] = (int)(Math.random()*maxXSpeed+1);
                tablicaYSpeed[i] = (int)(Math.random()*maxYSpeed+1);
                tablicaKolorow[i] = new Color((float)Math.random(), (float)Math.random(),
                        (float)Math.random());
            }
            plotno = new Plotno();
            plotno.setPreferredSize(new Dimension(ROZMIAR_X, ROZMIAR_Y));
            this.setContentPane(plotno);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setTitle("Ecosystem");
            this.pack();
            this.setVisible(true);
            ActionListener zadanie = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    update();
                    repaint();
                }
            };
            timer = new Timer(AKTUALIZACJA, zadanie);
            timer.start();
        }
        public void update() {
            for(int i=0;i<liczbaPilek;i++) {
                tablicaX[i] += tablicaXSpeed[i];
                tablicaY[i] += tablicaYSpeed[i];
                if (tablicaX[i] > ROZMIAR_X - rozmiar || tablicaX[i] < 0) {
                    tablicaXSpeed[i] = -tablicaXSpeed[i];
                }
                if (tablicaY[i] > ROZMIAR_Y - rozmiar || tablicaY[i] < 0) {
                    tablicaYSpeed[i] = -tablicaYSpeed[i];
                }
            }
        }
        private class Plotno extends JPanel {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(Color.WHITE);
                for(int i=0;i<liczbaPilek;i++) {
                    g.setColor(tablicaKolorow[i]);
                    g.fillOval(tablicaX[i], tablicaY[i], rozmiar, rozmiar);
                }
            }
        }
        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Ecosystem(50);
                }
            });
        }
}