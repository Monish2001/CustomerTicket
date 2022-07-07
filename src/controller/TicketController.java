package controller;

import classes.Singleton;
import classes.Ticket;
import helper.TicketHelper;

import java.util.*;

public class TicketController {
    Scanner sc = new Scanner(System.in);
    Singleton singletonObj = Singleton.getInstance();

    public Ticket getTicketWithId(Integer id)
    {
        Map<Integer,Ticket> ticketList = singletonObj.getTicketList();

        Ticket ticket = ticketList.get(id);
        return ticket;
    }
    public Map<Integer, Ticket> getTickets(Integer customerId, String status)
    {
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
        TicketHelper ticketHelper = new TicketHelper();
        ticketHelper.PrintTicket(ticketList);
    }

    public void printAllTicket()
    {
        Map<Integer,Ticket> ticketList = singletonObj.getTicketList();

        TicketHelper ticketHelper = new TicketHelper();
        ticketHelper.PrintTicket(ticketList);
    }

    public void updateTicket(Integer ticketId, String updatedTitle)
    {
        Map<Integer,Ticket> ticketList = singletonObj.getTicketList();
        Ticket ticket = ticketList.get(ticketId);
        ticket.setTitle(updatedTitle);
    }

    public void deleteTicket(Integer ticketId)
    {
        Map<Integer,Ticket> ticketList = singletonObj.getTicketList();

        ticketList.remove(ticketId);
    }
}
