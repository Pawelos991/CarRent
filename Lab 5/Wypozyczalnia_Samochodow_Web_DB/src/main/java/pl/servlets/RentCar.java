package pl.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.controllers.CarController;
import pl.entities.CarEntity;

/**Servlet handling renting cars
 *
 * @author Pawel
 * @version 1.5
 */
@WebServlet(name = "RentCar", urlPatterns = {"/RentCar"})
public class RentCar extends HttpServlet {

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
        String message="";
        String lastCar="";
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
        
        Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("lastCar")) {
                        lastCar = cookie.getValue();
                        break;
                    }
                }
            }
        
        for(int i=1; i<6;i++)
        {
            if((controller.getMake(i)+" "+controller.getModel(i)).equals(makeAndModel))
            {
               message = "Uda??o Ci si?? wypo??yczy?? samoch??d Twoich marze??!\nTo "+controller.getMake(i)+" "+controller.getModel(i)+"!";
               Cookie cookie = new Cookie("lastCar", controller.getMake(i)+" "+controller.getModel(i));
               try{ 
                   controller.tryRent(i);
               }
               catch(Exception e){
                   message = "Ups! Niestety ten samoch??d jest ju?? wypo??yczony";
                   break;
               }
               response.addCookie(cookie);
               break;
            }
        }
        
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Wypo??yczenie samochodu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>"+message+"</h2>");
            if(lastCar.equals(""))
                out.println("<br><h2>To Twoje pierwsze wypo??yczone u nas auto!</h2><br>");
            else
                out.println("<h2>Ostatnio wypo??yczy??e??(/-a??): "+lastCar+"</h2>");
            out.println("<br><br><button onclick=\"location.href = 'Rent.html';\" >Wr???? do poprzedniej strony</button><br><br>");
            out.println("<button onclick=\"location.href = 'index.html';\" >Wr???? do strony g????wnej</button>");
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
