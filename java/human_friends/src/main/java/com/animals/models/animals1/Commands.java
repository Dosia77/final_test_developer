package com.animals.models.animals1;

public enum Commands{

    GO("1"),
    STOP("2"),
    RUN_AWEY("3"),
    COME_UP("4"),
    LIE("5"),
    JUMP("6"),
    TRUP("7"),
    STAND_UP("8");

    private String numberOperations;

    Commands(String numberOperations){
        this.numberOperations = numberOperations;
    }
    public String getNumberOperations(){
        return numberOperations;
    }
    public static void printMenu(){
        for(Commands c : Commands.values()){
            System.out.println(c+" - "+c.getNumberOperations());
        }
    }

}