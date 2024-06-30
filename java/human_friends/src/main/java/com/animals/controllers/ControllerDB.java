package com.animals.controllers;
import com.animals.models.repositoryDB.DBrepository;
import java.sql.*;
import java.time.LocalDate;


public class ControllerDB{

    private final DBrepository repository;

    public ControllerDB(DBrepository repository) {
        this.repository = repository;
    }

    public void selectAll()throws SQLException
    
    {
        repository.selectAll();
    }

    public void addAnimal(String type, LocalDate birthDate)throws SQLException
    {
        repository.WriteDB(type, birthDate);
    }
    public void removeAnimal(int id)throws SQLException
    {
        repository.deleteAnimal(id);
    }
    public void countAnimals()
    {
        repository.countAnimals();
    }
    public void printAnmalCommands(int id)
    {
        repository.anmalCommands(id);
    }
    public void  addAnimalCommand(int id)
    {
        repository.addCommand(id);
    }

    
}