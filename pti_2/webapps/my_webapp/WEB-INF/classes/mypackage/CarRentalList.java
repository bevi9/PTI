package mypackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CarRentalList extends HttpServlet {

  int cont = 0;

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException {
    res.setContentType("text/html");
    List<String> filetxt = new List<String>("/var/lib/tomcat7/webapp/my_webapp/WEB-INF/classes/mypackage/car.txt");
    filetxt.readAllLines();
    PrintWriter out = res.getWriter();
    String nombre = req.getParameter("userid");
    cont ++;
    out.println("<html><big>Hola Amigo "+ nombre + "</big><br>"+
                cont + " Accesos desde su carga.<br> Listado de coches alquilados: <br>" + filetxt + " </html>");
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException {
    doGet(req, res);
  }
}
