import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.EnumMap;
import java.util.List;

@WebServlet(name = "edit", urlPatterns = "/edit")
public class UserDataChangeServlet extends HttpServlet {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    protected void viewRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
        if (req.getParameter("OK")!=null) {
            insUser(req);
            req.getRequestDispatcher("/phonebook?action=all").forward(req, resp);
        }
//        if (req.getParameter("save")!=null) {
//            if (req.getParameter("userID")!=null && !req.getParameter("userID").isEmpty()) {
//                editUser(req);
//                req.getRequestDispatcher("/phonebook?action=all").forward(req, resp);
//            }
//        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            viewRequest(req, resp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            viewRequest(req, resp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

//    private void editUser(HttpServletRequest req) throws ServletException, IOException, ParseException {
//        User newUser = reqUser(req);
//        Long userID = Long.parseLong(req.getParameter("userID"));
//        Crud.updateUser(userID, newUser);
//    }

    private void insUser(HttpServletRequest req) throws ServletException, IOException, ParseException {
        User newUser = reqUser(req);
        Crud.newUser(newUser);
    }

    private User reqUser(HttpServletRequest req) throws ServletException, IOException, ParseException {
        User User = new User();
        Email email = new Email();
        Phone phone = new Phone();
        User.setLastname(req.getParameter("lastName"));
        User.setFirstname(req.getParameter("firstName"));
        User.setMiddlename(req.getParameter("middleName"));
        java.util.Date utilDate = sdf.parse(req.getParameter("birthday"));
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        User.setBirthday(sqlDate);
//        for (phone:req.getParameter("phone")) {
//
//        }
        User.setEmail(req.getParameter("email"));
        User.setPhone(req.getParameter("phone"));
        return User;
    }
}
