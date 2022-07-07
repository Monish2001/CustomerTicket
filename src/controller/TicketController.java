package controller;

import classes.Singleton;
import classes.Ticket;

import java.util.*;

public class TicketController {
    Scanner sc = new Scanner(System.in);
    Singleton singletonObj = Singleton.getInstance();

    public Ticket getTicketWithId(Integer id)
    {
//        Map<Integer,Ticket> ticketList = singletonObj.ticketList;
        Map<Integer,Ticket> ticketList = singletonObj.getTicketList();

        Ticket ticket = ticketList.get(id);
        return ticket;
    }
    public Map<Integer, Ticket> getTickets(Integer customerId, String status)
    {
//        Map<Integer,Ticket> ticketList= singletonObj.ticketList;
        Map<Integer,Ticket> ticketList = singletonObj.getTicketList();

        Map<Integer, Ticket> returnTicketList = new HashMap<Integer,Ticket>();
        if(customerId!=null || status!=null)
        {
            for (Map.Entry<Integer, Ticket> ticket : ticketList.entrySet()) {
                if(ticket.getValue().getCustomer().getId().equals(customerId) || ticket.getValue().getStatus().equals(status))
                {
                    returnTicketList.put(ticket.getKey(),ticket.getValue());
                }
            }
            return returnTicketList;
        }
        else{
            return ticketList;
        }
    }

    public void printTicket(Map<Integer,Ticket> ticketList)
    {
        if(ticketList.isEmpty())
        {
//            ticketList= singletonObj.ticketList;
              ticketList = singletonObj.getTicketList();
        }

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

    public void updateTicket(Integer ticketId, String updatedTitle)
    {
//        Map<Integer,Ticket> ticketList= singletonObj.ticketList;
        Map<Integer,Ticket> ticketList = singletonObj.getTicketList();
        Ticket ticket = ticketList.get(ticketId);
        ticket.setTitle(updatedTitle);
    }

    public void deleteTicket(Integer ticketId)
    {
//        Map<Integer,Ticket> ticketList= singletonObj.ticketList;
        Map<Integer,Ticket> ticketList = singletonObj.getTicketList();

        ticketList.remove(ticketId);
    }
}
