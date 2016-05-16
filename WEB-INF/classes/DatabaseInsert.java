import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

// Extend HttpServlet class
public class DatabaseInsert extends HttpServlet {

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
                "<h1 align=\"center\">" + title + "</h1>\n" +
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
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/javaee";

        final String USERNAME = "root";
        final String PASSWORD = "";
        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //DriverManager.registerDriver(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

            stmt = conn.createStatement();
            String sql = "INSERT INTO user (firstname,lastname) VALUES('"+ firstName+"','"+ lastName+"')";
            //String sqlRead = "SELECT * FROM user";

            stmt.executeUpdate(sql);
            //ResultSet rs = stmt.executeQuery(sql);

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null)
                    stmt.close();
                if(conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

  }
}
