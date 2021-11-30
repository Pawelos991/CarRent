package pl.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import pl.entities.CarEntity;
import pl.entities.DateEntity;
import pl.entities.MileageEntity;
import pl.exceptions.MileageException;
import pl.models.Date;
import pl.models.Mileage;

/** Class that represents a Car Controller
 *
 * @author Pawel
 * @version 1.5
 */
public class CarController {
    /**Entity Manager that the car controller uses*/
    EntityManager em;
    
    /**Public contructor of the CarController class
     * 
     * @param Em the Entity Manager that the car controller will use
     */
    public CarController(EntityManager Em){
        em=Em;
    }
    
    /**Function that fills the database with intial data
     * 
     */
    public void InitDB(){
        
        CarEntity car1 = new CarEntity();
        car1.setMake("Mazda");
        car1.setModel("RX8");
        car1.setYear(2010);
        car1.setRented(false);
        car1.setHourPrice(10);
        MileageEntity mileage1= new MileageEntity();
        mileage1.setMileage(0);
        mileage1.setCar(car1);
        List<MileageEntity> mileages = new ArrayList<>();
        mileages.add(mileage1);
        car1.setMileages(mileages);
        DateEntity date1 = new DateEntity();     
        date1.setDay(12);
        date1.setMonth(10);
        date1.setYear(2010);
        date1.setMileage(mileage1);
        mileage1.setDate(date1);
        
        em.getTransaction().begin();
        try {
        em.persist(car1);
        em.persist(mileage1);
        em.persist(date1);}
        catch(Exception e){
            em.getTransaction().rollback();
        }
        em.getTransaction().commit();
        
        
        CarEntity car2 = new CarEntity();
        car2.setMake("Volkswagen");
        car2.setModel("Passat");
        car2.setYear(1999);
        car2.setRented(false);
        car2.setHourPrice(10);
        MileageEntity mileage2= new MileageEntity();
        mileage2.setMileage(0);
        mileage2.setCar(car2);
        List<MileageEntity> mileages2 = new ArrayList<>();
        mileages.add(mileage2);
        car2.setMileages(mileages2);
        DateEntity date2 = new DateEntity();     
        date2.setYear(1999);
        date2.setMonth(5);
        date2.setDay(12);
        date2.setMileage(mileage2);
        mileage2.setDate(date2);
        em.getTransaction().begin();
        try {
        em.persist(car2);
        em.persist(mileage2);
        em.persist(date2);}
        catch(Exception e){
            em.getTransaction().rollback();
        }
        em.getTransaction().commit();
        
        CarEntity car3 = new CarEntity();
        car3.setMake("BMW");
        car3.setModel("M3 GTR");
        car3.setYear(2005);
        car3.setRented(false);
        car3.setHourPrice(10);
        MileageEntity mileage3= new MileageEntity();
        mileage3.setMileage(0);
        mileage3.setCar(car3);
        List<MileageEntity> mileages3 = new ArrayList<>();
        mileages.add(mileage3);
        car3.setMileages(mileages3);
        DateEntity date3 = new DateEntity();
        date3.setYear(2010);
        date3.setMonth(10);
        date3.setDay(5);
        date3.setMileage(mileage3);
        mileage3.setDate(date3);
        em.getTransaction().begin();
        try {
        em.persist(car3);
        em.persist(mileage3);
        em.persist(date3);}
        catch(Exception e){
            em.getTransaction().rollback();
        }
        em.getTransaction().commit();
        
        CarEntity car4 = new CarEntity();
        car4.setMake("Seat");
        car4.setModel("Leon I");
        car4.setYear(2004);
        car4.setRented(false);
        car4.setHourPrice(10);
        MileageEntity mileage4= new MileageEntity();
        mileage4.setMileage(0);
        mileage4.setCar(car4);
        List<MileageEntity> mileages4 = new ArrayList<>();
        mileages.add(mileage4);
        car4.setMileages(mileages4);
        DateEntity date4 = new DateEntity();
        date4.setYear(2004);
        date4.setMonth(1);
        date4.setDay(12);
        date4.setMileage(mileage4);
        mileage4.setDate(date4);
        em.getTransaction().begin();
        try {
        em.persist(car4);
        em.persist(mileage4);
        em.persist(date4);}
        catch(Exception e){
            em.getTransaction().rollback();
        }
        em.getTransaction().commit();
        
        CarEntity car5 = new CarEntity();
        car5.setMake("Range Rover");
        car5.setModel("Sport");
        car5.setYear(2004);
        car5.setRented(false);
        car5.setHourPrice(10);
        MileageEntity mileage5= new MileageEntity();
        mileage5.setMileage(0);
        mileage5.setCar(car5);
        List<MileageEntity> mileages5 = new ArrayList<>();
        mileages.add(mileage5);
        car5.setMileages(mileages5);
        DateEntity date5 = new DateEntity();
        date5.setYear(2018);
        date5.setMonth(3);
        date5.setDay(7);
        date5.setMileage(mileage5);
        mileage5.setDate(date5);
        em.getTransaction().begin();
        try {
        em.persist(car5);
        em.persist(mileage5);
        em.persist(date5);}
        catch(Exception e){
            em.getTransaction().rollback();
        }
        em.getTransaction().commit();
    }
    
    
     /** Function to read the make of the car
     * 
     * @param id ID of the car
     * @return Make of the car
     */
    public String getMake(long id){
        CarEntity car;
        car = em.find(CarEntity.class, id);
        return car.getMake();
    }
    
