package mypackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CarRentalList extends HttpServlet {

  int cont = 0;

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException {
    res.setContentType("text/html");
    File file = new File("/var/lib/tomcat7/webapps/my_webapp/WEB-INF/classes/mypackage/car.txt");
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    StringBuffer stringBuffer= new StringBuffer();
    String line;
    while ((line = bufferedReader.readLine()) != null) {
        stringBuffer.append(line);
        stringBuffer.append("\n");
      }
      fileReader.close();

    PrintWriter out = res.getWriter();
      out.println(stringBuffer.toString());
    String nombre = req.getParameter("userid");
    cont ++;

  }

  public void doPost(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException {
    doGet(req, res);
  }
}
