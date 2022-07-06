import classes.Customer;
import classes.Ticket;
import controller.TicketController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Ticket> ticketList = new ArrayList<Ticket>();
        List<Customer> customerList = new ArrayList<Customer>();
        boolean input = true;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("******************FUNCTIONALITIES MENU******************");
            System.out.println("Please enter any one input number: ");
            System.out.println("1.Get a ticket \n 2.List all tickets \n 3.List all the tickets with status filter \n 4.List all the tickets with customer name filter \n 5.Create a ticket \n 6.Update a ticket \n 7. Delete a ticket \n 8.Create customer \n 9.Exit");
            Integer inputFunc = Integer.parseInt(sc.nextLine());
            TicketController ticketControllerObj = new TicketController();
            switch (inputFunc) {
                case 1: {
                    /* Get a particular ticket */
                    System.out.println("Enter ticket id");
                    Integer inputTicketId = Integer.parseInt(sc.nextLine());
                    List<Ticket> resultList = ticketControllerObj.getTickets(null,null,inputTicketId,ticketList);
                    ticketControllerObj.printTicket(resultList);
                    break;
                }
                case 2: {
                    /* List all tickets */
                    System.out.println("Tickets");
                    ticketControllerObj.printTicket(ticketList);
                    break;
                }
                case 3: {
                    /* List all the tickets with status filter */
                    System.out.println("Enter status");
                    String status = sc.nextLine();
                    List<Ticket> resultList = ticketControllerObj.getTickets(null,status,null,ticketList);
                    ticketControllerObj.printTicket(resultList);
                    break;
                }

                case 4:{
                    /* List all the tickets with customer name filter */
                    System.out.println("Enter customer name");
                    String customerName = sc.nextLine();
                    List<Ticket> resultList = ticketControllerObj.getTickets(customerName,null,null,ticketList);
                    ticketControllerObj.printTicket(resultList);
                    break;
                }
                case 5: {
                    /* Create a ticket */
                    System.out.println("Please enter your customer id");
                    int inputCustomerId = Integer.parseInt(sc.nextLine());
                    boolean isCustomerExist = false;
                    for (Customer customer: customerList) {
                        if (customer.getId() == inputCustomerId) {
                            isCustomerExist = true;
                            Ticket ticket = new Ticket();
                            ticket.setCustomer(customer);
                            System.out.println("Enter the ticket id:");
                            ticket.setId(Integer.parseInt(sc.nextLine()));
                            System.out.println("Enter the ticket title:");
                            ticket.setTitle(sc.nextLine());
                            System.out.println("Enter the ticket description:");
                            ticket.setDescription(sc.nextLine());
                            ticket.setStatus("Initiated");
                            ticketList.add(ticket);
                        }
                    }
                    if(isCustomerExist==false)
                    {
                        System.out.println("Customer does not exists!!");
                    }
                    break;
                }

                case 6: {
                    /* Update a ticket */
                    ticketControllerObj.updateTicket(ticketList);
                    System.out.println("After updating");
                    ticketControllerObj.printTicket(ticketList);
                    break;
                }

                case 7: {
                    /* Delete a ticket */
                    ticketControllerObj.deleteTicket(ticketList);
                    System.out.println("After deleting");
                    ticketControllerObj.printTicket(ticketList);
                    break;
                }

                case 8:{
                    /* Create customer */
                    Customer customer = new Customer();
                    System.out.println("Enter id");
                    customer.setId(Integer.parseInt(sc.nextLine()));
                    System.out.println("Enter your name");
                    customer.setName(sc.nextLine());
                    System.out.println("Enter your email");
                    customer.setEmail(sc.nextLine());
                    customerList.add(customer);
                    break;
                }

                case 9: {
                    /* Break */
                    input = false;
                    break;
                }

                default: {
                    // Do nothing for now
                    System.out.println("Please enter a valid input!!");
                    break;
                }
            }
        } while (input == true);
    }
}

