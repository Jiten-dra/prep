package design_pattern.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        User user1 = new User("jiten");
        User user2 = new User("tara");

        Product speaker = new Product("Bluetooth Speaker", 1, 0, 5000.00f);
        Product ring = new Product("rose diamond ring", 1, 0, 1200.50f);
        Product watch = new Product("Smart watch", 3, 0, 12000.00f);

        speaker.addObserver(user2);
        ring.addObserver(user1);
        watch.addObserver(user1);
        watch.addObserver(user2);

        System.out.println("adding stock to all producs");
        speaker.updateStock(3);
        ring.updateStock(5);
        watch.updateStock(9);

        System.out.println("adding more stock to all products");
        speaker.updateStock(3);
        ring.updateStock(5);
        watch.updateStock(9);

        System.out.println("removing user1 observer from watch");
        watch.removeObserver(user1);

        System.out.println("set stock to 0 then adding stock to all products");
        speaker.setStock(0);
        ring.setStock(0);
        
        speaker.updateStock(3);
        ring.updateStock(5);
        
        watch.setStock(0);
        watch.updateStock(9);


    }

    
}

interface Observer {
   void update(String msg);
}

class User implements Observer {
    String name;
    User(String name){
        this.name = name;
    }

    @Override
    public void update(String msg) {
        // TODO Auto-generated method stub
        System.out.printf("%s is notify about %s\n", name, msg);
    }
}

/**
Observable as class is better approach if possible as java allow only one inheritance.
managing add remove notify logic in parent class no need to rewrite.

these method could also have eventType - observe specific event like code push in github or pull request approve
Instead of List of observer Observable will maintain Map<eventType, List<Observer>>
notify will notify observer for given eventType only.
 */
interface Observable {
    void addObserver(Observer obsrvr);
    void removeObserver(Observer obsrvr);
    void notifyObservers();
}

class Product implements Observable{
    String name;
    int id, stock;
    float price;
    List<Observer> lsObsrvr;
    public Product(String name, int id, int stock, float price) {
        this.name = name;
        this.id = id;
        this.stock = stock;
        this.price = price;
        lsObsrvr = new ArrayList<>();
    }

    void updateStock(int change){
        if(stock == 0 && change > 0){
            notifyObservers();
        }
        this.stock += change;
    }

    void setStock(int newVal){
        updateStock(newVal-this.stock);
    }

    @Override
    public void addObserver(Observer obsrvr) {
        // TODO Auto-generated method stub
        this.lsObsrvr.add(obsrvr);
    }

    @Override
    public void removeObserver(Observer obsrvr) {
        // TODO Auto-generated method stub
        this.lsObsrvr.remove(obsrvr);
    }

    @Override
    public void notifyObservers() {
        // TODO Auto-generated method stub
        for(Observer observer: lsObsrvr){
            observer.update(String.format("Product %s is available now", this.name));
        }
    }    
}
