package com.animals.models.repositoryDB;
import java.sql.*;
import java.time.LocalDate;

public interface DBrepository {

    
    void selectAll() throws SQLException;
    void WriteDB(String type, LocalDate birthDate) throws SQLException;
    void  deleteAnimal(int id) throws SQLException;
    void countAnimals();
    void anmalCommands(int id);
    void addCommand(int id);
}