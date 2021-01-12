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
public class movieInfo {
       private String title;

    private String director;

    private int MID;

    private int ratingid;

    private String description;
    private String rate;
private String length;


    public movieInfo(String title, String director,int MID, int ratingid,String length) {

        this.title = title;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
        this.director = director;
  this.ratingid = ratingid;
        this.MID = MID;
       this.length=length;
       

    }
  public movieInfo( int ratingid, String rate, String description) {

        this.ratingid = ratingid;
        this.rate=rate;

        this.description=description;

    }

   
   



    public String getMovieName() {

        return title;

    }
    

    public int getMID() {

        return MID;

    }


    public String getDirector() {

        return director;

    } public String getlength() {

        return length;

    }


    public String getrate() {

        return rate;

    }



    public int getratingid() {

        return ratingid;

    }



    public String getdescription() {

        return description;

    }
public void setMovieName(String title) {

         this.title=title;

    }
    

    public void setMID(int MID) {

        this.MID=MID;

    }


    public void setDirector(String director) {

        this.director=director;

    }



    public void setrate(String rate) {

        this.rate=rate;

    }



    public void setdescription(String description) {

        this.description=description;

    }



    public void setratingid(int ratingid) {

        this.ratingid=ratingid;

    }
 public void setlength(String length) {

        this.length=length;

 }


   
}
