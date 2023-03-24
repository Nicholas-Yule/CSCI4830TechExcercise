import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.TaskTable;
import util.UtilDBYule;

@WebServlet("/MyServletHibernateDBYule")
public class MyServletHibernateDBYule extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MyServletHibernateDBYule() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "To do list";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      List<TaskTable> listTasks = UtilDBYule.listTasks();
      for (TaskTable task : listTasks) {
         System.out.println("[DBG] " + task.getId() + ", " //
               + task.getName() + ", " //
               + task.getCategory() + ", " //
               + task.getDeadline() + ", " //
               + task.getPriority());

         out.println("<li> <b>Task:</b> "
               + task.getName() + "<br />" //
               + task.getCategory() + ", " //
               + task.getDeadline() + ", " //
               + task.getPriority() + "</li>");
      }
      out.println("</ul>");
	  out.println("<section><h2 align =\"left\"> Add a task </h2><br />" + //
			  "<form action=\"InsertYule\" method=\"POST\">" + //
			  " Task Name: <input type=\"text\" name=\"taskName\" ><br />" + //
			  " Category: <input type=\"text\" name=\"category\" ><br />" + //
			  " Deadline: <input type=\"text\" name=\"deadline\" ><br />" + //
			  " Priority: <input type=\"text\" name=\"priority\" ><br />" + //
			  "<input type=\"submit\" value=\"Submit\" /></form><section>");
	  
//	  out.println("<section><h3 align =\"right\"> Remove a task </h3><br />" + //
//			  "form action=\"DeleteYule\" method=\"POST\">" + //
//			  "Task: <input type=\"text\" name=\"taskname\"><br />" + //
//			  "<input type=\"submit\" value=\"Submit\" /></form><section>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
