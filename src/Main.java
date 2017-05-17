import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<User> users=generatePhonebook();
        List<User> userList=loadFromDB2();
//        printPhonebook(users);
        printPhonebook(userList);
    }


    private static List<User> loadFromDB2(){
        List<User> userList=null;
        Connection connectiondb =null;
        PreparedStatement usersPS=null;
        PreparedStatement emailsOfUserPS=null;
        PreparedStatement phonesOfUserPS=null;


        try {
            Class.forName("org.postgresql.Driver");
            connectiondb = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            usersPS=connectiondb.prepareStatement("SELECT * FROM user_");
            emailsOfUserPS=connectiondb.prepareStatement("SELECT * FROM email_ WHERE user_id=?");
            phonesOfUserPS=connectiondb.prepareStatement("SELECT * FROM phone_ WHERE user_id=?");

            ResultSet userset =usersPS.executeQuery();
            if(userset!=null) {
                userList=new ArrayList<User>();
                while (userset.next()) {
                    long id = userset.getLong("user_id");
                    String lastname = userset.getString("lastname");
                    String firstname = userset.getString("firstname");
                    String middlename = userset.getString("middlename");
                    Date birthday = (userset.getDate("birthday"));
                    User user=new User(id,firstname,lastname,middlename, birthday);
                    emailsOfUserPS.setLong(1, user.getId());
                    ResultSet emailsRS=emailsOfUserPS.executeQuery();
                    if(emailsRS!=null) {
                        List<Email> emails=new ArrayList<Email>();
                        while (emailsRS.next()){
                            int emailId=emailsRS.getInt("email_id");
                            String email = emailsRS.getString("email");

                            emails.add(new Email(emailId, email));
                        }
                        user.setEmails(emails);
                    }
                    phonesOfUserPS.setLong(1,user.getId());

                    ResultSet phonesRS=phonesOfUserPS.executeQuery();
                    if(phonesRS!=null) {
                        List<Phone> phones=new ArrayList<Phone>();
                        while (phonesRS.next()) {
                            int phoneId=phonesRS.getInt("phone_id");
                            String phone=phonesRS.getString("phone");
                            phones.add(new Phone(phoneId,phone));
                        }
                        user.setPhones(phones);
                    }
                    userList.add(user);

                }

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(phonesOfUserPS!=null) try {
                phonesOfUserPS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(emailsOfUserPS!=null) try {
                emailsOfUserPS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(usersPS!=null) try {
                usersPS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(connectiondb!=null) try {
                connectiondb.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return userList;
    }

    private static List<User> loadFromDB() {
        List<User> userList=new ArrayList<>();


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
                Statement emailstatement = connectiondb.createStatement();
                ResultSet emailset = emailstatement.executeQuery("SELECT * FROM email_");
                List<Email> userEmail = new ArrayList<>();
                while (emailset.next()) {
                    if (emailset.getInt("user_id") == id) {
                        String email = emailset.getString("email");
                        userEmail.add(new Email(email));
                    }
                }
//                emailset.close();
//                emailstatement.close();
                Statement phonestatement = connectiondb.createStatement();
                ResultSet phoneset = phonestatement.executeQuery("SELECT * FROM phone_");
                List<Phone>userPhone=new ArrayList<>();
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
        if (users!=null && !users.isEmpty()) {
            for (User person : users) {
                System.out.println("id: " + person.getId() + "\nФИО: " + person.getFirstname() + " " + person.getLastname() + " " + person.getMiddlename() + "\nДата рождения: " + person.getBirthday().getDate() + "." + person.getBirthday().getMonth() + "." + person.getBirthday().getYear());
                if (person.getEmails() != null && !person.getEmails().isEmpty()) {
                    System.out.println("Эл почта:");
                    for (Email email : person.getEmails()) {
                        System.out.println("\t" + email.getEmail());
                    }
                }
                if (person.getPhones() != null && !person.getEmails().isEmpty()) {
                    System.out.println("Телефоны:");
                    for (Phone phone : person.getPhones()) {
                        System.out.println("\t" + phone.getPhone());
                    }
                }
                System.out.println("\n----------------------------------------------\n");
            }
        } else System.out.println("пользователь не найден");
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