    /**Function to read the model of the car
     * 
     * @param id ID of the car
     * @return Model of the car
     */
    public String getModel(long id){
        CarEntity car;
        car = em.find(CarEntity.class, id);
        return car.getModel();
    }
    
    /**Function to read the year of production of the car
     * 
     * @param id ID of the car
     * @return Year of production
     */
    public int getYear(long id){
        CarEntity car;
        car = em.find(CarEntity.class, id);
        return car.getYear();
    }
    
    /**Function that checks whether the car is rented
     * 
     * @param id ID of the car
     * @return true - the car is rented / false - the car is not rented
     */
    public boolean isRented(long id){
        CarEntity car;
        car = em.find(CarEntity.class, id);
        return car.isRented();
    }
    
    /**Function that sets the rented value true
     * @param id ID of the car
     * 
     */
    public void setRented(long id){
        CarEntity car;
        car = em.find(CarEntity.class, id);
        car.setRented(true);
        em.getTransaction().begin();
        try{
        em.merge(car);
        em.getTransaction().commit();
        }
        catch(Exception e){
            em.getTransaction().rollback();
        }
    }
    
    /**Function that sets the rented value false
     * 
     * @param id ID of the car
     */
    public void setReturned(long id){
        CarEntity car;
        car = em.find(CarEntity.class, id);
        car.setRented(false);
        em.getTransaction().begin();
        try{
        em.merge(car);
        em.getTransaction().commit();
        }
        catch(Exception e){
            em.getTransaction().rollback();
        }
    }
    
    /**Function that returns the price of one hour rent
     * 
     * @param id ID of the car
     * @return Price of one hour rent
     */
    public float getPrice(long id){
        CarEntity car;
        car = em.find(CarEntity.class, id);
        return car.getHourPrice();
    }
    
    /**Function that returns the list of the mileage records of the car
     * 
     * @param id ID of the car
     * @return List of the mileage records of the car
     */
    public List<Mileage> getMileages(long id){
        List<Mileage> mileages;
        mileages = new ArrayList<>();
        CarEntity car;
        car = em.find(CarEntity.class, id);
        for(int i=0; i<car.getMileages().size();i++)
        {
            MileageEntity mileage = car.getMileages().get(car.getMileages().size()-1);
            DateEntity date = mileage.getDate();
            Date newDate = new Date(date.getYear(),date.getMonth(),date.getDay());
            Mileage newMileage = new Mileage(newDate, mileage.getMileage());
            mileages.add(newMileage);
        }
        return mileages;
    }
    
    /**Function that adds a new mileage to the record of the car
     * 
     * @param add Added mileage
     * @param id ID of the car
     * @throws MileageException 
     */
    public void addMileage(Mileage add, long id)throws MileageException{
        if(add!=null)
            {
                List<Mileage> mileages;
                mileages = this.getMileages(id);
                Mileage latest = mileages.get(mileages.size()-1);
                if(latest.getDate().isLaterThan(add.getDate()))
                    throw new MileageException("Dodawany przebieg powinien mieć późniejsza datę niż ostatni w liście");
                else if(add.getMileage()<latest.getMileage())
                    throw new MileageException("Dodawany przebieg powinien mieć większą wartość przebiegu niż ostatni w liście");
                 else if(add.getMileage()<0)
                     throw new MileageException("Dodawany przebieg powinien mieć wartość przebiegu większą niż zero");
                 else
                 {
                    CarEntity car;
                    car = em.find(CarEntity.class, id);
                    DateEntity date = new DateEntity();
                    date.setYear(add.getDate().getDate().get(0));
                    date.setMonth(add.getDate().getDate().get(1));
                    date.setDay(add.getDate().getDate().get(2));
                    MileageEntity mileage = new MileageEntity();
                    mileage.setCar(car);
                    mileage.setDate(date);
                    mileage.setMileage(add.getMileage());
                    date.setMileage(mileage);
                    List<MileageEntity> mileagesS = car.getMileages();
                    mileagesS.add(mileage);
                    car.setMileages(mileagesS);
                    em.getTransaction().begin();
                    try{
                    em.persist(mileage);
                    em.persist(date);
                    em.merge(car);
                    em.getTransaction().commit();
                    }
                    catch(Exception e){
                        em.getTransaction().rollback();
                    }
                 }
            }
            else
                throw new MileageException("Dodawany przebieg nie może być nullem");
    }
    
