package com.animals.models.animals1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.time.LocalDate;

public class HumanFriends{ 
    public static int counter;
    protected int number;
    protected String type;
    protected String name;
    protected LocalDate birthDate;
    protected List<String> commands;

    public HumanFriends( int number, String type, String name, LocalDate birthDate, List<String> commands ){
        
        this.number = number;
        this.type = type;
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public int getNumber() {
        return number;
    }
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<String> getCommads() {
        return commands;
    }


    public void songs(){
        System.out.print("Animal is makes sounds");
    }


    @Override
    public String toString() {
        return "HumanFriends: \n" +
                 "number "+number+"\n"+
                "type "+ type + "\n"+
                "name " + name + "\n"+
                "birthDate " + birthDate +"\n"+
                "commands " + commands+"\n"; 
                
    }

    public static List<HumanFriends> sortByDate(List<HumanFriends> list){
    
       Collections.sort(list, Comparator.comparing(HumanFriends::getBirthDate));
       return list;
    }

     public static List<HumanFriends> createList()
   {
    List<HumanFriends> lst = new ArrayList<>();

    Cats cat = new Cats(1, "cat","Vasia", LocalDate.of(2021,10,10), new ArrayList<>(List.of("Meow","Go")));
    Dogs dog = new Dogs(2,"dog","Bobik", LocalDate.of(2020,10,10), new ArrayList<>(List.of("Sit","Woof")));
    Hamsters hamster = new Hamsters(3, "hamster", "Homa", LocalDate.of(2024,12,12), new ArrayList<>(List.of("Uups", "Eat")));
    Camels camel = new Camels(4, "camel", "Verblud", LocalDate.of(2020,12,12), new ArrayList<>(List.of("Walk", "Sit")));
    Horses horse = new Horses(5, "horse", "Wind", LocalDate.of(2017,3,11), new ArrayList<>(List.of("Trot", "Canter")));
    Donkeys donkey = new Donkeys(6, "donkey", "Ia-Ia", LocalDate.of(2017,5,7), new ArrayList<>(List.of("Walk","Bray","Kick")));
    lst.add(cat);
    lst.add(dog);
    lst.add(hamster);
    lst.add(camel);
    lst.add(horse);
    lst.add(donkey);
    counter = 6;

    return lst;
   }
}