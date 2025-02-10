package design_pattern.creational;

public class Factory {
    Transport geTransport(TransportType type) throws UnsupportedClassVersionError {
        TransportFactory factory = null;
        switch (type) {
            case SEA:
                factory = new SeaFactory();
                return factory.getTransport();
            case ROAD:
                factory = new RoadFactory();
                return factory.getTransport();
            case AIR:
                factory = new AirFactory();
                return factory.getTransport();
            default:
                throw new UnsupportedClassVersionError("not supported");
        }
    }

    public static void main(String[] args) {
        //------------------------- v1
        Factory fac = new Factory();
        Transport ts = fac.geTransport(TransportType.SEA);
        ts.deliver("bhopal", "hyderabad");

        Transport tr = fac.geTransport(TransportType.ROAD);
        System.out.println(tr.getType());
        tr.deliver("bhopal", "hyderabad");


        Transport ta = fac.geTransport(TransportType.AIR);
        ta.deliver("bhopal", "hyderabad");


        //------------------------- v2
        System.out.println("version 2");
        //create transport factory based on required transport and work with factory only
        TransportFactory tfs = new SeaFactory();
        tfs.deliver("mumbai", "kolkata");

        TransportFactory tfr = new RoadFactory();
        tfr.deliver("bhopal", "indore");

        TransportFactory tfa = new AirFactory();
        tfa.deliver("indore", "hyderabad");

        TransportFactory tfo = new TransportFactory() {
            @Override
            Transport getTransport() {
                return new RoadTransport();
            }

            @Override
            TransportType getType() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getType'");
            }
        };
        tfo.deliver("pos1", "pos2");
    }
    
}

enum TransportType {
    ROAD,
    AIR,
    SEA
}

interface Transport {
    public void deliver(String loc1, String loc2);
    public TransportType getType();
}

class SeaTransport implements Transport {
    public TransportType getType(){
        return TransportType.SEA;
    }
    public void deliver(String from, String to){
        System.out.printf("shipment delivered from %s to %s by %s\n", from, to, TransportType.SEA);
    }
}

class RoadTransport implements Transport {

    public TransportType getType(){
        return TransportType.ROAD;
    }
    public void deliver(String from, String to){
        System.out.printf("shipment delivered from %s to %s by %s\n", from, to, TransportType.ROAD.toString());
    }
}

class AirTransport implements Transport {
    public TransportType getType(){
        return TransportType.AIR;
    }
    public void deliver(String from, String to){
        System.out.printf("shipment delivered from %s to %s by %s\n", from, to, TransportType.AIR);
    }
}
abstract class TransportFactory {
    Transport transport;
    abstract Transport getTransport();
    abstract TransportType getType();
    void deliver(String from, String to) {
        transport = getTransport();
        transport.deliver(from, to);
    }
}

class SeaFactory extends TransportFactory {
    public TransportType getType(){
        return TransportType.SEA;
    }
    public Transport getTransport(){
        return new SeaTransport();
    }
}

class RoadFactory extends TransportFactory {
    public Transport getTransport(){
        return new RoadTransport();
    }

    @Override
    TransportType getType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getType'");
    }
}

class AirFactory extends TransportFactory {
    public Transport getTransport(){
        return new AirTransport();
    }

    @Override
    TransportType getType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getType'");
    }
}
