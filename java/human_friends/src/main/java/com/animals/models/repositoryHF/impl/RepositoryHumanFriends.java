package com.animals.models.repositoryHF.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.animals.models.animals1.*;
import com.animals.models.repositoryHF.HFrepository;
import com.animals.views.ViewDB;


public class RepositoryHumanFriends implements HFrepository{


 @Override
public void printHF(List<HumanFriends> list){
    System.out.println(HumanFriends.sortByDate(list));

}

@Override
public void printCommands(int number,List<HumanFriends> list){

   List<String> commands = null;   
  
      for (HumanFriends hf: list){
      if (hf.getNumber() == number){
         commands  = hf.getCommads(); 
         System.out.println("Animal "+hf.getName()+" follows commands: "+ commands);   
         break; 
  
       } 
     
     }
       
     }

      @Override
      public HumanFriends createFriends(int number,String type, String name, LocalDate birthDate) {
     
          List<String> commands = new ArrayList<String>();
          addCommands(commands);
          HumanFriends.counter = HumanFriends.counter + 1;
          
          
          // if (type.equals("cat"))
          // {
            
          // }
          return new HumanFriends(number,type, name, birthDate, commands);
      
      }
  
      @Override
      public void deleteHFriend(int number, List<HumanFriends> list)
      {
         
          for (HumanFriends hf: list){
              if (hf.getNumber() == number){
                 list.remove(hf);
                 HumanFriends.counter = HumanFriends.counter - 1;
                 System.out.println("The animal removed from the list");
                 break;
              } 
             
          }
      }

      public static int IsNumber(int number, List<HumanFriends> list){

        int count = 0;
         
        for (HumanFriends hf: list){
            if (hf.getNumber() == number){
              count = count+1;
            } 
          
        }

       return count;
      }
     
      @Override
      public void getCount(List<HumanFriends> list){

       // System.out.println("The total number of animals on the list "+list.size());
       System.out.println("The total number of animals on the list "+ HumanFriends.counter);
    }

    @Override
    public void addCommands(int number, List<HumanFriends> list){

      Commands.printMenu();
     String comm = ViewDB.prompt("Select command by number: ");
     String command = null;
     switch (comm) {
      case "1":
        command= "Go";
        break;
     case "2":
      command = "Stop";
      break;
      case "3":
       command = "Run_Awey";
       break;
     case "4":
       command = "Come_Up";
       break;
       case "5": 
       command= "Lite";
       break;
       case "6":
       command = "Jump";
       break;
       case "7":
       command = "Trup";
      break;
       case "8":
       command = "Stand_Ap";
       break;
      default:
      System.out.println("There is no such command in the list");
       return;
     }

      for (HumanFriends hf: list){
        if (hf.getNumber()== number){      
          hf.getCommads().add(command);
           System.out.println("Animal "+hf.getName()+" follows commands "+ hf.getCommads());   
           break;
        } 

      }

    }

    public void addCommands(List<String> list){

    Commands.printMenu();
     String comm = ViewDB.prompt("Select command by number: ");
     String command = null;
     switch (comm) {
      case "1":
        command= "Go";
        break;
     case "2":
      command = "Stop";
      break;
      case "3":
       command = "Run_Awey";
       break;
     case "4":
       command = "Come_Up";
       break;
       case "5": 
       command= "Lite";
       break;
       case "6":
       command = "Jump";
       break;
       case "7":
       command = "Trup";
      break;
       case "8":
       command = "Stand_Ap";
       break;
      default:
      System.out.println("There is no such command in the list");
       return;
     }

      list.add(command);
   
    }
}