/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw2fx;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author rn210
 */
public class Cinema extends Application {
       private TextField name = new TextField();
  private RadioButton movie1=new RadioButton("Aquaman");
  private RadioButton movie2=new RadioButton("Infinity War");
  private RadioButton movie3=new RadioButton("Captain Marvel");
       private RadioButton movie4=new RadioButton("Aladdin");
       private Label screen=new Label("Theator name");
        private Label theator=new Label();
       private RadioButton screen1=new RadioButton("MAX") ;
        private RadioButton screen2=new RadioButton("IMAX") ;
        private RadioButton screen3=new RadioButton("Standard");
        private TextField time=new TextField();
           private RadioButton pay1=new RadioButton("credit") ;
        private RadioButton pay2=new RadioButton("Cash") ;
       private Button bookseat=new Button("book seats");
  private TextField tickets = new TextField();
  private TextField phone = new TextField();
  private TextField total=new TextField();
  ToggleGroup toggleGroup =new ToggleGroup();
  ToggleGroup toggleGroup1=new ToggleGroup();
    ToggleGroup toggleGroup2=new ToggleGroup();
  private Label ticketprice = new Label();
   private TextField seat1 = new TextField();
    private TextField issue = new TextField();
     private TextField expire = new TextField();
   private Label noofseats = new Label("no of seats");
   private Label id = new Label();
  private Button btBook = new Button("Book Tickets");
   private Button bttotal = new Button("Total");
   private Button Details = new Button("Details");
   private Button showscreen=new Button("show screen");
   private Button btclear=new Button("Clear");
    private Button removeseat=new Button("remove seat");
   Dbconnection db=new Dbconnection();
   
    @Override
    public void start(Stage primaryStage) {
       GridPane pane = new GridPane();
    pane.add(new Label("Customer Name"), 0, 0);
    pane.add(name, 1, 0);    
    pane.add(new Label("Phone no"),2,0);
    pane.add(phone,3,0);
   
    pane.add(new Label("Select Movie"), 0, 1);
    pane.add(movie1, 1, 1);
    movie1.setSelected(true);
    pane.add(movie2,2,1);
    pane.add(movie3,3,1);
    pane.add(movie4,4,1);
    movie1.setToggleGroup(toggleGroup);
    movie2.setToggleGroup(toggleGroup);
    movie3.setToggleGroup(toggleGroup);
    movie4.setToggleGroup(toggleGroup); 
    screen1.setToggleGroup(toggleGroup1);
    screen2.setToggleGroup(toggleGroup1);
    screen3.setToggleGroup(toggleGroup1);
    pay2.setToggleGroup(toggleGroup2);
    pay1.setToggleGroup(toggleGroup2);
     pane.add(new Label("movieshowtime_id is "),2,7);
    pane.add(id,3,7);
    pane.add(new Label("No of tickets"), 0, 2);
    pane.add(tickets,1,2);
    pane.add(new Label("Ticketprice"), 0, 3);
    pane.add(ticketprice,1,3);
    pane.add(new Label("Total cost"),0,4);
    pane.add(total,1,4);
    pane.add(screen, 0, 5);
    pane.add(screen1,1,5);
    pane.add(screen2,2,5);
    pane.add(screen3,3,5);
    pane.add(new Label("time"), 0, 6);
    pane.add(time,1,6);
    pane.add(new Label("theator_id is"),2,6);
    pane.add(theator,3,6);
    pane.add(noofseats,0,7);
    pane.add(seat1,1,7);
    pane.add(new Label("issue"),0,9);
    pane.add(issue,1,9);
    pane.add(new Label("expire"),2,9);
    pane.add(expire,3,9);
    pane.add(new Label("Mode of payment"),0,8);
    pane.add(pay1, 1, 8);
    pane.add(pay2,2,8);
    pane.add(Details,0,10);
    pane.add(showscreen,1,10);
    GridPane.setHalignment(Details,HPos.LEFT);
    pane.add(btBook, 2, 10);
    GridPane.setHalignment(btBook, HPos.RIGHT);
    pane.add(bttotal,3,10);
    pane.add(btclear,0,11);
    pane.add(removeseat,1,11);
    pane.add(bookseat,2,11);
    pane.setAlignment(Pos.CENTER);   
  
    Scene scene = new Scene(pane,1000, 500);
    primaryStage.setTitle("Cinema"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show();
    
toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
    @Override
    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

         if (movie1.isSelected()) {
ticketprice.setText("45");}
         else if(movie2.isSelected()){
             ticketprice.setText("55");
         }
         else if(movie3.isSelected()){
             ticketprice.setText("45");
         } 
         else if(movie4.isSelected()){
             ticketprice.setText("20");
         } 
             // Do something here with the userData of newly selected radioButton
    }
    } );
