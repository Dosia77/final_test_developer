package com.animals.views;
import com.animals.controllers.*;
import  java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.animals.models.repositoryDB.impl.RepositoryDB;

public class ViewDB {

    private final ControllerDB contDB;
    public ViewDB(ControllerDB contDB) {
      this.contDB = contDB;
  }
      public static String prompt(String message) {
               Scanner sc = new Scanner(System.in);
                System.out.print(message); 
                return sc.nextLine();
              
            }

    public void runDatabase()throws ClassNotFoundException, SQLException{    
    while(true)
    {   
        String command = prompt("Enter the command number: \r\n" + //
                        "0 - Exit the program\r\n" + //
                        "1 - View all animals\r\n" + //
                        "2 - Add an animal to the database\r\n" + //
                        "3 - Remove an animal from the database\r\n" + //
                        "4- View animal commands\r\n" + //
                        "5 - Add a new command\r\n" + //
                        "6 - Total number of animals\r\n"+"Enter ");
                        if (command.equals("0")) return;
     switch (command){
        case "1":
        contDB.selectAll();
        break;
      
        case "2":
        String type1 = prompt("Enter the type of animal: ");
        LocalDate birthDate = null;
       
       if(!type1.equals("cat")&& !type1.equals("dog")&& !type1.equals("hamster")&& !type1.equals("camel")&& !type1.equals("horse")&& !type1.equals("donkey"))
        {
            System.out.println("We don’t keep such animals");
            break;     
        }
         try {
             DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
             birthDate = LocalDate.parse(prompt("enter the date in the format 'yyyy-MM-dd': "),dt); 
        } catch (Exception e) {
           System.out.println("Incorrect date entry, try again");
           break;
        }        
        contDB.addAnimal(type1, birthDate);
        break;

      case "3": 
       int id=0;
      try {
         id = Integer.parseInt(prompt("enter id: "));
      } catch (Exception e) {
         System.out.println( "invalid input, try again");
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                break;
      }
      if(RepositoryDB.IsNumberDB(id,RepositoryDB.idList()) == 0){
         System.out.println("The number is not in the list");
         break;
      }
       contDB.removeAnimal(id);
       break; 
     
       case"4":
     
       int idViewCommands=0;
       try {
          idViewCommands = Integer.parseInt(prompt("enter id: "));
       } catch (Exception e) {
          System.out.println( "invalid input, try again");
                 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                 break;
       }
       if(RepositoryDB.IsNumberDB(idViewCommands,RepositoryDB.idList()) == 0){
          System.out.println("The number is not in the list");
          break;
       }
      contDB.printAnmalCommands(idViewCommands);
      break;

      case "5":

      int idAddCommand=0;
      try {
         idAddCommand = Integer.parseInt(prompt("enter id: "));

      } catch (Exception e) {
         System.out.println( "invalid input, try again");
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                break;
      }
      if(RepositoryDB.IsNumberDB(idAddCommand,RepositoryDB.idList()) == 0){
         System.out.println("The number is not in the list");
         break;
      }
      contDB.addAnimalCommand(idAddCommand);
      break;

      case "6":
      contDB.countAnimals();
      break;

      }
   }              
}

 
} 
