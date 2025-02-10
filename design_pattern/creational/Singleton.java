package design_pattern.creational;
public class Singleton {

    private static Singleton instance;
    static Singleton getInstance() {
        if(instance == null) instance = new Singleton();
        return instance;
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            System.out.println(Singleton.getInstance());
        }
    }
}