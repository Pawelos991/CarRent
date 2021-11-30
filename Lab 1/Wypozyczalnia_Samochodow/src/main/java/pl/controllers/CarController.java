/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.controllers;

import java.util.ArrayList;
import java.util.List;
import pl.models.Car;
import pl.models.Date;
import pl.models.Mileage;
import pl.views.CarView;


/**Car controller class
 *
 * @author Pawel Mika
 * @version 1.3
 */
public class CarController {
    /**Cars table*/
    private List<Car> cars;
    /**View*/
    private CarView view;
    
    /**Car Controller constructor
     * 
     * @param cars Cars table
     * @param view View
     */
    public CarController (List<Car> cars, CarView view){
        this.cars=cars;
        this.view=view;
    }
    
    /**Function to manage the CarRent
     * 
     */
    public void runTheRent(){
        
        String name;
        name = view.displayHello();
        if(name==null)
        {
          return;
        }
        while(true)
        {
            int choice1;
            choice1=view.displayOptions(name);
            if(choice1==0 || choice1==1) //User wants to rent/return a car
            {
                int choice2 = view.displayCars(cars);
                if(choice2!=-1) 
                {
                   if(choice1==0) //User wants to rent a car
                    {
                        boolean success=tryToRent(choice2);
                        if(success==true)
                        {
                            view.displaySuccessfulRent();
                        }
                        else
                        {
                          view.displayUnsuccessfulRent();  
                        }
                    }
                   else //User wants to return a car
                    {
                        boolean success=tryToReturn(choice2);
                        if(success==true)
                        {
                            boolean successfullyReturned = false;
                            while(successfullyReturned != true) //Proces of updating mileage after return
                            {
                                int mileageValue = view.askMileage();
                                if(mileageValue!=-100)
                                {
                                    Date dateOfReturn = new Date();
                                    Mileage mileage = new Mileage(dateOfReturn, mileageValue);
                                    successfullyReturned = tryAddMileage(choice2,mileage);
                                    if(successfullyReturned==false)
                                    {
                                        view.displayUnsuccessfulAddMileage();
                                    }
                                }
                                else
                                {
                                    view.displayNeedMileage();
                                }
                            }
                            view.displaySuccessfulReturn();
                        }
                        else
                        {
                            view.displayUnsuccessfulReturn();
                        }
                    } 
                }
                
            }
            else if(choice1 == 3) //User wants to display the table of cars
            {
                view.displayCarsTable(cars);
                break;
            }
            else if(choice1 == 6) //User wants to change the price of a car rent
            {
                int choice2 = view.displayCars(cars);
                if(choice2!=-1)
                {
                   int choice3 = view.displayChangePriceOptions();
                   if(choice3==0) //User wants to raise the price of an hour rent
                   {
                       int choice4 = view.displayRaisePriceOptions();
                       int value = view.askValueChangePrice(choice4+1);
                       boolean success = tryChangePrice(choice2,choice3,choice4,value);
                       if(success==true)
                       {
                           view.displaySuccessfulRaisePrice();
                       }
                       else
                       {
                           view.displayUnsuccessfulRaisePrice();
                       }
                   }
                   else if(choice3==1) //User wants to lower the price of an hour rent
                   {
                       int choice4 = view.displayLowerPriceOptions();
                       int value = view.askValueChangePrice(choice4+3);
                       boolean success = tryChangePrice(choice2,choice3,choice4,value);
                       if(success==true)
                       {
                           view.displaySuccessfulLowerPrice();
                       }
                       else
                       {
                          view.displayUnsuccessfulLowerPrice(); 
                       }
                   }
                   else if(choice3==2) //User wants to set the price of an hour rent to a new value
                   {
                       int value = view.askValueChangePrice(5);
                       boolean success = tryChangePrice(choice2,choice3,0,value);
                       if(success==true)
                       {
                           view.displaySuccessfulChangePrice();
                       }
                       else
                       {
                          view.displayUnsuccessfulChangePrice(); 
                       }
                   }
                }
            }
            else if(choice1 == 8) //User wants to exit the application
            {
                break;
            }
        }
        
    }
    
    /**Function trying to rent a car
     * 
     * @param carNo Number of the car in question
     * @return true - successfully rented a car / false - failed to rent the car
     */
    private boolean tryToRent(int carNo)
    {
       int actualCarNo = carNo-1; 
       try{
           cars.get(actualCarNo).tryRent();
       }
       catch(Exception e){
           return false;
       }
       return true;
    }
    
    /**Function trying to return rented car
     * 
     * @param carNo Number of the car in question
     * @return true - successfully returned the car / false - failed to return the car
     */
    private boolean tryToReturn(int carNo)
    {
        int actualCarNo = carNo-1; 
       try{
           cars.get(actualCarNo).tryReturn();
       }
       catch(Exception e){
           return false;
       }
       return true;
    }
    
    /**Function trying to add a given mileage to the car's history
     * 
     * @param carNo Number of the car
     * @param mileage Mileage that is to be added to the car's history
     * @return true - if adding ended successfuly / false - if adding didn't end successfuly
     */
    private boolean tryAddMileage(int carNo,Mileage mileage)
    {
        int actualCarNo = carNo-1;
        try{
            cars.get(actualCarNo).addMileage(mileage);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    
    /**Function that picks the right method to change the car's rent price 
     * and tries to change it
     * 
     * @param carNo Number of the car
     * @param choice3 Information if user wants to raise/lower/change the price
     * @param choice4 If user wants to raise/lower the price, it indicates whether
     * the change is to or by a given amount
     * @param value The value that is to be set the new price / added to the price 
     * /substracted from the price
     * @return true - if change was successful / false - if change was unsuccessful
     */
    private boolean tryChangePrice(int carNo,int choice3, int choice4, int value)
    {
        int actualCarNo = carNo-1;
        if(choice3==0)
        {
            if(choice4==0)
            {
                try{
                    cars.get(actualCarNo).raiseRentPrice(value);
                }
                catch(Exception e){
                    return false;
                }
                return true;
            }
            else
            {
                try{
                    cars.get(actualCarNo).raiseRentPriceByAnAmount(value);
                }
                catch(Exception e){
                    return false;
                }
                return true;
            }
        }
        else if(choice3==1)
        {
            if(choice4==0)
            {
                try{
                    cars.get(actualCarNo).lowerRentPrice(value);
                }
                catch(Exception e){
                    return false;
                }
                return true;
            }
            else
            {
                try{
                    cars.get(actualCarNo).lowerRentPriceByAnAmount(value);
                }
                catch(Exception e){
                    return false;
                }
                return true;
            }  
        }
        else
        {
            try{
                cars.get(actualCarNo).changeRentPrice(value);
            }
            catch(Exception e){
                return false;
            }
            return true;
        }
    }
}
