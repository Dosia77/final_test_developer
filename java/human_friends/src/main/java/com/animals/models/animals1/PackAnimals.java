package com.animals.models.animals1;
import java.util.List;
import java.time.LocalDate;

public abstract class PackAnimals extends HumanFriends{
 
    protected int number;
    protected String type;
    protected String name;
    protected LocalDate birthDate;
    protected List<String> commands;

    public PackAnimals(int number, String type, String name, LocalDate birthDate, List<String> commands ){
        super(number,type, name, birthDate, commands );
       
     }
}