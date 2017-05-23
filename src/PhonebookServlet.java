import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="phonebook", urlPatterns="/phonebook")
public class PhonebookServlet extends HttpServlet{

    protected void chooseToDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (req.getParameter("action")!=null && req.getParameter("action").equals("add")){
        if (req.getParameter("action")!=null && req.getParameter("action").equals("add")){
//            User insUser = new User();
//            insUser.setId(0);
//            req.setAttribute("user", insUser);
            getServletContext().getRequestDispatcher("/EditUser.jsp").forward(req,resp);
        }
        if (req.getParameter("Edit")!=null){

        }
        if (req.getParameter("action")!=null && req.getParameter("action").equals("all") ){
            List<User> userList=Crud.loadAll();

            req.setAttribute("userList", userList);
            getServletContext().getRequestDispatcher("/UsersView.jsp").forward(req,resp);
        }
        if (req.getParameter("action")!=null && req.getParameter("action").equals("delete")){
            if (req.getParameter("id")!=null){
                Long userID=(Long.parseLong(req.getParameter("id")));
                Crud.deleteUser(userID);
                req.getRequestDispatcher("/phonebook?action=all").forward(req, resp);
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
