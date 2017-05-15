import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users=generatePhonebook();
        printPhonebook(users);

        users=loadFromDB();
    }

    private static List<User> loadFromDB() {
        List<User> userList=new ArrayList<>();



        return userList;
    }

    private static void printPhonebook(List<User> users) {
        for (User person: users) {
            System.out.println("id: " + person.getId() + "\nФИО: " + person.getFirstname() + " " + person.getLastname() + " " + person.getMiddlename() + "\nДата рождения: " + person.getBirthday());
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
        users.add(new User(1, "Petr", "Petrov", "Petrovich", "01.12.1978", emailList, phoneList));

        List<Email> emailList1 = new ArrayList<>();
        emailList1.add(new Email("petrov@da.ru"));
        emailList1.add(new Email("petrov@net.ru"));
        List<Phone> phoneList1 = new ArrayList<>();
        phoneList1.add(new Phone("+78324567489"));
        phoneList1.add(new Phone("+78568432246"));
        phoneList1.add(new Phone("+78938432689"));
        users.add(new User(2, "Ivan", "Petrov", "Sidorovich", "06.09.1965", emailList1, phoneList1));
        users.add(new User(3, "Test", "Testov", "Testovich", "12.12.2012"));
        users.add(new User(3, "Test", "Testov", "Testovich", "12.12.2012", new ArrayList<Email>(), new ArrayList<Phone>()));

        return users;
    }
}
