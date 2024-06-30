package com.animals.controllers;
import com.animals.models.repositoryHF.HFrepository;
import java.time.LocalDate;
import java.util.List;
import com.animals.models.animals1.*;


public class ControllerHF{

     private final HFrepository repository;

    public ControllerHF(HFrepository repository) {
        this.repository = repository;
    }

    public void printHumanFriendsAll(List<HumanFriends> list)
    {
        repository.printHF(list);
    } 

    public  HumanFriends addNewFriends(int number,String type, String name, LocalDate birthDate )
    {
      return repository.createFriends(number,type, name, birthDate);
    }
    public  void deleteAnimal(int number, List<HumanFriends> list)
    {
        repository.deleteHFriend(number, list);
    }
    public void printCommands(int number,List<HumanFriends> list)
    {
        repository.printCommands(number, list);
    }
    public void addCommands(int number,List<HumanFriends> list)
    {
        repository.addCommands(number, list);
    }
    public void getCount(List<HumanFriends> list)
    {
        repository.getCount(list);
    }

}
