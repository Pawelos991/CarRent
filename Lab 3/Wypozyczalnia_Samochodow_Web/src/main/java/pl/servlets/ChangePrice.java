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
import pl.models.Car;
import pl.wypozyczalnia_samochodow_web.resources.JavaEE8Resource;

/**Servlet handling changing price of car rent
 *
 * @author Pawel
 * @version 1.4
 */
@WebServlet(name = "ChangePrice", urlPatterns = {"/ChangePrice"})
public class ChangePrice extends HttpServlet {

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
        String choiceS = request.getParameter("data");
        String valueS = request.getParameter("wartosc");
        float value;
        String message="";
        
        try{
                value = Float.parseFloat(valueS.trim());
            }
       catch(NumberFormatException nfe)
            {
              value = -100;
              message = "Wpisana wartość musi być w poprawnym formacie";
            }
        if(value!= -100)
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
            OUTER:
            for (int i = 0; i<cars.size(); i++) {
                if ((cars.get(i).getMake()+" "+cars.get(i).getModel()).equals(makeAndModel)) {
                    switch (choiceS) {
                        case "setNew":
                            try {
                                cars.get(i).changeRentPrice(value);
                            } catch (Exception e) {
                                message=e.getMessage();
                                break OUTER;
                            }
                            message = "Udało się zmienić cenę do podanej wartości";
                            break;
                        case "raise":
                            try {
                                cars.get(i).raiseRentPrice(value);
                            } catch (Exception e) {
                                message=e.getMessage();
                                break OUTER;
                            }
                            message = "Udało się zwiększyć cenę do podanej wartości";
                            break;
                        case "raiseByAmount":
                            try {
                                cars.get(i).raiseRentPriceByAnAmount(value);
                            } catch (Exception e) {
                                message=e.getMessage();
                                break OUTER;
                            }
                            message = "Udało się zwiększyć cenę o podaną wartość";
                            break;
                        case "lower":
                            try {
                                cars.get(i).lowerRentPrice(value);
                            } catch (Exception e) {
                                message=e.getMessage();
                                break OUTER;
                            }
                            message = "Udało się zmniejszyć cenę do podanej wartości";
                            break;
                        case "lowerByAmount":
                            try {
                                cars.get(i).lowerRentPriceByAnAmount(value);
                            } catch (Exception e) {
                                message=e.getMessage();
                                break OUTER;
                            }
                            message = "Udało się zmniejszyć cenę o podaną wartość";
                            break;
                        default:
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
            out.println("<title>Zmiana ceny</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>"+message+"</h2><br><br>");  
            out.println("<br><br><button onclick=\"location.href = 'ChangePrice.html';\" >Wróć do poprzedniej strony</button><br><br>");
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
