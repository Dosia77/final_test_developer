
package com.animals.models.animals1;
import java.time.LocalDate;
import java.util.List;
//import com.animals.model.FileOperation;

public class Cats extends Pets{

    protected int number;
    protected String type;
    protected String name;
    protected LocalDate birthDate;
    protected List<String> commands;

    public Cats(int number, String type, String name, LocalDate birthDate, List<String> commands ){
        super(number,type, name, birthDate, commands );

    }
    
   @Override
    public  void songs(){
        System.out.print("Cat is mew\n");
    }
 }