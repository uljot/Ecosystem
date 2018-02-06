public class SmallAnimal extends Thread{
    private String name;
    private double capacity = 50, mass = 3, hunger = capacity, hDegree = 0.5, biteCapacity = 3;
    private long  hTimer;
    boolean lookFood = false;
    //group <- how tf is this supposed to work

    public SmallAnimal(String name, long hTimer){
        this.name = name;
        this.hTimer = hTimer;
    }

    private void die(){
        //create new Corpse(double mass)
        System.out.println("Small animal " + name + " DIES of hunger!");
        this.interrupt(); //<- is it still working? IT DOESN'T SEEM SO
    }

    private void switchLookFood(){
        lookFood = !lookFood;
    }

    public boolean getHungerStatus(){
        return lookFood;
    }

    private void takeBite(){
        if(hunger + biteCapacity <= capacity) {
            hunger += biteCapacity;
        } else {hunger = capacity;}
    }

    public void run(){
        while (true) {
            if(this.isInterrupted()){
                break;
            }
            try {
                System.out.println(this.toString());
                if (hunger <= 0){
                    die();
                }
                hunger -= 1;
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
