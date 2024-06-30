package com.animals.views;
import com.animals.controllers.*;
import  java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.animals.models.animals1.*;
import com.animals.models.repositoryHF.impl.RepositoryHumanFriends;


public class ViewHF{

    private final ControllerHF contHF;
      public ViewHF(ControllerHF contHF) {
        this.contHF = contHF;
    }

     public void runHumanFriends(List<HumanFriends> list)throws ClassNotFoundException, SQLException{    
        while(true)
        
        {   
          String command = null;
      
              command = ViewDB.prompt("Enter the command number: \r\n" + //
                            "0 - Exit the program\r\n" + //
                            "1 - View all animals\r\n" + //
                            "2 - Add an animal to the list 'Human_Friends'\r\n" + //
                            "3 - Remove an animal from the list 'Human_friends'\r\n" + //
                            "4- View animal commands\r\n" + //
                            "5 - Add a new command\r\n" + //
                            "6 - Total number of animals\r\n"+
                            "Enter:  ");
                            if (command.equals("0")) return;

            switch (command){              

             case "1":
             contHF.printHumanFriendsAll(list);
             break;
             case "2":
             int id = 0;
             LocalDate birthDate = null;
             try {
                id = Integer.parseInt(ViewDB.prompt("enter the animal's number: "));    
             } catch (Exception e) {
                System.out.println( "invalid input, try again");
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                break;
             }
            
             if (RepositoryHumanFriends.IsNumber(id, list)>0)
             {
                System.out.println("The number is already in the list, enter another one");
                break;
             }

             String  type = ViewDB.prompt("enter the type of animal: cat, dog, hamster, camel, horse, donkey: ").toLowerCase();        
             if(!type.equals("cat")&& !type.equals("dog")&& !type.equals("hamster")&& !type.equals("camel")&& !type.equals("horse")&& !type.equals("donkey")){
                System.out.println("wrong type of animal, try again ");
                 break;
             }
             String name = ViewDB.prompt("enter the animal's name: ");  

             try{
                DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
                birthDate = LocalDate.parse(ViewDB.prompt("enter the date in the format 'yyyy-MM-dd': "),dt); 
               
                }
                catch( Exception e ){
                    System.out.println( "invalid input, try again");
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                    break;
                }

            list.add(contHF.addNewFriends(id,type,name, birthDate));
            System.out.println("The animal added to the list");
            break;
                
            case "3":
            int idDelete = 0; 
            try {
                idDelete = Integer.parseInt(ViewDB.prompt("enter the animal's number: "));    
             } catch (Exception e) {
                System.out.println( "invalid input, try again");
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                break;
             }
            
             if (RepositoryHumanFriends.IsNumber(idDelete, list) == 0)
             {
                System.out.println("The number is not in the list");
                break;
             }

             contHF.deleteAnimal(idDelete,list);
             break;

             case "4":
             int idForCommands = 0; 
            try {
                idForCommands = Integer.parseInt(ViewDB.prompt("enter the animal's number: "));    
             } catch (Exception e) {
                System.out.println( "invalid input, try again");
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                break;
             }
            
             if (RepositoryHumanFriends.IsNumber(idForCommands, list) == 0)
             {
                System.out.println("The number is not in the list");
                break;
             }

            contHF.printCommands(idForCommands,list);
            break;

             case "5":
             int idAddCommands = 0; 
             try {
                 idAddCommands = Integer.parseInt(ViewDB.prompt("enter the animal's number: "));    
              } catch (Exception e) {
                 System.out.println( "invalid input, try again");
                 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                 break;
              }
             
              if (RepositoryHumanFriends.IsNumber(idAddCommands, list) == 0)
              {
                 System.out.println("The number is not in the list");
                 break;
              }

            contHF.addCommands(idAddCommands, list);        
            break;

            case "6":
            contHF.getCount(list);
            break;

        }
    }
}
}