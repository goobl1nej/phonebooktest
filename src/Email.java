import java.util.ArrayList;

public class Email {
    private String email;
    ArrayList<String> em = new ArrayList();
    Email(String email){
//        this.email=email;
        em.add("Petrovich@po.hui");
        em.add("Petrovich@na.hui");
    }

    public void setEmail(){
        em.add(this.email=email);
    }
    public ArrayList<String> getEmail(){
        return em;
    }



//    List<Email> email = new ArrayList<>()
//    public void setEmail() {this.email=email;}
//    public List<Email> getEmail() {return email;}
}