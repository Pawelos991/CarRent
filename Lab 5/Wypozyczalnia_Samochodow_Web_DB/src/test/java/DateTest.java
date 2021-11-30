import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.models.Date;

/**Class of the Date methods tests
 *
 * @author Pawel
 * @version 1.5
 */
public class DateTest {
    /**First compated date*/
    private Date date1;
    /**Second compared date*/
    private Date date2;
    
    /** Fuction that tests the isLaterThan method
     * 
     * @param Year1 Year of the first date
     * @param Month1 Month of the first date
     * @param Day1 Day of the first date
     * @param Year2 Year of the second date
     * @param Month2 Month of the second date
     * @param Day2 Day of the second date
     * @param shouldBe Information whether the result should be true or false
     */
    @ParameterizedTest
    @CsvSource({"1999,12,1,1999,12,2,true",
           "1999,12,1,1999,12,1,false",
           "1999,12,1,2005,12,1,true",
           "1999,11,1,1999,12,1,true",
           "2005,12,1,1999,12,1,false",
           "1999,12,1,1999,11,1,false",
           "1999,12,2,1999,12,1,false"})
    public void testIsLaterThan(int Year1,int Month1, int Day1, int Year2,int Month2, int Day2, boolean shouldBe){
        date1 = new Date(Year1,Month1,Day1);
        date2 = new Date(Year2,Month2,Day2);
        boolean result = date2.isLaterThan(date1);
        assertEquals(result,shouldBe,"Trying to compare date "+String.valueOf(Year2)+
                "."+String.valueOf(Month2)+"."+String.valueOf(Day2)+" to "+String.valueOf(Year1)+
                "."+String.valueOf(Month1)+"."+String.valueOf(Day1)+" fails.");
    }
}
