package com.animals;
import  java.sql.*;
import com.animals.controllers.ControllerHF;
import com.animals.controllers.ControllerDB;
import com.animals.models.animals1.*;
import com.animals.models.repositoryDB.impl.RepositoryDB;
import com.animals.models.repositoryHF.impl.RepositoryHumanFriends;
import com.animals.views.ViewDB;
import com.animals.views.ViewHF;

public class Program
{    
    public static void main( String[] args )throws ClassNotFoundException, SQLException 
    
    {
   
      RepositoryHumanFriends rHF = new RepositoryHumanFriends();
      ControllerHF controller = new ControllerHF(rHF);
      ViewHF hf = new ViewHF(controller);
      hf.runHumanFriends(HumanFriends.createList());

      RepositoryDB rDB = new RepositoryDB();
      ControllerDB controller2 = new ControllerDB(rDB);
      ViewDB db = new ViewDB(controller2);
      db.runDatabase();
      
    }

}
      

