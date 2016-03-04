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
	

	File f = new File("/var/lib/tomcat7/webapps/my_webapp/WEB-INF/classes/mypackage/car.txt");

    String model = req.getParameter("model_vehicle");
	Double preu = Double.parseDouble(model);	
    String engine = req.getParameter("sub_model_vehicle");
 	String num = req.getParameter("num_vehicles");
	String dies = req.getParameter("dies_lloguer");
	String descompte = req.getParameter("descompte"); 
    cont ++;
	if(model.equals("54")) model = "Econòmic";
	else if(model.equals("71")) model = "Semi-luxe";
	else if(model.equals("82")) model = "Luxe";
	else if(model.equals("139")) model = "Limusina";

	
	if(num != null && !num.isEmpty() && dies != null && !descompte.isEmpty() && dies != null && !descompte.isEmpty()) {
		int n = Integer.parseInt(num);
		int d = Integer.parseInt(dies);
		double des = Double.parseDouble(descompte);
		if (n <= 0 || d <= 0 || (des < 0.0 && des > 1.0)) {

		    out.println("<html><big> Has introduit malament els parametres, si-us-plau torne ha introduir el cotxe </big>");
			out.println("<A HREF=\"http://localhost:8080/my_webapp/carrental_form_new.html\">New Car</A></html");
		}
		else {
		    preu *= Double.parseDouble(num);
		    preu *= Double.parseDouble(dies);
			Double a = preu * des;
			preu = preu - a;
			
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("/var/lib/tomcat7/webapps/my_webapp/WEB-INF/classes/mypackage/car.txt", true)));
			writer.println(model + ", " + engine + ", " + num + ", " + dies + ", " + descompte + ", " + preu.shortValue());
			writer.close();
			out.println("<html><big> Has llogat " + num + " cotxe/s " + model + " de " + engine + " durant " + dies + " dies, amb el descompte " + des + " són " + preu.shortValue() + " Euros </big><br>");
			out.println("<A HREF=\"http://localhost:8080/my_webapp/carrental_home.html\">Home</A></html");
		}
		  
	}
	else {
		  out.println("<html><big> T'ha faltat introduir parametres </big>");
		out.println("<A HREF=\"http://localhost:8080/my_webapp/carrental_form_new.html\">New Car</A></html");
	}
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException {
    doGet(req, res);
  }
}
