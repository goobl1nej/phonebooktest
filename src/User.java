import java.util.ArrayList;

public class User {

    private int id;
    private String firstname;
    private String lastname;
    private String middlename;
    private String birthday;
    private ArrayList<String> email;

   public User(int id, String firstname, String lastname, String middlename, String birthday) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.birthday = birthday;
        this.email=new Email();
    }
    public void setId() {
        this.id=id;
    }
    public int getId() {
        return id;
    }
    public void setFirstname() {
        this.firstname=firstname;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setLastname() {
        this.lastname=lastname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setMiddlename() {
        this.middlename=middlename;
    }
    public String getMiddlename() {
        return middlename;
    }
    public void setBirthday() {
        this.birthday=birthday;
    }
    public String getBirthday() {
        return birthday;
    }
//    public void setEmail() {
//        this.email=email;
//    }
//    public String getEmail() {
//        return email;
//    }
//    public void setPhone() {
//        this.phone=phone;
//    }
//    public int getPhone() {
//        return phone;
//    }

}
