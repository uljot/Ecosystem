import javax.swing.*;

public class SmallAnimal extends Thread{
    private String name;
    private double capacity = 50, mass = 3, hunger = capacity, hDegree = 0.5, biteCapacity = 3;
    private long  hTimer;
    private ImageIcon pic;
    //group <- how tf is this supposed to work

    public SmallAnimal(String name, long hTimer){
        this.name = name;
        this.hTimer = hTimer;
        this.pic = new ImageIcon("rabbit-small-animal.png");
    }

    public ImageIcon getPic(){
        return pic;
    }

    public void run(){
        while (hunger > 0) {
            if(this.isInterrupted()){
                break;
            }
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
        return "Small animal: " + name + " Hunger Status: " + hunger;
    }
}
