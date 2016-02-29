package mypackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CarRentalNew extends HttpServlet {

  int cont = 0;

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    String model = req.getParameter("model_vehicle");
    String engine = req.getParameter("sub_model_vehicle");
	String num = req.getParameter("num_vehicle");
	String descompte = req.getParameter("descompte"); 
    cont ++;
	if(model == "54") model = "economic";
	else if(model == "71") model = "semi-luxe";
	else if(model == "82") model = "luxe";
	else if(model == "139") model = "limusina";
    out.println("<html><big>Hola Amigo\n Tu modelo = "+ model + "\nTu engine = "+ engine + "</big><br>"+  
                cont + " Accesos desde su carga.</html>");
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException {
    doGet(req, res);
  }
}
