import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<User> users=generatePhonebook();
        List<User> userList=loadFromDB();
//        printPhonebook(users);
        printPhonebook(userList);
    }

    private static List<User> loadFromDB() {
        List<User> userList=new ArrayList<>();
        List<Email> userEmail=new ArrayList<>();
        List<Phone> userPhone=new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
            Connection connectiondb = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            Statement userstatement = connectiondb.createStatement();
            ResultSet userset = userstatement.executeQuery("SELECT * FROM user_");
            while (userset.next()) {
                int id = userset.getInt("user_id");
                String lastname = userset.getString("lastname");
                String firstname = userset.getString("firstname");
                String middlename = userset.getString("middlename");
                Date birthday = (userset.getDate("birthday"));
//                Statement emailstatement = connectiondb.createStatement();
                ResultSet emailset = userstatement.executeQuery("SELECT * FROM email_");
                while (emailset.next()) {
                    if (emailset.getInt("user_id") == id) {
                        String email = emailset.getString("email");
                        userEmail.add(new Email(email));
                    }
                }
//                emailset.close();
//                emailstatement.close();
//                Statement phonestatement = connectiondb.createStatement();
                ResultSet phoneset = userstatement.executeQuery("SELECT * FROM phone_");
                while (phoneset.next()) {
                    if (phoneset.getInt("user_id") == id) {
                        String phone = phoneset.getString("phone");
                        userPhone.add(new Phone(phone));
                    }
                }
//                phoneset.close();
//                phonestatement.close();
                userList.add(new User(id, lastname,firstname,middlename,birthday,userEmail,userPhone));
            }
//            userset.close();
//            userstatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    private static void printPhonebook(List<User> users) {
        for (User person: users) {
            System.out.println("id: " + person.getId() + "\nФИО: " + person.getFirstname() + " " + person.getLastname() + " " + person.getMiddlename() + "\nДата рождения: " + person.getBirthday().getDate()+"."+person.getBirthday().getMonth()+"."+person.getBirthday().getYear());
            if (person.getEmails() != null && !person.getEmails().isEmpty()) {
                System.out.println("Эл почта:");
                for (Email email: person.getEmails()) {
                    System.out.println("\t" + email.getEmail());
                }
            }
            if (person.getPhones() != null && !person.getEmails().isEmpty()) {
                System.out.println("Телефоны:");
                for (Phone phone: person.getPhones()) {
                    System.out.println("\t" + phone.getPhone());
                }
            }
            System.out.println("\n----------------------------------------------\n");
        }
    }

    private static List<User> generatePhonebook() {
        ArrayList<User> users = new ArrayList<>();

        Email email = new Email("test1@mail.ru");
        Phone phone = new Phone("+79463334875");
        ArrayList<Email> emailList = new ArrayList<>();
        emailList.add(email);
        ArrayList<Phone> phoneList = new ArrayList<>();
        phoneList.add(phone);
        users.add(new User(1, "Petr", "Petrov", "Petrovich", new Date(1958,12,7), emailList, phoneList));

        List<Email> emailList1 = new ArrayList<>();
        emailList1.add(new Email("petrov@da.ru"));
        emailList1.add(new Email("petrov@net.ru"));
        List<Phone> phoneList1 = new ArrayList<>();
        phoneList1.add(new Phone("+78324567489"));
        phoneList1.add(new Phone("+78568432246"));
        phoneList1.add(new Phone("+78938432689"));
        users.add(new User(2, "Ivan", "Petrov", "Sidorovich", new Date(1965,9,6), emailList1, phoneList1));
        users.add(new User(3, "Test", "Testov", "Testovich", new Date(1958,4,7)));
        users.add(new User(4, "Test", "Testov", "Testovich", new Date(2012,5,12), new ArrayList<Email>(), new ArrayList<Phone>()));

        return users;
    }
}
