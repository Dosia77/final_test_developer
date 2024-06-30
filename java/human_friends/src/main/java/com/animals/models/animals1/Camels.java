package com.animals.models.animals1;
import java.time.LocalDate;
import java.util.List;



public class Camels extends PackAnimals{
    protected int number;
    protected String type;
    protected String name;
    protected LocalDate birthDate;
    protected List<String> commands;

    public Camels(int number, String type, String name, LocalDate birthDate, List<String> commands ){
        super(number,type, name, birthDate, commands ); 
    }

   @Override
    public void songs(){
        System.out.print("Camel is mumbles funny\n");
    }
}