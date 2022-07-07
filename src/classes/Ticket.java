package classes;

import java.util.List;
import java.util.Map;

public class Ticket {

    public enum TicketStatus {
        ACTIVE,
        INITIATED,
        INACTIVE,
        WRITTENOFF;
    }

    private Integer id;
    private String title;
    private String description;
    private String status;
    private Customer customer;
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


}
