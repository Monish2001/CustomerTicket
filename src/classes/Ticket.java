package classes;

import java.util.List;
import java.util.Map;

public class Ticket {
    private Integer id;
    private String title;
    private String description;
    private String status;
    private Customer customer;
//    private Map<Integer, Ticket> ticketList;
//    public Map<Integer, Ticket> getTicketList() {
//        return ticketList;
//    }
//
//    public void setTicketList(Map<Integer, Ticket> ticketList) {
//        this.ticketList = ticketList;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    static Ticket ticketObj = new Ticket();
//    private Ticket()
//    {
//
//    }
//    public static Ticket getInstance(){
//        return ticketObj;
//    }

//    public void createTicket(Integer id, String title, String description, String status, Customer customer)
//    {
//        ticketObj.setId(id);
//        ticketObj.setTitle(title);
//        ticketObj.setDescription(description);
//        ticketObj.setStatus(status);
//        ticketObj.setCustomer(customer);
//        ticketList.put(id,ticketObj);
//    }


}
