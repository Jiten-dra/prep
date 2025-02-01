package design_pattern.behavioral;

public class StrategyPattern {
    public static void main(String[] args) {
        NavigationApplication app = new NavigationApplication();

        app.setStrategy(new CycleStrategy());
        app.ShowRouteInfo("cbr monte carlo", "heart cup coffe", 1.2);

        app.setStrategy(new RoadNavigationStrategy());
        app.ShowRouteInfo("cbr monte carlo", "heart cup coffe", 1.2);

        app.setStrategy(new PublicTransportNavigationStrategy());
        app.ShowRouteInfo("cbr monte carlo", "heart cup coffe", 1.2);

        app.setStrategy(new WalkingNavigationStrategy());
        app.ShowRouteInfo("cbr monte carlo", "heart cup coffe", 1.2);
    }
}

class NavigationApplication {
    NavigationStrategy strategy;
    void setStrategy(NavigationStrategy strategy){
        this.strategy = strategy;
    }
    void ShowRouteInfo(String loc1, String loc2, double distance) {
        strategy.showInfo(loc1, loc2, distance);
    }
    
}

interface NavigationStrategy {
    void showInfo(String loc1, String loc2, double distance);
    double getCost(double distance);
    double getTime(double distance);
}

class RoadNavigationStrategy implements NavigationStrategy {
    final double timeFac = 1.2;
    final double costFac = 10.5;
    @Override
    public void showInfo(String loc1, String loc2, double distance) {
        System.out.printf("From %s to %s will take %.2f minutes and cost %.2f Rs/- using Road %n", loc1, loc2, getTime(distance), getCost(distance));
    }
    @Override
    public double getCost(double distance) {
        // TODO Auto-generated method stub
        return distance * costFac;
    }
    @Override
    public double getTime(double distance) {
        // TODO Auto-generated method stub
        return distance * timeFac;
    }
}


class PublicTransportNavigationStrategy implements NavigationStrategy {
    final double timeFac = 2.0;
    final double costFac = 7.0;
    @Override
    public void showInfo(String loc1, String loc2, double distance) {
        System.out.printf("From %s to %s will take %.2f minutes and cost %.2f Rs/- using PublicTransport %n", loc1, loc2, getTime(distance), getCost(distance));
    }
    @Override
    public double getCost(double distance) {
        // TODO Auto-generated method stub
        return distance * costFac;
    }
    @Override
    public double getTime(double distance) {
        // TODO Auto-generated method stub
        return distance * timeFac;
    }
}

class CycleStrategy implements NavigationStrategy {
    final double timeFac = 5.0;
    final double costFac = 0.0;
    @Override
    public void showInfo(String loc1, String loc2, double distance) {
        System.out.printf("From %s to %s will take %.2f minutes and cost %.2f Rs/- using cycle%n", loc1, loc2, getTime(distance), getCost(distance));
    }
    @Override
    public double getCost(double distance) {
        // TODO Auto-generated method stub
        return distance * costFac;
    }
    @Override
    public double getTime(double distance) {
        // TODO Auto-generated method stub
        return distance * timeFac;
    }
}

class WalkingNavigationStrategy implements NavigationStrategy {
    final double timeFac = 10.0;
    final double costFac = 0.0;
    @Override
    public void showInfo(String loc1, String loc2, double distance) {
        System.out.printf("From %s to %s will take %.2f minutes and cost %.2f Rs/- by walking%n", loc1, loc2, getTime(distance), getCost(distance));
    }
    @Override
    public double getCost(double distance) {
        // TODO Auto-generated method stub
        return distance * costFac;
    }
    @Override
    public double getTime(double distance) {
        // TODO Auto-generated method stub
        return distance * timeFac;
    }
}




