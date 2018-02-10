import javax.swing.*;

public class SmallAnimal extends Thread{
    private double capacity = 50, mass = 3, hunger = capacity, hDegree = 0.5, biteCapacity = 3;
    private final int ID;
    private int posX, posY;
    private int maxSpeed = 7;
    private int xSize = 30, ySize = 44;
    private long  hTimer = 1000;
    private int awarenessRadius = 80, reachRadius = 40;
    private ImageIcon pic;
    //group <- how tf is this supposed to work

    public SmallAnimal(int id){
        this.ID = id;
        this.pic = new ImageIcon(this.getClass().getResource("rabbit-small-animal.png"));
    }

    public void setPosX(int posX){
        this.posX = posX;
    }

    public void setPosY(int posY){
        this.posY = posY;
    }

    public int getPosX(){
        return posX;
    }

    public int getposY(){
        return posY;
    }

    public ImageIcon getPic(){
        return pic;
    }

    public void run(){
        while (hunger > 0) {
            try {
                Thread.sleep(hTimer);
            } catch (InterruptedException e) {}
            //decrease hunger by hTime by (1)
            //if (hunger < hDegree*capacity) start looking for food AND for group (switchLookFood())
            //if (lookFood == true) looking for food AND for group
            //  if free food found takeBite -> hunger += biteCapacity until (hunger >= 0.9 * capacity)
            //  if SmallAnimal found form group/add to group (check for existing group
            //                                                  if none -> create;
            //                                                  if exists -> join group;)
            //      if group > 5 MAX_PRIORITY for all SmallAnimal in group
            //  if (hunger >= 0.9 * capacity) stop eating, leave group (-> NORM_PRIORITY), switchLookFood())
            //if (hunger <=0) die()
        }
    }

    @Override
    public String toString() {
        return "Small animal: " + ID + " Hunger Status: " + hunger;
    }
}
