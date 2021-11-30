/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.models;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;

/**Class that represents date
 *
 * @author Pawel
 * @version 1.4
 */
public class Date {
    /**Year*/
    private int year;
    /**Month*/
    private int month;
    /**Day*/
    private int day;
    
    public Date(){
        LocalDate date = LocalDate.now();
        year = date.getYear();
        month = date.getMonthValue();
        day = date.getDayOfMonth();
    }
    
    /**Constructor of the Date class
     * 
     * @param Year Year
     * @param Month Month
     * @param Day Day
     */
    public Date(int Year, int Month, int Day){
        year=Year;
        month=Month;
        day=Day;
    }
    
    /**Method that returnes the date
     * 
     * @return Date information (Year,Month,Day)
     */
    public List<Integer> getDate(){
        List<Integer> date = new ArrayList();
        date.add(year);
        date.add(month);
        date.add(day);
        return date;
    }
    
    /**Method that compares this date with the given another date
     * 
     * @param dateToCompare Date to compare this date with
     * @return true if this date is later, false if this date is earlier or the same
     */
    public boolean isLaterThan(Date dateToCompare){
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

