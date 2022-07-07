package classes;

import java.util.HashMap;
import java.util.Map;

public class Singleton {
    public Map<Integer, Ticket> ticketList = new HashMap<Integer,Ticket>();
    public Map<Integer, Customer> customerList = new HashMap<Integer,Customer>();

    static Singleton singletonObj = new Singleton();
    private Singleton()
    {

    }
    public static Singleton getInstance(){
        return singletonObj;
    }
}
