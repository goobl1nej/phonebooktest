import java.util.ArrayList;

public class Phone{
    String phone;
    ArrayList<String> ph = new ArrayList<>();
    public Phone (String phone) {
//        this.phone = phone;
        ph.add("+7(855) 645 1254");
        ph.add("+7(847) 325 1647");
    }

    public void setPhone(){
        ph.add(this.phone=phone);
    }
    public ArrayList<String> getPhone(){
        return ph;
    }




//    public void setPhone() {phone.add();}
//    public List<Phone> getPhone() {return phone;}
}
