package com.animals.models.repositoryDB.impl;
import com.animals.models.repositoryDB.DBrepository;
import com.animals.views.ViewDB;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class RepositoryDB implements DBrepository{

  public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;

           public static  void selectTables(ResultSet rs)
            { 
                try {
                     while ( rs.next() ) {
                    Integer id = rs.getInt("ID");
                    String  type = rs.getString("type");
                    String  name = rs.getString("Name");
                    String birthDate = rs.getString("BirthDate"); 
                    String  commands = rs.getString("Commands");
                               
                      System.out.println( "ID = " + id );
                      System.out.println( "type = " + type);
                      System.out.println( "Name = " + name );
                      System.out.println( "BirthDate = " + birthDate);
                      System.out.println( "Commands = " + commands );
                      System.out.println(); 
                     
                   }    rs.close();


                } catch (Exception e) {
                  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                  System.exit(0);  
                } 
            }

            public static void Conn() throws ClassNotFoundException, SQLException 
            {
                conn = null;
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:human_friends.db");
                
                System.out.println("База Подключена!");
            }

            @Override
            public void WriteDB(String type, LocalDate birthDate) throws SQLException
            { 

             try {
                Conn();
               
                String name = ViewDB.prompt("enter name: ");
                String commands = ViewDB.prompt("enter commands: ");
                String sql = "INSERT INTO human_friends (type,Name,BirthDate,Commands)VALUES('"+type+"','"+name+"','"+birthDate+"','" +commands+ "');";
                statmt = conn.createStatement();
                statmt.execute(sql);
                System.out.println("Operation done successfully"); 
               
                conn.close();
			          statmt.close();
          
            } catch (Exception e) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);  
            }
               
        }

        @Override  
      public void selectAll()throws SQLException
     {  
        try {              
                Conn();
                
                String sql = " SELECT * FROM human_friends ORDER BY BirthDate ";
                statmt = conn.createStatement();
                ResultSet rs = statmt.executeQuery( sql );
                selectTables( rs);
                System.out.println("Operation done successfully"); 
                statmt.close();
                conn.close();
        } catch ( Exception e ) {
                 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
        }
    }
    @Override
      public void  deleteAnimal(int id)throws SQLException
    {
    
      try {
        Conn();
        statmt = conn.createStatement();
        String sql = "DELETE from human_friends where ID ="+id+";";
        statmt.executeUpdate(sql);
        System.out.println("Operation done successfully");   
        
        statmt.close(); 
        conn.close();

      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
         
      }
   
    }
    @Override
   public void countAnimals()
    {
     int count = 0;
       
    try {

            Conn();
            statmt = conn.createStatement();
            String sql = "SELECT * FROM human_friends; ";
            ResultSet rs = statmt.executeQuery( sql );
       while ( rs.next() ) {
            count = rs.getRow();
            count +=1;

        }   
        System.out.println("The total number of animals in the database "+(count-1));

            rs.close();
             statmt.close();
             conn.close();
         } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
         } 
                    
      }
      @Override
     public void anmalCommands(int id)
      {
    
            try {
             
               Conn();
                 statmt = conn.createStatement();
               
            String sql = "SELECT Name, Commands FROM human_friends WHERE id ="+id+";";
            ResultSet rs = statmt.executeQuery( sql );
      
            String  name = rs.getString("Name");
            String  commands = rs.getString("Commands");

            System.out.println( "Name = " + name );
            System.out.println( "Commands = " + commands );
 
            rs.close();
            statmt.close();
            conn.close();
          } catch ( Exception e ) {
             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
             System.exit(0);
          }      
       } 

       @Override
      public void addCommand(int id)
    {
   
      String command = ViewDB.prompt("enter new command: ");    
      
      try {
        
        Conn();
         statmt = conn.createStatement();
         String sql = "UPDATE human_friends SET Commands = (CONCAT(Commands, ', "+ command+"')) WHERE ID = "+id+";";
         statmt.executeUpdate(sql);
         System.out.println("Operation done successfully"); 

        statmt.close();
        conn.close();

      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
       

    }

    public static List<Integer> idList() {

       List<Integer> list = new ArrayList<Integer>();
      try {
       
        Conn();
        statmt = conn.createStatement();
        String sql = "SELECT ID FROM human_friends;";
 
        ResultSet rs = statmt.executeQuery( sql );
        while ( rs.next() ) {

        list.add(rs.getInt("ID"));                             
     
        } 
            rs.close();
            statmt.close();
            conn.close();
         
          } catch ( Exception e ) {
             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
             System.exit(0);
          }
     
      return list;
    }

      public static int IsNumberDB(int number, List<Integer> list){

        int count = 0;
         
        for (Integer in: list){
            if (in == number){
              count = count+1;
            }           
        }
         return count;
    }

}
