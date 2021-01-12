/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw2fx;

/**
 *
 * @author rn210
 */
public class BookingDetails {
    
     private int phonenumber;
     private int movieshowtimeID;
      private String issued;
       private String expired;
     private int bookedseats;
     private int bookedtickets;
     private String MOP;
private int price;
private String customername;


    public BookingDetails(int movieshowtimeID,int bookedseats, int bookedtickets,String MOP,String issued,String expired,int price,String customername,int phonenumber) {

        
 this.bookedseats=bookedseats;
 this.bookedtickets=bookedtickets;
 this.movieshowtimeID = movieshowtimeID;
 this.MOP=MOP;
 this.issued=issued;
 this.expired=expired;
 this.price=price;
 this.phonenumber = phonenumber;
 this.customername=customername;
       }

    

   


    public int getmovieshowtime() {

        return movieshowtimeID;

    }
      public String getexpire() {

        return expired;

    }
      public String getcustomername() {

        return customername;

    }
      
       public String getissue() {

        return issued;

    }

    
     public int getprice() {

        return price;

    }
 public String getMOP() {

        return MOP;

    }

    public int gettickets() {

        return bookedtickets;

    }
  public int getseats() {

        return bookedseats;

    }
      public int getphone() {

        return phonenumber;

    }

  public void setmovieshowtime(int movieshowtimeID) {

        this.movieshowtimeID=movieshowtimeID;

    }
    

  

    public void settickets(int bookedtickets) {

        this.bookedtickets=bookedtickets;

    }

 public void setcustomername(String customername) {

        this.customername=customername;

    }

    public void setseats(int bookedseats) {

        this.bookedseats=bookedseats;

    }  

    public void setphone(int phonenumber) {

        this.phonenumber=phonenumber;

    }  
 public void setMOP(String MOP) {

        this.MOP=MOP;

    }  
 public void setexpire(String expired) {

        this.expired=expired;

    }  
  public void setissue(String issued) {

        this.issued=issued;

  }
   public void setprice(int price) {

        this.price=price;

    }  
}
