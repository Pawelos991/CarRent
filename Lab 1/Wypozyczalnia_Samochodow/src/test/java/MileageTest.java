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
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.models.Date;
import pl.models.Mileage;
import pl.exceptions.MileageException;

/**Class of the Mileage methods tests
 *
 * @author Pawel
 */
public class MileageTest {
    /**Tested object*/
    private Car car;
    /**Date of the added mileage*/
    private Date date;
    /**First and only mileage date*/
    private Date first;
    /**New mileage added to the car history*/
    private Mileage mileage;
    
    /**Function that sets the test car for the mileage methods tests
     * 
     */
    @BeforeEach
    public void setUp() {
        first = new Date(2015,10,12);
        car = new Car(1,"TestCar","TestMileage",2015, new Mileage(first,0),false,15);
    }
    
    /**Function that tests the addMileage method
     * 
     * @param Year Year of the date of the mileage registration 
     * @param Month Month of the date of the mileage registration 
     * @param Day Day of the date of the mileage registration 
     * @param MileagE Value of the mileage
     */
    @ParameterizedTest
    @CsvSource({"1999,12,1,100",
                "2015,11,12,100",
                "2015,11,12,0",
                "2015,11,12,-10",
                "2020,12,20,150000",
                "2020,12,20,-100",
                "2020,12,20,0",
                "2020,12,20,-600"})
    public void testAddMileage(int Year, int Month, int Day, int MileagE)
    {
        if(MileagE==-600)
            mileage=null;
        else
        {
            date = new Date(Year,Month,Day);
            mileage = new Mileage(date,MileagE);
        }
        try{
            car.addMileage(mileage);
            if(mileage==null)
                fail("Should throw exception trying to add null value of mileage");
            else if(date.isLaterThan(first)==false)
                fail("Should throw exception trying to add earlier date than already is");
            else if(MileagE<0)
                fail("Should throw exception trying to add mileage of value less than zero");
            else
                assertEquals(mileage.getMileage(),car.getMileages().get(1).getMileage(),"Faile trying to add good mileage");
        }
        catch(MileageException e){
        }
    }
}
