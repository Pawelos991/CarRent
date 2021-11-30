/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.views;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import pl.models.Car;
import pl.models.Mileage;

/** View class for the CarRent
 *
 * @author Pawel Mika
 * @version 1.3
 */
public class CarView {
    
    /**Function managing the first screen
     * 
     * @return Name of the user 
     */
    public static String displayHello()
    {
        String name = JOptionPane.showInputDialog(null,"Podaj swoje imię","Start",JOptionPane.QUESTION_MESSAGE);
        return name;
    }
    
    /**Function that displays the choice that the user has to make
     * Possible options are: rent a car(0), return a car(1), more options(2), display cars list(3), less options(4), more options(5), 
     * change rent price(6), less options(7), exit(8) 
     * @param name Name of the user
     * @return Number of the chosen option(0/1/3/6)
     */
    public static int displayOptions(String name)
    {
        int choice=7;
        while(choice==7)
        {
            Object[] options1 = {"Wypożyczyć auto", "Oddać auto", "Więcej"};
            Object[] options2 = {"Wyświetlić listę aut", "Wróć","Więcej"};
            Object[] options3 = {"Zmienić cenę wypożyczenia auta", "Wróć","Wyjdź"};
            choice = JOptionPane.showOptionDialog(null, "Witaj "+name+"! Co chcesz zrobic?","Wypożyczalnia",JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE,null,options1,options1[2]);
            if(choice==2)
            {
                choice = JOptionPane.showOptionDialog(null, "Witaj "+name+"! Co chcesz zrobic?","Wypożyczalnia",JOptionPane.YES_NO_CANCEL_OPTION, 
                    JOptionPane.QUESTION_MESSAGE,null,options2,options2[2]); 
                choice+=3;
            }
            if(choice==5)
            {
               choice = JOptionPane.showOptionDialog(null, "Witaj "+name+"! Co chcesz zrobic?","Wypożyczalnia",JOptionPane.YES_NO_CANCEL_OPTION, 
                    JOptionPane.QUESTION_MESSAGE,null,options3,options3[2]); 
                choice+=6; 
            }
        }
        
        return choice;
    }
    
