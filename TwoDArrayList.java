import java.util.ArrayList;
import java.util.Scanner;

public class TwoDArrayList {
  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> myServer = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      myServer.add( new ArrayList<>() );
    }

    Scanner sc = new Scanner(System.in);

    System.out.print("Please enter your username: ");
    String name = "2d/" + sc.nextLine();

    System.out.println("Welcome " + name + "\n");

    String options = "Commands:\n1. \"server\" - Shows server connections.\n2. \"connect\" - Connects a client to the server.\n3. \"disconnect\" - Disconnects a client from the server.\n\"options\" - Shows this menu.\n\"about\" - Shows information about this program.\n\"exit\" - Ends program.";

    String about = "\nThis is an exercise in using and traversing through a 2d ArrayList in Java. This program simulates client connections to a server with 10 sockets with a limit of 3 connections per socket.\n\nEnter one of the following commands to use the program: options | server | connect | disconnect | about | exit";

    System.out.print(options + "\n" + name + "> ");

    while (true) {
      String selection = sc.nextLine();

      if ( selection.equalsIgnoreCase("options") ) {
        System.out.print(options + "\n" + name + "> ");
      }
      
      if ( selection.equalsIgnoreCase("about") ) {
        System.out.print( about + "\n" + name + "> ");
      }

      if ( selection.equalsIgnoreCase("server") || selection.equals("1") ) {
        try {
          System.out.println("Getting server connections...");
          Thread.sleep(2000);
          System.out.print("Server connections: " + myServer + "\n" + name + "> " );
        } catch (Exception e) {
          System.err.println("Interrupted: " + e.getMessage());
          System.out.println(options);
        }
      }

      if (selection.equalsIgnoreCase("connect") || selection.equals("2") ) {
        try {
          System.out.println("The server has 10 sockets. Which socket would you like to connect to? Please select a number between 1 and 10");
          System.out.print(name + "> ");
          int chooseSocket = sc.nextInt();
          
          if ( chooseSocket > 0 && chooseSocket < 11) {
            System.out.println("connecting...");
            int[] cnSocket = {chooseSocket};
            serverConnect(cnSocket, myServer);
            Thread.sleep(2000);
            System.out.print("Connected successfully. Enter \"server\" to view connections. \n");
          } else {
            System.out.println("Socket selection must be a number between 1 and 10");
            Thread.sleep(3000);
            System.out.println(options);
          }

        } catch (Exception e) {
          System.err.println("Interrupted: " + e.getMessage() + ". Socket selection must be a number between 1 and 10");
          System.out.println(options);
        }
      }

      if ( selection.equalsIgnoreCase("disconnect") ) {
        System.out.print( "This functionality coming soon" + "\n" + name + "> ");
      }
      
      if ( selection == "" ) {
        System.out.print(name + "> ");
      }
      
      if ( selection.equalsIgnoreCase("exit") ) {
        break;
      }

    }

    sc.close();

    System.out.println("myServer end ---> " + myServer );

  }

  public static ArrayList<ArrayList<Integer>> serverConnect( int[] clientsToStart, ArrayList<ArrayList<Integer>> myServer ) {
    
    for (int i = 0; i < clientsToStart.length; i++) {
      for (int j = 0; j < myServer.size(); j++) {
        if ( clientsToStart[i] -1 == j ) {
          if ( myServer.get(j).size() == 3 ) {
            System.out.println("Socket " + clientsToStart[i] + " has reached it's capacity. Each socket can only hold up to three connections. Please select another socket or disconnect a client from socket " + clientsToStart[i] );
          } else {
            myServer.get(j).add(clientsToStart[i]);
          }
        }
      }
    }

    return myServer;
  }

}