package pl.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**Entity representing a date
 *
 * @author Pawel
 * @version 1.5
 */
@Entity
@Table(name = "dates")
public class DateEntity implements Serializable {

    /**ID of the date*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**Year*/
    @Column(name = "rok") //That's year but
    private int rok;      //for some reason JPA doesn't accept name "year"
    /**Month*/
    @Column(name = "month")
    private int month;
    /**Day*/
    @Column(name = "day")
    private int day;
    /**The mileage that the DateEntity belongs to*/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mileage", referencedColumnName = "id")
    private MileageEntity mileage;

    /**Function that sets the given mileage as the mileage that the date belongs to
     * 
     * @param mileage Mileage that the date belongs to
     */
    public void setMileage(MileageEntity mileage) {
        this.mileage = mileage;
    }

    /**Function that returns the mileage that the date belongs to
     * 
     * @return Mileage that the date belongs to
     */
    public MileageEntity getMileage() {
        return mileage;
    }

    /**Function that returns the year of the date
     * 
     * @return The year of the date
     */
    public int getYear() {
        return rok;
    }

    /**Function that returns the month of the date
     * 
     * @return The month of the date
     */
    public int getMonth() {
        return month;
    }

    /**Function that returns the day of the date
     * 
     * @return The day of the date
     */
    public int getDay() {
        return day;
    }

    /**Function that sets the year of the date to given value
     * 
     * @param year Value that the year is set to
     */
    public void setYear(int year) {
        this.rok = year;
    }

    /**Function that sets the month of the date to given value
     * 
     * @param month Value that the month is set to
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**Function that sets the day of the date to given value
     * 
     * @param day Value that the day is set to
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**Function that returns the ID of the date
     * 
     * @return ID of the date
     */
    public Long getId() {
        return id;
    }
    
}