toggleGroup1.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
    @Override
    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

         if (movie1.isSelected() && screen1.isSelected()) {
           time.setText("17:30");
         id.setText("4");}
         else if(movie1.isSelected()&& screen2.isSelected()){
             time.setText("10:30");
             id.setText("5");
         }
         else if(movie1.isSelected()&& screen3.isSelected()){
             time.setText("22:30");
             id.setText("6");
         } 
         else if(movie2.isSelected()&& screen1.isSelected()){
             time.setText("23:00");
             id.setText("7");
         }
         else if(movie2.isSelected()&& screen2.isSelected()){
             time.setText("9:00");
             id.setText("8");
         } 
        else if(movie2.isSelected()&& screen3.isSelected()){
             time.setText("17:30");
             id.setText("9");
         }
         else if(movie3.isSelected()&& screen1.isSelected()){
             time.setText("20:00");
             id.setText("1");
         }
         else if(movie3.isSelected()&& screen2.isSelected()){
             time.setText("13:00");
           id.setText("2");
         }
         else if(movie3.isSelected()&& screen3.isSelected()){
             time.setText("10:00");
             id.setText("3");
         }
         else if(movie4.isSelected()&& screen1.isSelected()){
             time.setText("12:00");
             id.setText("10");
         }
         else if(movie4.isSelected()&& screen2.isSelected()){
             time.setText("18:00");
             id.setText("11");
         }
         else if(movie4.isSelected()&& screen3.isSelected()){
             time.setText("8:00");
             id.setText("12");
         }
         
         } 
          
             // Do something here with the userData of newly selected radioButton
    }
     );

toggleGroup2.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
    @Override
    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

         if (pay1.isSelected()) {
issue.setEditable(true);
   expire.setEditable(true);      
         }
         else if(pay2.isSelected()){
             issue.setEditable(false);
             expire.setEditable(false);
         }
         
         
             // Do something here with the userData of newly selected radioButton
    }
    } );
toggleGroup1.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
    @Override
    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

         if (screen1.isSelected()) {
theator.setText("10");}
         else if(screen2.isSelected()){
             theator.setText("20");
         }
         else if(screen3.isSelected()){
             theator.setText("30");
         } 
        
             // Do something here with the userData of newly selected radioButton
    }
    } );

Details.setOnAction(new details());
btBook.setOnAction(new book());
showscreen.setOnAction(new screens());
bttotal.setOnAction(new total());
btclear.setOnAction(new clear());
bookseat.setOnAction(new seats());
removeseat.setOnAction(new deleteseats());
    }

     private class deleteseats implements EventHandler<ActionEvent> {
 @Override
    public void handle(ActionEvent e) {
Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema","root","rnaug1998");
           
             Statement stat=con.createStatement(); 
    int bookedseats=Integer.parseInt(seat1.getText());
    int theator_id=Integer.parseInt(theator.getText());
           String sql="update auditorium set seatsavailable=seatsavailable+"+ bookedseats +" where theator_id="+theator_id;
 stat.executeUpdate(sql);
 
System.out.println("Seats deleted");
    
        
    } catch (Exception ex) {
        
    System.out.println("Eror:"+ex);
    
     }
       
    }
    }

    private class seats implements EventHandler<ActionEvent> {
 @Override
    public void handle(ActionEvent e) {
Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema","root","rnaug1998");
           
             Statement stat=con.createStatement(); 
    int bookedseats=Integer.parseInt(seat1.getText());
    int theator_id=Integer.parseInt(theator.getText());
           String sql="update auditorium set seatsavailable=seatsavailable-"+ bookedseats +" where theator_id="+theator_id;
 stat.executeUpdate(sql);
 
System.out.println("Seats booked");
    
        
    } catch (Exception ex) {
        
    System.out.println("Eror:"+ex);
    
     }
       
    }
    }
private class details implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
       db.getDbconnection();
        db.showMovies();
      
        
    }
}
private class total implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        int price=Integer.parseInt(ticketprice.getText());
      int nooftickets=Integer.parseInt(tickets.getText());
      int result=price*nooftickets;
      total.setText(Integer.toString(result));}}
private class book implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
     Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema","root","rnaug1998");
           String sql="insert into bookings(movieshowtime_id,bookseats,booktickets,pay_type,issue,expire,price,customername,phone) values(?,?,?,?,?,?,?,?,?)";
           
           PreparedStatement ps=con.prepareStatement(sql);
        
int movieshowtimeID=Integer.parseInt(id.getText());
int bookedseats=Integer.parseInt(seat1.getText());
String issued=issue.getText();
String expired=expire.getText();
String customername=name.getText();
int phonenumber=Integer.parseInt(phone.getText());
 int bookedtickets=Integer.parseInt(tickets.getText());
           int price=Integer.parseInt(total.getText());
String MOP="Cash";

if (pay1.isSelected()){
    MOP="credit";
}
BookingDetails b=new BookingDetails(movieshowtimeID,bookedseats,bookedtickets,MOP, issued,expired, price,customername, phonenumber);
          
           ps.setInt(1,movieshowtimeID);
           ps.setInt(2,bookedseats);
            ps.setInt(3,bookedtickets);
            ps.setString(4,MOP);
            ps.setString(5,issued);
            ps.setString(6,expired);
            ps.setInt(7,price);
           ps.setString(8,customername);
           ps.setInt(9,phonenumber);
           int i=ps.executeUpdate();
           System.out.println(""+i+""+"Record inserted");
}       catch (Exception ex) {
            System.out.println(ex);
        }
       
    }

       
    }
private class screens implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        db.getDbconnection();
        db.showscreens();
        
    }
}
private class clear implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
      name.setText("");
      time.setText("");
      tickets.setText("");
      total.setText("");
      phone.setText("");
      movie1.setSelected(true);
      screen1.setSelected(true);
    }
}

  /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }

}