    /**Function that tries to set the rented value to true if possible
     * 
     * @param id ID of the car
     * @throws Exception is the car is already rented
     */
    public void tryRent(long id) throws Exception{
        CarEntity car;
        car = em.find(CarEntity.class, id);
        if(car.isRented()==true)
            throw new Exception("Samochód jest już wypożyczony");
        else
            this.setRented(id);
    }
    
    /**Function that tries to set the rented value to false if possible
     * 
     * @param id ID of the car
     * @throws Exception is the car is already returned
     */
    public void tryReturn(long id) throws Exception{
        CarEntity car;
        car = em.find(CarEntity.class, id);
        if(car.isRented()==false)
            throw new Exception("Samochód jest już zwrócony");
        else
            this.setReturned(id);
    }
    
    /**Function that sets the new price of an hour rent
     * 
     * @param id ID of the car
     * @param newPrice New price of an hour rent
     * @throws Exception if the new price is non-postivie
     */
    public void changeRentPrice(float newPrice,long id) throws Exception{
        CarEntity car;
        car = em.find(CarEntity.class, id);
        if(newPrice<=0)
            throw new Exception("Nowa cena nie może być mniejsza lub równa zero");
        else
        {
            car.setHourPrice(newPrice);
            em.getTransaction().begin();
            try{
            em.merge(car);
            em.getTransaction().commit();
            }
            catch(Exception e){
                em.getTransaction().rollback();
            }
        }
    }
    
    /**Function that raises the price of an hour rent to the new value
     * 
     * @param id ID of the car
     * @param newPrice New price of and hour rent
     * @throws Exception if the new price is non-positive or if the new price 
     * is not greater than the previous one
     */
    public void raiseRentPrice(float newPrice,long id) throws Exception{
        CarEntity car;
        car = em.find(CarEntity.class, id);
        if(newPrice<=0)
            throw new Exception("Nowa cena nie może być mniejsza lub równa zero");
        else if(newPrice<=car.getHourPrice())
            throw new Exception("Nowa cena nie może być mniejsza lub równa niż poprzednia cena");
        else
        {
            car.setHourPrice(newPrice);
            em.getTransaction().begin();
            try{
            em.merge(car);
            em.getTransaction().commit();
            }
            
            catch(Exception e){
                em.getTransaction().rollback();
            }
        }
    }
    
    /**Function that raises the price of an hour rent by the given amount
     * 
     * @param id ID of the car
     * @param amount How much should be added to the price
     * @throws Exception if the new price is non-positive or if the new price 
     * is not greater than the previous one 
     */
    public void raiseRentPriceByAnAmount(float amount,long id) throws Exception{
        CarEntity car;
        car = em.find(CarEntity.class, id);
        if(amount<=0)
            throw new Exception("Nowa cena nie może być mniejsza lub równa niż poprzednia cena");
        else
        {
            float price = car.getHourPrice();
            price+=amount;
            car.setHourPrice(price);
            em.getTransaction().begin();
            try{
            em.merge(car);
            em.getTransaction().commit();
            }
            catch(Exception e){
                em.getTransaction().rollback();
            }
        }
    }
    
    /**Function that lowers the price of an hour rent to the new value
     * 
     * @param id ID of the car
     * @param newPrice New price of an hour rent
     * @throws Exception if the new price is non-positive or if the new price
     * is not lesser than the previous one
     */
    public void lowerRentPrice(float newPrice,long id) throws Exception{
        CarEntity car;
        car = em.find(CarEntity.class, id);
        if(newPrice<=0)
            throw new Exception("Nowa cena nie może być mniejsza lub równa zero");
        else if(newPrice>=car.getHourPrice())
            throw new Exception("Nowa cena nie może być większa lub równa niż poprzednia cena");
        else
        {
            car.setHourPrice(newPrice);
            em.getTransaction().begin();
            try{
            em.merge(car);
            em.getTransaction().commit();
            }
            catch(Exception e){
                em.getTransaction().rollback();
            }
        }
    }
    
    /**Function that lowers the price of an hour rent by the given amount
     * 
     * @param id ID of the car
     * @param amount How much should be substracted from the previous price
     * @throws Exception if the new price is non-positive or if the new price
     * is not lesser than the previous one
     */
    public void lowerRentPriceByAnAmount(float amount,long id) throws Exception{
        CarEntity car;
        car = em.find(CarEntity.class, id);
        if(amount<=0)
            throw new Exception("Nowa cena nie może być większa lub równa niż poprzednia cena");
        else if(car.getHourPrice()-amount<=0)
            throw new Exception("Nowa cena nie może być mniejsza lub równa zero");
        else
        {
            float price = car.getHourPrice();
            price-=amount;
            car.setHourPrice(price);
            em.getTransaction().begin();
            try
            {
            em.merge(car);
            em.getTransaction().commit();
            }
            catch(Exception e){
                em.getTransaction().rollback();
            }
        }
    }
}
