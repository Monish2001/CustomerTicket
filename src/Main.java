import classes.Customer;
import classes.Singleton;
import classes.Ticket;
import controller.TicketController;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer,Ticket> EmptyMap = Collections.emptyMap();
        Singleton singletonObj = Singleton.getInstance();
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
                    Ticket resultTicket = ticketControllerObj.getTicketWithId(inputTicketId);
                    System.out.println(resultTicket.getId());
                    System.out.println(resultTicket.getTitle());
                    System.out.println(resultTicket.getDescription());
                    break;
                }
                case 2: {
                    /* List all tickets */

                    System.out.println("Tickets");
                    ticketControllerObj.printTicket(EmptyMap);
                    break;
                }
                case 3: {
                    /* List all the tickets with status filter */

                    System.out.println("Enter status");
                    String status = sc.nextLine();
                    Map<Integer,Ticket> resultList = ticketControllerObj.getTickets(null,status);
                    ticketControllerObj.printTicket(resultList);
                    break;
                }

                case 4:{
                    /* List all the tickets with customer name filter */
                    System.out.println("Enter customer id");
                    Integer customerId = Integer.parseInt(sc.nextLine());
                    Map<Integer,Ticket> resultList = ticketControllerObj.getTickets(customerId,null);
                    ticketControllerObj.printTicket(resultList);
                    break;
                }
                case 5: {
                    /* Create a ticket */
                    System.out.println("Please enter your customer id");
                    int inputCustomerId = Integer.parseInt(sc.nextLine());
                    boolean isCustomerExist = false;
                    Map<Integer, Customer> customerList = singletonObj.getCustomerList();
                    for (Map.Entry<Integer,Customer> customer : customerList.entrySet()) {
                        if (customer.getValue().getId().equals(inputCustomerId)) {
                            isCustomerExist = true;
                            Ticket ticket = new Ticket();
                            System.out.println("Enter the ticket id:");
                            Integer id = Integer.parseInt(sc.nextLine());
                            ticket.setId(id);
                            System.out.println("Enter the ticket title:");
                            String title = sc.nextLine();
                            ticket.setTitle(title);
                            System.out.println("Enter the ticket description:");
                            String description = sc.nextLine();
                            ticket.setDescription(description);
                            ticket.setStatus(Ticket.TicketStatus.INITIATED);
                            ticket.setCustomer(customer.getValue());
                            Map<Integer, Ticket> ticketList = singletonObj.getTicketList();
                            ticketList.put(id,ticket);
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
                    System.out.println("Enter the ticket id to update");
                    Integer ticketId = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter the ticket title to update");
                    String updatedTitle = sc.nextLine();
                    ticketControllerObj.updateTicket(ticketId, updatedTitle);
                    System.out.println("After updating");
                    ticketControllerObj.printTicket(EmptyMap);
                    break;
                }

                case 7: {
                    /* Delete a ticket */
                    System.out.println("Enter the ticket id to delete!!");
                    Integer ticketId = Integer.parseInt(sc.nextLine());
                    ticketControllerObj.deleteTicket(ticketId);
                    System.out.println("After deleting");
                    ticketControllerObj.printTicket(EmptyMap);
                    break;
                }

                case 8:{
                    /* Create customer */
                    Customer customer = new Customer();
                    System.out.println("Enter id");
                    Integer id = Integer.parseInt(sc.nextLine());
                    customer.setId(id);
                    System.out.println("Enter your name");
                    String name = sc.nextLine();
                    customer.setName(name);
                    System.out.println("Enter your email");
                    String email = sc.nextLine();
                    customer.setEmail(email);
                    Map<Integer, Customer> customerList = singletonObj.getCustomerList();
                    customerList.put(id,customer);
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

