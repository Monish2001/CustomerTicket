package helper;

import classes.Ticket;

import java.util.Map;

public class TicketHelper {
    public void PrintTicket(Map<Integer, Ticket> ticketList)
    {
        for (Map.Entry<Integer, Ticket> ticket : ticketList.entrySet())
        {
            System.out.println("Key = " + ticket.getKey() +
                    ", Value = " + ticket.getValue());
            System.out.println(ticket.getValue().getId());
            System.out.println(ticket.getValue().getTitle());
            System.out.println(ticket.getValue().getDescription());
            System.out.println(ticket.getValue().getStatus());
            System.out.println(ticket.getValue().getCustomer().getName());
            System.out.println(ticket.getValue().getCustomer().getEmail());
        }
    }
}
