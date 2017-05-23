import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="phonebook", urlPatterns="/phonebook")
public class PhonebookServlet extends HttpServlet{

    protected void chooseToDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("Add")!=null){

        }
        if (req.getParameter("Edit")!=null){

        }
        if (req.getParameter("action")!=null && req.getParameter("action").equals("All") ){
            List<User> userList=Crud.loadAll();

            req.setAttribute("userList", userList);
            getServletContext().getRequestDispatcher("/UsersView.jsp").forward(req,resp);
        }
        if (req.getParameter("Delete")!=null){
            if (req.getParameter("userID")!=null){
                Long userID=(Long.parseLong(req.getParameter("userID")));
                Crud.deleteUser(userID);
            }

        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        chooseToDo(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        chooseToDo(req, resp);
    }
}
