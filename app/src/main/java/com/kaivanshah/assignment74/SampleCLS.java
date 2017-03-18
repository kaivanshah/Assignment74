package com.kaivanshah.assignment74;

/**
 * Created by kaivanrasiklal.s on 18-03-2017.
 */

public class SampleCLS {


    //private variables
    int _Id;
    String _FName;
    String _LName;


    // Empty constructor
    public SampleCLS(){

    }
    // constructor
    public SampleCLS(int id, String FName, String LName){
        this._Id = id;
        this._FName = FName;
        this._LName = LName;
    }

    // getting ID
    public int getID(){
        return this._Id;
    }

    // setting id
    public void setID(int id){
        this._Id = id;
    }

    // getting name
    public String getFName(){
        return this._FName;
    }

    // setting name
    public void setFName(String fname){
        this._FName = fname;
    }

    // getting Age
    public String getLName(){
        return this._LName;
    }

    // setting Age
    public void setLName(String LName){
        this._LName = LName;
    }

}