    /**Function that displays the choice that the user has to make about changing the price of a car's rent
     * Possible options are: raise the price(0), lower the price(1), set the price(2)
     * 
     * @return Number of the chosen option(0/1/2)
     */
    public static int displayChangePriceOptions()
    {
        int choice;
        Object[] options = {"Zwiększyć cenę", "Zmniejszyć cenę", "Ustawić nową cenę"};
        choice = JOptionPane.showOptionDialog(null, "Co chcesz zrobic?","Wypożyczalnia",JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
        return choice;
    }
    
    /**Function that displays the choice that the user has to make about raising the price of a car's rent
     * Possible options are: raise the price to a certain value(0), raise the price by a certain value(1)
     * 
     * @return Number of the chosen option(0/1)
     */
    public static int displayRaisePriceOptions()
    {
        int choice;
        Object[] options = {"Do konkretnej wartości", "O konkretną wartość"};
        choice = JOptionPane.showOptionDialog(null, "Jak chcesz zwiększyć cenę?","Wypożyczalnia",JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
        return choice;
    }
    
    /**Function that displays the choice that the user has to make about lowering the price of a car's rent
     * Possible options are: lower the price to a certain value(0), lower the price by a certain value(1)
     * 
     * @return Number of the chosen option(0/1)
     */
    public static int displayLowerPriceOptions()
    {
        int choice;
        Object[] options = {"Do konkretnej wartości", "O konkretnę wartość"};
        choice = JOptionPane.showOptionDialog(null, "Jak chcesz zmniejszyć cenę?","Wypożyczalnia",JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
        return choice;
    }
    
    /**Function that asks user to give the value used in changing the car's rent price
     * 
     * @param version Indicates, what user wants to do
     * @return Value used in changing the car's rent price - if ended successfuly / -100 - if ended unsuccessfuly
     */
    public static int askValueChangePrice(int version){
        int value=-100;
        String message="Brak info";
        if(version == 1)
            message="Podaj kwotę, do której chcesz podnieść cenę";
        else if(version == 2)
            message="Podaj kwotę, o którą chcesz podnieść cenę";
        else if(version == 3)
            message="Podaj kwotę, do której chcesz obniżyć cenę";
        else if(version == 4)
            message="Podaj kwotę, o którą chcesz obniżyć cenę";
        else if(version == 5)
            message="Podaj nową cenę";
        while (value == -100)
        {
            String valueS = JOptionPane.showInputDialog(null,message,"Zmiana ceny",JOptionPane.OK_OPTION);
            if(valueS == null)
                return -100;
            try{
                value = Integer.parseInt(valueS.trim());
            }
            catch(NumberFormatException nfe)
            {
              JOptionPane.showMessageDialog(null, "Oj!\nPodaj prawidłową wartośc liczbową.","Błąd",JOptionPane.WARNING_MESSAGE);
              value = -100;  
            }
        }
        return value;
    }
    
    
    /**Function to display cars and receive the choice of the user
     * 
     * @param cars Cars table
     * @return Number of the chosen car
     */
    public static int displayCars(List<Car> cars)
    {
        String message = "Wybierz samochod:\n";
        Object[] options={"1","2","3","4","5"};
        //cars.stream().forEach(car->{System.out.println("\n"+car.getID()+"."+car.getMake()+"          "+car.getModel()+"          Rocznik:"+car.getYear());});
        
        for(int i=0; i<cars.size(); i++)
        {
            options[i]=cars.get(i).getMake()+" "+cars.get(i).getModel();
        }
        String choiceS = (String)JOptionPane.showInputDialog(null, message,"Wypożyczalnia",JOptionPane.PLAIN_MESSAGE, 
               null,options, "Wybierz numer auta");
        int choice=-1;
        for(int i=0; i<5; i++)
        {
            if(choiceS==options[i])
                choice=i+1;
        }
        return choice;
    }
    
    /**Function that shows a message about successful rent of a car
     * 
     */
    public static void displaySuccessfulRent()
    {
        JOptionPane.showMessageDialog(null, "Udało Ci się wypożyczyć wymarzone auto!","Sukces",JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**Function that shows a message about unsuccessful rent of a car
     * 
     */
    public static void displaySuccessfulReturn()
    {
        JOptionPane.showMessageDialog(null, "Udało Ci się zwrócić wypożyczone auto!\nZapraszamy ponownie!","Sukces",JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**Function that shows a message about successful return of a car
     * 
     */
    public static void displayUnsuccessfulRent()
    {
        JOptionPane.showMessageDialog(null, "Oj!\nNie udało się wypożyczyć auta. Auto jest już wypożyczone.","Błąd",JOptionPane.WARNING_MESSAGE);
    }
    
    /**Function that shows a message about unsuccessful return of a car
     * 
     */
    public static void displayUnsuccessfulReturn()
    {
        JOptionPane.showMessageDialog(null, "Oj!\nNie udało się zwrócić auta. Auto nie jest wypożyczone.","Błąd",JOptionPane.WARNING_MESSAGE);
    }
    
    /**Function that shows a message about unsuccessful attempt of adding mileage to the car's history 
     * 
     */
    public static void displayUnsuccessfulAddMileage()
    {
        JOptionPane.showMessageDialog(null, "Oj!\nPodany przebieg nie jest prawdziwy. Prawdziwy jest wiekszy. Podaj prawdziwy przebieg","Błąd",JOptionPane.WARNING_MESSAGE);
    }
    
    /**Function that shows a message about the necessity of the input of the mileage value
     * 
     */
    public static void displayNeedMileage()
    {
        JOptionPane.showMessageDialog(null, "Oj!\nTeraz już musisz podać przebieg","Próba ucieczki",JOptionPane.WARNING_MESSAGE);
    }
    
    /**Function that ask user to give the mileage value, that is used in adding mileage method
     * 
     * @return Value of the mileage - if ended successfuly / -100 - if ended unsuccessfuly
     */
    public static int askMileage()
    {
        int mileage = -100;
        while (mileage == -100)
        {
            String mileageS = JOptionPane.showInputDialog(null,"Podaj obecny przebieg oddawanego auta","Oddanie auta",JOptionPane.OK_OPTION);
            if(mileageS == null)
                return -100;
            try{
                mileage = Integer.parseInt(mileageS.trim());
            }
            catch(NumberFormatException nfe)
            {
              JOptionPane.showMessageDialog(null, "Oj!\nPodaj prawidłową wartość przebiegu.","Błąd",JOptionPane.WARNING_MESSAGE);
              mileage = -100;  
            }
        }
        return mileage;
    }
    
    /**Function that shows a message about successful change of a car's rent price
     * 
     */
    public static void displaySuccessfulChangePrice()
    {
        JOptionPane.showMessageDialog(null, "Pomyślnie zmieniono cenę!","Sukces",JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**Function that shows a message about unsuccessful change of a car's rent price
     * 
     */
    public static void displayUnsuccessfulChangePrice()
    {
        JOptionPane.showMessageDialog(null, "Nie udało się zmienić ceny. Podana wartość była niepoprawna!","Sukces",JOptionPane.WARNING_MESSAGE);
    }
    
    /**Function that shows a message about successful raise of a car's rent price
     * 
     */
    public static void displaySuccessfulRaisePrice()
    {
        JOptionPane.showMessageDialog(null, "Pomyślnie zwiększono cenę!","Sukces",JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**Function that shows a message about unsuccessful raise of a car's rent price
     * 
     */
    public static void displayUnsuccessfulRaisePrice()
    {
        JOptionPane.showMessageDialog(null, "Nie udało się zwiększyć ceny. Podana wartość była niepoprawna","Błąd",JOptionPane.WARNING_MESSAGE);
    }
    
    /**Function that shows a message about successful lowering of a car's rent price
     * 
     */
    public static void displaySuccessfulLowerPrice()
    {
        JOptionPane.showMessageDialog(null, "Pomyślnie zmniejszono cenę!","Sukces",JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**Function that shows a message about unsuccessful lowering of a car's rent price
     * 
     */
    public static void displayUnsuccessfulLowerPrice()
    {
        JOptionPane.showMessageDialog(null, "Nie udało się zmniejszyć ceny. Podana wartość była niepoprawna","Błąd",JOptionPane.WARNING_MESSAGE);
    }
    
    /**Function that displays the table of cars in a new window
     * 
     * @param cars List of the cars to display
     */
    public static void displayCarsTable(List<Car> cars)
    {
        
        String[] columnNames = {"ID","Make","Model","Year","Mileage","Price"};
        Object[][] data = new Object[cars.size()+1][6];
        
        data[0][0]="Numer";
        data[0][1]="Marka";
        data[0][2]="Model";
        data[0][3]="Rocznik";
        data[0][4]="Przebieg";
        data[0][5]="Cena wypożyczenia za 1h";
        
        for(int i=0; i<cars.size();i++)
        {
            data[i+1][0]=cars.get(i).getID();
            data[i+1][1]=cars.get(i).getMake();
            data[i+1][2]=cars.get(i).getModel();
            data[i+1][3]=cars.get(i).getYear();
            List<Mileage> mileages = cars.get(i).getMileages();
            data[i+1][4]=mileages.get(mileages.size()-1).getMileage()+"km";
            data[i+1][5]=cars.get(i).getPrice()+"zł";
        }
        
        JFrame frame = new JFrame("Lista Samochodów");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900,140));

        JTable CarList = new JTable(data,columnNames);
        CarList.setEnabled(false);
        
        CarList.setOpaque(true); 
        frame.setContentPane(CarList);

        frame.pack();
        frame.setVisible(true);
    }
}
