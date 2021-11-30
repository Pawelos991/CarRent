/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.models;

/**Class that represents Mileage of a car
 *
 * @author Pawel
 * @version 1.4
 */
public class Mileage {
    /**Date when the mileage was registered*/
    private Date date;
    /**The value of the mileage*/
    private int mileage;
    
    /**Constructor of the Mileage class
     * 
     * @param datE Date when the mileage was registered
     * @param mileagE The value of the mileage
     */
    public Mileage(Date datE, int mileagE){
        date=datE;
        mileage=mileagE;
    }
    
    /**The method that returns the date when the Mileage was registered
     * 
     * @return Date when the mileage was registered
     */
    public Date getDate(){
        return date;
    }
    
    /**The method that return the value of the mileage
     * 
     * @return The value of the mileage
     */
    public int getMileage(){
        return mileage;
    }
    
}
