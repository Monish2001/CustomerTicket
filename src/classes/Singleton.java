package classes;

import java.util.HashMap;
import java.util.Map;

public class Singleton {
    final private Map<Integer, Ticket> ticketList;
    final private Map<Integer, Customer> customerList;

    public Map<Integer, Ticket> getTicketList() {
        return ticketList;
    }

    public Map<Integer, Customer> getCustomerList() {
        return customerList;
    }

    static Singleton singletonObj = new Singleton();
    private Singleton()
    {
        this.ticketList = new HashMap<Integer, Ticket>();
        this.customerList = new HashMap<Integer, Customer>();
    }
    public static Singleton getInstance(){
        return singletonObj;
    }
}
