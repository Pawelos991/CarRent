package pl.wypozyczalnia_samochodow_web.resources;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import pl.models.Car;
import pl.models.Date;
import pl.models.Mileage;

/**
 *
 * @author Pawel 
 * @version 1.4
 */
@Path("javaee8")
public class JavaEE8Resource {
 
    public List<Car> initializeCars()
    {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1,"Mazda", "RX8",2010, new Mileage(new Date(2010,10,12),0),false,10));
        cars.add(new Car(2,"Volkswagen", "Passat",1999, new Mileage(new Date(1999,5,12),0),false,10));
        cars.add(new Car(3,"BMW", "M3 GTR", 2005,new Mileage(new Date(2005,10,5),0),false,10));
        cars.add(new Car(4,"Seat", "Leon I", 2004, new Mileage(new Date(2004,1,12),0),false,10));
        cars.add(new Car(5,"Range Rover", "Sport",2018, new Mileage(new Date(2018,3,7),0),false,10));
        return cars;
    }
    
    @GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
}
