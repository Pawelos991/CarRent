/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import pl.models.Car;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;
import pl.models.Date;
import pl.models.Mileage;

/**Class for the price methods tests
 *
 * @author Pawel
 * @version 1.4
 */
public class PriceTest {
    /**Tested object*/
    private Car car;
    
    @BeforeEach
    void setUp(){
        car = new Car(1,"TestCar","TestMileage",2015, new Mileage(new Date(2015,10,12),0),false,15);
    }
    
    /**Function that tests the changeRentPrice method
     * 
     * @param newPrice The value of the new price that should be set
     */
    @ParameterizedTest
    @ValueSource(floats = {10,15,20,5,0,-10,-15,-20})  
    void testChangeRentPrice(float newPrice) {
        
        try{
            car.changeRentPrice(newPrice);
            if(newPrice<=0)
            {
                fail("Should throw exception trying to set new price less or equal to zero");
            }
            else
            {
                assertEquals(car.getPrice(),newPrice);
            }
        }
        catch(Exception e){
            if(newPrice>0)
                fail("Trying to set new price fails");
        }
    }
    
    /**Function that tests the raiseRentPrice method
     * 
     * @param newPrice The value of the new price that should be set
     */
    @ParameterizedTest
    @ValueSource(floats = {10,15,20,5,0,-10,-15,-20})  
    void testRaiseRentPrice(float newPrice){
        
        float oldPrice = car.getPrice();
        
        try{
            car.raiseRentPrice(newPrice);
            if(newPrice<=0)
            {
                fail("Should throw exception trying to set new price less or equal to zero");
            }
            else if(newPrice<=oldPrice)
            {
                fail("Should throw exception trying to set new price less or equal to the previous one");
            }
            else
            {
                assertEquals(car.getPrice(),newPrice);
            }
        }
        catch(Exception e){
            if(newPrice>oldPrice)
                fail("Trying to raise the price to a given value fails");
        }
    }
    
    /**Function that tests the raiseRentPriceByAnAmount method
     * 
     * @param amount The amount by which the price should be raised
     */
    @ParameterizedTest
    @ValueSource(floats = {10,15,20,5,0,-10,-15,-20})  
    void testRaiseRentPriceByAnAmount(float amount){
        
        float oldPrice = car.getPrice();
        
        try{
            car.raiseRentPriceByAnAmount(amount);
            if(amount<=0)
            {
                fail("Should throw exception trying to give a non-positive amount");
            }
            else
            {
                assertEquals(car.getPrice(),oldPrice+amount);
            }
        }
        catch(Exception e){
            if(amount>0)
                fail("Trying to raise the price by a given amount fails");
        }
        
    }
    
    /** Function that tests the lowerRentPrice method
     * 
     * @param newPrice The value of the new price that should be set
     */
    @ParameterizedTest
    @ValueSource(floats = {10,15,20,5,0,-10,-15,-20})  
    void testLowerRentPrice(float newPrice){
        
        float oldPrice = car.getPrice();
        
        try{
            car.lowerRentPrice(newPrice);
            if(newPrice<=0)
            {
                fail("Should throw exception trying to set new price less or equal to zero");
            }
            else if(newPrice>=oldPrice)
            {
                fail("Should throw exception trying to set new price greater or equal to the previous one");
            }
            else
            {
                assertEquals(car.getPrice(),newPrice);
            }
        }
        catch(Exception e){
            if(newPrice<oldPrice && newPrice>0)
                fail("Trying to lower the price to a given value fails");
        }
    }
    
    /**Function that tests the lowerRentByAnAmount method
     * 
     * @param amount The amount by which the price should be lowered
     */
    @ParameterizedTest
    @ValueSource(floats = {10,15,20,5,0,-10,-15,-20})  
    void testLowerRentPriceByAnAmount(float amount){
        
        float oldPrice = car.getPrice();
        
        try{
            car.lowerRentPriceByAnAmount(amount);
            if(amount<=0)
            {
                fail("Should throw exception trying to give a non-positive amount");
            }
            else if(oldPrice-amount<=0)
            {
                fail("Should throw exception trying to set new price less or equal to zero");
            }
            else
            {
                assertEquals(car.getPrice(),oldPrice-amount);
            }
        }
        catch(Exception e){
            if(amount>0 && oldPrice-amount>0)
                fail("Trying to lower the price by a given amount fails");
        }
        
    }
}
