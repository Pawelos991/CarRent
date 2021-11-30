package pl.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**Entity representing a car
 *
 * @author Pawel
 * @version 1.5
 */
@Entity
@Table(name = "cars")
public class CarEntity implements Serializable {

    /**ID of a car*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**Make of the car*/
    @Column(name = "make")
    private String make;
    /**Model of the car*/
    @Column(name = "model")
    private String model;
    /**Year of production*/
    @Column(name = "rok")
    private int year;
    /**Information, if the car is rented*/
    @Column(name = "rented")
    private boolean rented;
    /**Price of every hour of the rent*/
    @Column(name = "hourPrice")
    private float hourPrice;
    /**List of mileages of the car*/
    @JoinColumn(name = "mileages")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "car")
    private List<MileageEntity> mileages;

    /**Function that sets the given list of mileages as the mileages of the car
     * 
     * @param mileages List of mileages to be set
     */
    public void setMileages(List<MileageEntity> mileages) {
        this.mileages = mileages;
    }

    /**Function that returns the list of mileages of the car
     * 
     * @return List of mileages of the car
     */
    public List<MileageEntity> getMileages() {
        return mileages;
    }

    /**Function that sets the given make as the make of the car
     * 
     * @param make Name of make to be set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**Function that sets the given model as the model of the car
     * 
     * @param model Name of model to be set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**Function that sets the given year as a year of production of the car
     * 
     * @param year Year to be set as the year of production
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**Function that sets the rented value to the given value of boolean
     * 
     * @param rented Given value (true/false)
     */
    public void setRented(boolean rented) {
        this.rented = rented;
    }

    /**Function that sets the price of one hour rent of the car to given value
     * 
     * @param hourPrice Value to set the price
     */
    public void setHourPrice(float hourPrice) {
        this.hourPrice = hourPrice;
    }

    /**Function that returns the make of the car
     * 
     * @return Make of the car
     */
    public String getMake() {
        return make;
    }

    /**Function that returns the model of the car
     * 
     * @return Model of the car
     */
    public String getModel() {
        return model;
    }

    /**Function that returns the year of production of the car
     * 
     * @return Year of production of the car
     */
    public int getYear() {
        return year;
    }

    /**Function that returns the info whether the car is rented or not
     * 
     * @return True - if car is rented / False - if it is not
     */
    public boolean isRented() {
        return rented;
    }

    /**Function that returns the price of hour rent of the car
     * 
     * @return Price of one hour rent of the car
     */
    public float getHourPrice() {
        return hourPrice;
    }

    /**Function that returns the ID of the car
     * 
     * @return ID of the car
     */
    public Long getId() {
        return id;
    }
    
}
