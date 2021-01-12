/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw2fx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rn210
 */
public class Dbconnection {
   private Connection con;
   private Statement st;
   private ResultSet rs;

   public void getDbconnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema","root","rnaug1998");
        st= con.createStatement();
        } catch (Exception ex) {
           System.out.println("Error "+ex);
       }
        
    }
    public void showMovies(){
        try{
            String query="select * from movies";
            rs=st.executeQuery(query);
            System.out.println("Getting details from database");
         
            while(rs.next()){
                int MID=rs.getInt("MID");
            String title=rs.getString("title");
            String director=rs.getString("director");
             String length=rs.getString("lengthtime");
            int ratingid=rs.getInt("rating_id");
         movieInfo m=new movieInfo(title, director,MID, ratingid, length);
                    
            System.out.println("id is "+MID+"\n"+"name "+ title+","+"\n" + "director "+director+","+"\n"+"lengthtime "+length+"\n" +"rating id is "+ratingid+"\n");
        }
        }catch(Exception ex){
            System.out.print(ex);
        }
    }
    public void showscreens(){
        try{
        String query1="select * from movieshowtime";
        rs=st.executeQuery(query1);
        System.out.println("Getting details from database");
         while(rs.next()){
             int id=rs.getInt("id");
             int MID=rs.getInt("MID");
            
            int theatorid=rs.getInt("theator_id");
             String timings=rs.getString("timings");
           
            System.out.println("id is"+id+"\n"+"MID is "+MID+"\n"+"theator id is "+theatorid+"\n"+"time "+timings);
                    
           
        }
        }catch(Exception ex){
            System.out.print(ex);
        }
    }
   
        
 
 }


    

