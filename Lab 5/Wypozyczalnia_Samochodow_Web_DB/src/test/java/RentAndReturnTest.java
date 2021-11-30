import pl.models.Car;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.models.Date;
import pl.models.Mileage;

/**Class for the rent and return methods tests
 *
 * @author Pawel
 * @version 1.5
 */
public class RentAndReturnTest {
    /**Tested object*/
    private Car car;
    
    /**Function that tests the tryRent method
     * 
     * @param rented Boolean informing whether the car is rented 
     * or not
     */
    @ParameterizedTest
    @ValueSource(booleans = {true,false})  
    void testTryRent(boolean rented) {
        car = new Car(1,"TestCar","TestMileage",2015, new Mileage(new Date(2015,10,12),0),rented,15);
        try{
            car.tryRent();
            if(rented==true)
            {
                fail("Should throw exception trying to rent rented car");
            }
            else
            {
                assertTrue(car.isRented());
            }
        }
        catch(Exception e){
            if(rented==false)
                fail("Trying to rent not rented car fails");
        }
    }
    
    /**Function that tests the tryReturn method
     * 
     * @param rented Boolean informing whether the car is rented 
     * or not
     */
    @ParameterizedTest
    @ValueSource(booleans = {true,false})  
    void testTryReturn(boolean rented) {
        car = new Car(1,"TestCar","TestMileage",2015, new Mileage(new Date(2015,10,12),0),rented,15);
        try{
            car.tryReturn();
            if(rented==false)
            {
                fail("Should throw exception trying to return returned car");
            }
            else
            {
                assertTrue(!car.isRented());
            }
        }
        catch(Exception e){
            if(rented==true)
                fail("Trying to return rented car fails");
        }
    }
    
}
