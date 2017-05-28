import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="phonebook", urlPatterns="/phonebook")
public class PhonebookServlet extends HttpServlet{

    protected void chooseToDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("action")!=null && req.getParameter("action").equals("add")){
//            User insUser = new User();
//            insUser.setId(0);
//            req.setAttribute("user", insUser);
            getServletContext().getRequestDispatcher("/UserAdd.jsp").forward(req,resp);
        }
        if (req.getParameter("Edit")!=null){

        }
        if (req.getParameter("AddEmail")!=null){
            if ( req.getParameter("userID")!=null && !req.getParameter("userID").isEmpty()){
                Long userID=(Long.parseLong(req.getParameter("userID")));
                String email=(req.getParameter("email"));
                Crud.newEmail(userID, email);
                User user = Crud.loadUserById(userID);
                req.setAttribute("user", user);
                req.getRequestDispatcher("/EditUser.jsp").forward(req, resp);
            }
        }
        if (req.getParameter("AddPhone")!=null){
            if ( req.getParameter("userID")!=null){
                Long userID=(Long.parseLong(req.getParameter("userID")));
                String phone=(req.getParameter("phone"));
                Crud.newPhone(userID,phone);
                User user = Crud.loadUserById(userID);
                req.setAttribute("user", user);
                req.getRequestDispatcher("/EditUser.jsp").forward(req, resp);
            }
        }

        if (req.getParameter("action")!=null && req.getParameter("action").equals("all") ){
            List<User> userList=Crud.loadAll();
            req.setAttribute("userList", userList);
            getServletContext().getRequestDispatcher("/AllUsersView.jsp").forward(req,resp);
        }
        if (req.getParameter("action")!=null && req.getParameter("action").equals("view")){
            if (req.getParameter("userID")!=null) {
                Long userID = (Long.parseLong(req.getParameter("userID")));
                User user = Crud.loadUserById(userID);
                if (req.getParameter("ps")!=null) {
                    req.setAttribute("user", user);
                    req.getRequestDispatcher("/EditUser.jsp").forward(req, resp);
                } else {
                    req.setAttribute("user", user);
                    req.getRequestDispatcher("/ViewUser.jsp").forward(req, resp);
                }
            }
        }

        if (req.getParameter("action")!=null && req.getParameter("action").equals("delete")){
            if (req.getParameter("userID")!=null){
                Long userID=(Long.parseLong(req.getParameter("userID")));
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
