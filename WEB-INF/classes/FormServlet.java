import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class FormServlet extends HttpServlet {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
                    throws ServletException, IOException
  {
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
	  String title = "Using doGet method to serve the form to client/webBrowser";
      String docType =
      "<!doctype html>\n";
      out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>\n" +
                "<h1 align=center>" + title + "</h1>\n" +
                "<ul>\n" +
                "<form action='' method='POST'>" +
                "  <li><b>First Name</b>: " +
                "<input type='text' name='first_name'>" + "\n" +
                "  <li><b>Last Name</b>: "+
                "<input type='text' name='last_name'>" + "\n" +
                "<input type='submit' name='submit' value='submit'/>" +
                "</form>" +

                "</ul>\n" +
                "</body></html>");
  }
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
                    throws ServletException, IOException
  {
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
	  String title = "Using doPost method to retrive and  data sent by client and send response to client.";
      String docType =
      "<!doctype html>\n";
      out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +

                "  <li><b>First Name</b>: "+
                request.getParameter("first_name") + "\n" +
                "  <li><b>Last Name</b>: "+
                request.getParameter("last_name") + "\n" +
                "</ul>\n" +
                "</body></html>");
  }
}
