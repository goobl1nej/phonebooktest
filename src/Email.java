import java.util.ArrayList;

public class Email {
    private long emailId;
    private String email;


    public Email() {
    }

    public Email(String email) {
        this.email = email;
    }

    public long getEmailId() {
        return emailId;
    }

    public void setEmailId(long emailId) {
        this.emailId = emailId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailId=" + emailId +
                ", email='" + email + '\'' +
                '}';
    }
}