/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.exceptions.MileageException;
import pl.models.Car;
import pl.models.Date;
import pl.models.Mileage;
import pl.wypozyczalnia_samochodow_web.resources.JavaEE8Resource;

/**Servlet handling returning cars
 *
 * @author Pawel
 * @version 1.4
 */
@WebServlet(name = "ReturnCar", urlPatterns = {"/ReturnCar"})
public class ReturnCar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        String makeAndModel = request.getParameter("Wybor_samochodu");
        String mileageS = request.getParameter("przebieg");
        int mileageValue;
        
        String message="";
        
        try{
                mileageValue = Integer.parseInt(mileageS.trim());
            }
       catch(NumberFormatException nfe)
            {
              mileageValue = -100;
              message = "Należy wpisać przebieg w poprawnym formacie (liczba)";
            }
        if(mileageValue!= -100)
        {
            List<Car> cars;  
            HttpSession session = request.getSession();
            if (session.getAttribute("cars") == null) {
                JavaEE8Resource s = new JavaEE8Resource();
                cars = s.initializeCars();
                session.setAttribute("cars", cars);
            } 
            else 
            {
                cars = (List<Car>) session.getAttribute("cars");
            }
            for(int i=0 ;i<cars.size();i++)
            {
                if((cars.get(i).getMake()+" "+cars.get(i).getModel()).equals(makeAndModel))
                {
                   message = "Udało Ci się zwrócić samochód!";
                   try{ 
                       cars.get(i).tryReturn();
                   }
                   catch(Exception e){
                       message = "Ups! Ten samochód nie jest wypożyczony, więc nie można go zwrócić";
                       break;
                   }
                   try{
                       Mileage mileage = new Mileage(new Date(),mileageValue);
                       cars.get(i).addMileage(mileage);
                   }
                   catch(MileageException e){
                       message = "Należy podać poprawny przebieg. Podany przebieg nie jest prawdziwy";
                       cars.get(i).setRented();
                       break;
                   }
                   break;
                }
            }
        }
        
        
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Zwrócenie samochodu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>"+message+"</h2>");
            out.println("<br><br><button onclick=\"location.href = 'Return.html';\" >Wróć do poprzedniej strony</button><br><br>");
            out.println("<button onclick=\"location.href = 'index.html';\" >Wróć do strony głównej</button>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
