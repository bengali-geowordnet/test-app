import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class RootServlet extends HttpServlet {
	private String message;
	private String html;
	private String title;
	public void init() throws ServletException
	{
		title = ".: APP :.";
		message = "...:: Welcome to Our APP ::...";
		html = " <!DOCTYPE html><html><head><title>"+title+
		"</title></head><body><input type='button'/>"+
		"<h1>"+message+"</h1></body></html> ";
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(html);
	}
	public void destroy()
	{

	}
}
