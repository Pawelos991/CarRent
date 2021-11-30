package pl.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import pl.entities.DateEntity;
import pl.models.Date;

/**Class that represents a Date Controller
 *
 * @author Pawel
 * @version 1.5
 */
public class DateController {
    /**Entity Manager that the Date Controller uses*/
    EntityManager em;
    
    /**Public constructor of the DateController class
     * 
     * @param Em Entity Manager that the Date Controller will use
     */
    public DateController(EntityManager Em){
        em=Em;
    }
    
    
    /**Method that returnes the date
     * 
     * @param id the ID of the date
     * @return Date information (Year,Month,Day)
     */
    public List<Integer> getDate(long id){
        
        DateEntity date;
        date = em.find(DateEntity.class, id);
        
        List<Integer> dateS = new ArrayList();
        dateS.add(date.getYear());
        dateS.add(date.getMonth());
        dateS.add(date.getDay());
        return dateS;
    }
    
    /**Method that compares this date with the given another date
     * 
     * @param id the ID of the date
     * @param dateToCompare Date to compare this date with
     * @return true if this date is later, false if this date is earlier or the same
     */
    public boolean isLaterThan(Date dateToCompare, long id){
        DateEntity dateS;
        dateS = em.find(DateEntity.class, id);
        int year;
        int month;
        int day;
        year = dateS.getYear();
        month = dateS.getMonth();
        day = dateS.getDay();
        
        List<Integer> date = dateToCompare.getDate();
        if(year>date.get(0))
            return true;
        else if(year<date.get(0))
            return false;
        else
        {
            if(month>date.get(1))
                return true;
            else if(month<date.get(1))
                return false;
            else
            {
                if(day>date.get(2))
                    return true;
                else
                    return false;
            }
        }
    }
}
