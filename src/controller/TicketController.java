package controller;

import classes.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketController {
    Scanner sc = new Scanner(System.in);
    public List<Ticket> getTickets(String customerName, String status, Integer id, List<Ticket> ticketList)
    {
        List<Ticket> returnTicketList = new ArrayList<Ticket>();
        if(customerName!=null || status!=null || id!=null)
        {
            for (Ticket ticket:
                 ticketList) {
                if(ticket.getCustomer().getName().equals(customerName) || ticket.getStatus().equals(status) || ticket.getId() == id)
                {
                    returnTicketList.add(ticket);
                }
            }
            return returnTicketList;
        }
        else{
            return ticketList;
        }
    }

    public void printTicket(List<Ticket> ticketList)
    {
        if(ticketList.size()!=0)
        {
            for (Ticket ticket:
                    ticketList) {
                System.out.println(ticket.getTitle());
                System.out.println(ticket.getDescription());
                System.out.println(ticket.getStatus());
                System.out.println(ticket.getCustomer().getName());
                System.out.println(ticket.getCustomer().getEmail());
            }
        }

    }

    public void updateTicket(List<Ticket> ticketList)
    {

        System.out.println("Enter the ticket id to update");
        Integer ticketId = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the ticket title to update");
        String updatedTitle = sc.nextLine();
        for (Ticket ticket:ticketList
        ) {
            if(ticket.getId()==ticketId)
            {
                ticket.setTitle(updatedTitle);
            }
        }
    }

    public void deleteTicket(List<Ticket> ticketList)
    {
        System.out.println("Enter the ticket id to delete!!");
        Integer ticketId = Integer.parseInt(sc.nextLine());
        for (Ticket ticket:ticketList
        ) {
            if(ticket.getId()==ticketId)
            {
                ticketList.remove(ticket);
                return;
            }
        }
    }
}
