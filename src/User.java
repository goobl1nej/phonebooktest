public class User {

    private int id;
    private String firstname;
    private String lastname;
    private String middlename;
    private int birthday;


    public User(int id, String firstname, String lastname, String middlename, int birthday, String email, int phone) {

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
    public int getBirthday() {
        return birthday;
    }
}
