package com.acenovator.moneymanager.models;

/**
 * Created by nimzy on 1/19/2016.
 */
public class Category {
    //private variables
    int _id;
    String _name;
    String _type;

    // Empty constructor
    public Category(){
    }

    // constructor
    public Category(int id, String name, String type){
        this._id = id;
        this._name = name;
        this._type = type;
    }

    // constructor
    public Category(String name, String type){
        this._name = name;
        this._type = type;
    }

    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting type
    public String getType(){
        return this._type;
    }

    // setting type
    public void setType(String type){
        this._type = type;
    }
}
