package pl.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**Entity representing a mileage
 *
 * @author Pawel
 * @version 1.5
 * 
 */
@Entity
@Table(name = "mileages")
public class MileageEntity implements Serializable {
    
    /**ID of the mileage*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**The value of the mileage*/
    @Column(name = "mileage")
    private int mileage;
    /**The date when the mileage was recorded*/
    @OneToOne(mappedBy = "mileage")
    @JoinColumn(name = "date")
    private DateEntity date;
    /**The car that the mileage belongs to*/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car", referencedColumnName = "id")
    private CarEntity car;

    /**Function that sets the date of the mileage to given date
     * 
     * @param date Date that is to be set
     */
    public void setDate(DateEntity date) {
        this.date = date;
    }

    /**Function that returns the date when the mileage was recorded
     * 
     * @return Date when the mileage was recorded
     */
    public DateEntity getDate() {
        return date;
    }
    
    /**Function that sets the car that the mileage belongs to
     * 
     * @param car The car the mileage belongs to
     */
    public void setCar(CarEntity car) {
        this.car = car;
    }

    /**Function that returns the car that the mileage belongs to
     * 
     * @return Car that the mileage belongs to
     */
    public CarEntity getCar() {
        return car;
    }

    /**Function that sets the value of the mileage
     * 
     * @param mileage The value of the mileage
     */
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    /**Function that returns the value of the mileage
     * 
     * @return The value of the mileage
     */
    public int getMileage() {
        return mileage;
    }

    /**Function that returns the ID of the mileage
     * 
     * @return ID of the mileage
     */
    public Long getId() {
        return id;
    }
}
