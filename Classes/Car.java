package Classes;
public class Car {
 //Nitelikler
    int speed;
    int speedlimit;
    String type;
    String color;
    String model;
   //Constructer
     Car(){
         System.out.println("Nesne Ouşturuldu Bea");
         this.speedlimit=180;
    }

    void increaseSpeed(int increment){
        if(speed+increment<speedlimit){
            speed +=increment;

        }
    }
    void decreaseSpeed(int decrease){
        if(speed-decrease>=0){
            speed-=decrease;
        }
    }
    void printSpeed(){
        System.out.println("Hızınız :"+speed);
    }

}
