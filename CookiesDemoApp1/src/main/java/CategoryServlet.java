

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.parser.Cookie;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		javax.servlet.http.Cookie[] cookie=request.getCookies();
		if (cookie!=null) {
			for (javax.servlet.http.Cookie cookie2 : cookie) {
				if (cookie2.getName().equals("cCategory")) {
					getServletContext().getRequestDispatcher("/"+cookie2.getValue()+".html").forward(request, response);
					
				}
				
			}
			
		}
		getServletContext().getRequestDispatcher("/topcategory.html").forward(request, response);
	}

}
