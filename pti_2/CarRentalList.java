package mypackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CarRentalList extends HttpServlet {

  int cont = 0;

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException {
    res.setContentType("text/html");
	PrintWriter out = res.getWriter();
    File file = new File("/var/lib/tomcat7/webapps/my_webapp/WEB-INF/classes/mypackage/car.txt");
	if(file.exists() && !file.isDirectory()) {    
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer= new StringBuffer();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
		    stringBuffer.append(line);
		    stringBuffer.append("\n");
		  }
		  fileReader.close();

		  out.println(stringBuffer.toString());
	 }
	else {
		 out.println("<html><big> No s'ha introduit encara cap cotxe </big>");
			out.println("<A HREF=\"http://localhost:8080/my_webapp/carrental_form_new.html\">New Car</A></html");
	}

  }

  public void doPost(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException {
    doGet(req, res);
  }
}
