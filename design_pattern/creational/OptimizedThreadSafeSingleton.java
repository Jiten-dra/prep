package design_pattern.creational;

public class OptimizedThreadSafeSingleton {
    private static OptimizedThreadSafeSingleton instance;
    static OptimizedThreadSafeSingleton getInstance() {
        if(instance == null) {
            synchronized(OptimizedThreadSafeSingleton.class){
                if(instance == null) instance = new OptimizedThreadSafeSingleton();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread(1);
        Thread t2 = new MyThread(2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {
    int id;
    public MyThread(int id){
        this.id = id;
    }
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("id: "+id+", "+OptimizedThreadSafeSingleton.getInstance());
        }
    }
}
