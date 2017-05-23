import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Crud {

    private Crud(){
    }

    public static List<User> loadAll(){
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

    public static List<User> loadUserById(int userID){
//        List<User> userList=null;
        User userOneId = null;
        Connection connectiondb =null;
        PreparedStatement usersPS=null;
        PreparedStatement emailsOfUserPS=null;
        PreparedStatement phonesOfUserPS=null;


        try {
            Class.forName("org.postgresql.Driver");
            connectiondb = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            usersPS=connectiondb.prepareStatement("SELECT * FROM user_WHERE user_id=?");
            emailsOfUserPS=connectiondb.prepareStatement("SELECT * FROM email_ WHERE user_id=?");
            phonesOfUserPS=connectiondb.prepareStatement("SELECT * FROM phone_ WHERE user_id=?");

            usersPS.setLong(1,userID);
            ResultSet userset =usersPS.executeQuery();
            if(userset!=null) {
                userOneId=new User();
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


        return (List<User>) userOneId;
    }

    public static void newUser(User user){
        Connection connectiondb =null;
        PreparedStatement usersPS=null;
        PreparedStatement emailsOfUserPS=null;
        PreparedStatement phonesOfUserPS=null;


        try {
            Class.forName("org.postgresql.Driver");
            connectiondb = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            usersPS=connectiondb.prepareStatement("INSERT INTO user_"+"(lastname,firstname,middlename,birthday)"+"VALUES (?,?,?,?)");
            emailsOfUserPS=connectiondb.prepareStatement("INSERT INTO email_"+"(user_id,email)"+"VALUES (?,?)");
            phonesOfUserPS=connectiondb.prepareStatement("INSERT INTO phone_"+"(user_id,phone)"+"VALUES (?,?)");
            usersPS.setString(1, user.getLastname());
            usersPS.setString(2, user.getFirstname());
            usersPS.setString(3, user.getMiddlename());
            usersPS.setDate(4, (java.sql.Date) user.getBirthday());
            usersPS.execute();
            PreparedStatement usersPSId=connectiondb.prepareStatement("select user_id from user_ order by user_id desc limit 1");
            ResultSet s = usersPSId.executeQuery();
            long id = s.getLong("user_id");;
            emailsOfUserPS.setLong(1,id);
            emailsOfUserPS.setString(2, user.getEmail());
            emailsOfUserPS.execute();
            phonesOfUserPS.setLong(1,id);
            phonesOfUserPS.setString(2, user.getPhone());
            phonesOfUserPS.execute();
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
    }

    public static void updateUser(User user){

    }

    public static void deleteUser(Long userID){
        Connection connectiondb =null;
        PreparedStatement usersPS=null;
        PreparedStatement emailsOfUserPS=null;
        PreparedStatement phonesOfUserPS=null;


        try {
            Class.forName("org.postgresql.Driver");
            connectiondb = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            usersPS=connectiondb.prepareStatement("DELETE FROM user_ WHERE user_id=?");
            emailsOfUserPS=connectiondb.prepareStatement("DELETE FROM email_ WHERE user_id=?");
            phonesOfUserPS=connectiondb.prepareStatement("DELETE FROM phone_ WHERE user_id=?");
            emailsOfUserPS.setLong(1,userID);
            emailsOfUserPS.execute();
            phonesOfUserPS.setLong(1,userID);
            phonesOfUserPS.execute();
            usersPS.setLong(1,userID);
            usersPS.execute();
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
    }

}

