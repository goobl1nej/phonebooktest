import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private int id;
    private String firstname;
    private String lastname;
    private String middlename;
    private Date birthday;
    private List<Email> emails;
    private List<Phone> phones;

    public User() {
    }

    public User(int id, String firstname, String lastname, String middlename, Date birthday) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.birthday = birthday;
    }

    public User(int id, String firstname, String lastname, String middlename, Date birthday, List<Email> emails, List<Phone> phones) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.birthday = birthday;
        this.emails= emails;
        this.phones= phones;
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
    public Date getBirthday() {
        return birthday;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", birthday='" + birthday + '\'' +
                ", emails=" + emails +
                ", phones=" + phones +
                '}';
    }
}
