/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.patterns;

import java.util.ArrayList;
import java.util.List;
import pl.controllers.CarController;
import pl.models.Car;
import pl.models.Date;
import pl.models.Mileage;
import pl.views.CarView;

/**Manager class for the CarRentPattern
 *
 * @author Pawel Mika
 * @version 1.3
 */
public class CarRentPattern {
    
    /**Main function of the CarRent. Pass no parameters
     * 
     * @param args Arguments passed to function
     */
    public static void main(String args[]){
        List<Car> cars=initializeCars();
        CarView view = new CarView();
        
        CarController controller = new CarController(cars, view);
        
        controller.runTheRent();
    }
    
    /**Function to initialize the table of Cars
     * 
     * @return Initialized table of cars
     */
    private static List<Car> initializeCars()
    {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1,"Mazda", "RX8",2010, new Mileage(new Date(2010,10,12),0),false,10));
        cars.add(new Car(2,"Volkswagen", "Passat",1999, new Mileage(new Date(1999,5,12),0),false,10));
        cars.add(new Car(3,"BMW", "M3 GTR", 2005,new Mileage(new Date(2005,10,5),0),false,10));
        cars.add(new Car(4,"Seat", "Leon I", 2004, new Mileage(new Date(2004,1,12),0),false,10));
        cars.add(new Car(5,"Range Rover", "Sport",2018, new Mileage(new Date(2018,3,7),0),false,10));
        return cars;
    }
}
