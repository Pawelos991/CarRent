package pl.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.controllers.CarController;
import pl.entities.CarEntity;

/**Servlet handling changing price of car rent
 *
 * @author Pawel
 * @version 1.5
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
            CarController controller;
            HttpSession session = request.getSession();
            if (session.getAttribute("controller") == null) {
                EntityManager em;
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("pl_MyDB1_jar_1.0-SNAPSHOTPU");
                em = emf.createEntityManager();
                controller = new CarController(em);
                CarEntity car = em.find(CarEntity.class, 1l);
                if(car==null)
                {
                    controller.InitDB();
                }
                session.setAttribute("controller", controller);
            } 
            else 
            {
                controller = (CarController) session.getAttribute("controller");
            }
            OUTER:
            for (int i = 1; i<6; i++) {
                if ((controller.getMake(i)+" "+controller.getModel(i)).equals(makeAndModel)) {
                    switch (choiceS) {
                        case "setNew":
                            try {
                                controller.changeRentPrice(value, i);
                            } catch (Exception e) {
                                message=e.getMessage();
                                break OUTER;
                            }
                            message = "Udało się zmienić cenę do podanej wartości";
                            break;
                        case "raise":
                            try {
                                controller.raiseRentPrice(value, i);
                            } catch (Exception e) {
                                message=e.getMessage();
                                break OUTER;
                            }
                            message = "Udało się zwiększyć cenę do podanej wartości";
                            break;
                        case "raiseByAmount":
                            try {
                                controller.raiseRentPriceByAnAmount(value, i);
                            } catch (Exception e) {
                                message=e.getMessage();
                                break OUTER;
                            }
                            message = "Udało się zwiększyć cenę o podaną wartość";
                            break;
                        case "lower":
                            try {
                                controller.lowerRentPrice(value, i);
                            } catch (Exception e) {
                                message=e.getMessage();
                                break OUTER;
                            }
                            message = "Udało się zmniejszyć cenę do podanej wartości";
                            break;
                        case "lowerByAmount":
                            try {
                                controller.lowerRentPriceByAnAmount(value, i);
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
