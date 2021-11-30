/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.models;

import java.util.ArrayList;
import java.util.List;
import pl.exceptions.MileageException;

/**Class representing a car
 *
 * @author Pawel Mika
 * @version 1.4
 */
public class Car {
    /**ID of a car*/
    private int id;
    /**Make of the car*/
    private String make;
    /**Model of the car*/
    private String model;
    /**Year of production*/
    private int year;
    /**List of mileage records of the car*/
    private List<Mileage> mileages;
    /**Information, if the car is rented*/
    private boolean rented;
    /**Price of every hour of the rent*/
    private float hourPrice;
    
    /**Constructor of the Car class
     * 
     * @param ID ID of the car
     * @param Make Make of the car
     * @param Model Model of the car
     * @param Year Year of production of the car
     * @param mileagE First registered mileage
     * @param Rented Information whether the car is rented or not
     * @param HourPrice Price of an hour rent
     */
    public Car(int ID,String Make, String Model, int Year, Mileage mileagE,boolean Rented,float HourPrice){
        id=ID;
        make=Make;
        model=Model;
        year=Year;
        mileages= new ArrayList<>();
        mileages.add(mileagE);
        rented=Rented;
        hourPrice=HourPrice;
    }
    /** Function to read the make of the car
     * 
     * @return Make of the car
     */
    public String getMake(){
        return make;
    }
    
    /**Function to read the model of the car
     * 
     * @return Model of the car
     */
    public String getModel(){
        return model;
    }
    
    /**Function to read the year of production of the car
     * 
     * @return Year of production
     */
    public int getYear(){
        return year;
    }
    
    /**Function that checks whether the car is rented
     * 
     * @return true - the car is rented / false - the car is not rented
     */
    public boolean isRented(){
        return rented;
    }
    
    /**Function that sets the rented value true
     * 
     */
    public void setRented(){
        rented=true;
    }
    
    /**Function that sets the rented value false
     * 
     */
    public void setReturned(){
        rented=false;
    }
    
    /**Function that returns the price of one hour rent
     * 
     * @return Price of one hour rent
     */
    public float getPrice(){
        return hourPrice;
    }
    
    /**Function that returns the id of the car
     * 
     * @return ID of the car
     */
    public int getID(){
        return id;
    }
    
    /**Function that returns the list of the mileage records of the car
     * 
     * @return List of the mileage records of the car
     */
    public List<Mileage> getMileages(){
        return mileages;
    }
    
    /**Method that adds a new mileage to the list of mileages
     * 
     * @param added Added mileage
     * @throws MileageException if date of the added mileage is not later than the latest
     * in the record or if the value is lesser than the latest in the record
     */
    public void addMileage(Mileage... added) throws MileageException{
        for(Mileage add : added)
        {
            if(add!=null)
            {
                Mileage latest = mileages.get(mileages.size()-1);
                if(latest.getDate().isLaterThan(add.getDate()))
                    throw new MileageException("Dodawany przebieg powinien mieć późniejsza datę niż ostatni w liście");
                else if(add.getMileage()<latest.getMileage())
                    throw new MileageException("Dodawany przebieg powinien mieć większą wartość przebiegu niż ostatni w liście");
                 else if(add.getMileage()<0)
                     throw new MileageException("Dodawany przebieg powinien mieć wartość przebiegu większą niż zero");
                 else
                  mileages.add(add); 
            }
            else
                throw new MileageException("Dodawany przebieg nie może być nullem");   
        }
    }
    
    /**Function that tries to set the rented value to true if possible
     * 
     * @throws Exception is the car is already rented
     */
    public void tryRent() throws Exception{
        if(rented==true)
            throw new Exception("Samochód jest już wypożyczony");
        else
            this.setRented();
    }
    
    /**Function that tries to set the rented value to false if possible
     * 
     * @throws Exception is the car is already returned
     */
    public void tryReturn() throws Exception{
        if(rented==false)
            throw new Exception("Samochód jest już zwrócony");
        else
            this.setReturned();
    }
    
    /**Function that sets the new price of an hour rent
     * 
     * @param newPrice New price of an hour rent
     * @throws Exception if the new price is non-postivie
     */
    public void changeRentPrice(float newPrice) throws Exception{
        if(newPrice<=0)
            throw new Exception("Nowa cena nie może być mniejsza lub równa zero");
        else
            hourPrice=newPrice;
    }
    
    /**Function that raises the price of an hour rent to the new value
     * 
     * @param newPrice New price of and hour rent
     * @throws Exception if the new price is non-positive or if the new price 
     * is not greater than the previous one
     */
    public void raiseRentPrice(float newPrice) throws Exception{
        if(newPrice<=0)
            throw new Exception("Nowa cena nie może być mniejsza lub równa zero");
        else if(newPrice<=hourPrice)
            throw new Exception("Nowa cena nie może być mniejsza lub równa niż poprzednia cena");
        else
            hourPrice=newPrice;
    }
    
    /**Function that raises the price of an hour rent by the given amount
     * 
     * @param amount How much should be added to the price
     * @throws Exception if the new price is non-positive or if the new price 
     * is not greater than the previous one 
     */
    public void raiseRentPriceByAnAmount(float amount) throws Exception{
        if(amount<=0)
            throw new Exception("Nowa cena nie może być mniejsza lub równa niż poprzednia cena");
        else
            hourPrice+=amount;
    }
    
    /**Function that lowers the price of an hour rent to the new value
     * 
     * @param newPrice New price of an hour rent
     * @throws Exception if the new price is non-positive or if the new price
     * is not lesser than the previous one
     */
    public void lowerRentPrice(float newPrice) throws Exception{
        if(newPrice<=0)
            throw new Exception("Nowa cena nie może być mniejsza lub równa zero");
        else if(newPrice>=hourPrice)
            throw new Exception("Nowa cena nie może być większa lub równa niż poprzednia cena");
        else
            hourPrice=newPrice;
    }
    
    /**Function that lowers the price of an hour rent by the given amount
     * 
     * @param amount How much should be substracted from the previous price
     * @throws Exception if the new price is non-positive or if the new price
     * is not lesser than the previous one
     */
    public void lowerRentPriceByAnAmount(float amount) throws Exception{
        if(amount<=0)
            throw new Exception("Nowa cena nie może być większa lub równa niż poprzednia cena");
        else if(hourPrice-amount<=0)
            throw new Exception("Nowa cena nie może być mniejsza lub równa zero");
        else
            hourPrice-=amount;
    }
    
}