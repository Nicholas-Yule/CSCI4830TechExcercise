

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UtilDBYule;


@WebServlet("/InsertYule")
public class InsertYule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertYule() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String taskName = request.getParameter("taskName");
		String category = request.getParameter("category");
		String deadline = request.getParameter("deadline");
		String priority = request.getParameter("priority");
		
		UtilDBYule.createTasks(taskName, category, deadline, priority);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Task added to To-Do List!";
		String docType = "<!doctype html public\"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + //
				"<html>\n" + //
				"<head><title>" + title + "</title></head>\n" + //
				"<body bgcolor=\"#f0f0f0\">\n" + //
				"<h2 align=\"center\">" + title + "</h2>\n" + //
				"<ul>\n" + //
				
				" <li><b>Task</b> " + taskName + "\n" + //
				" <li><b>Category</b> " + category + "\n" + //
				" <li><b>Deadline</b> " + deadline + "\n" + //
				" <li><b>Priority</b> " + priority + "\n" + //
				
				"</ul>\n");
		out.println("<a href=/webproject-ex-0305-Yule/insert_yule.html>Return to To-Do List</a> <br>");
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
