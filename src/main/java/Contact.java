import java.util.concurrent.atomic.AtomicInteger;

public class Contact {

    private static AtomicInteger idCounter = new AtomicInteger(0);

    private final int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    public Contact(String name, String phoneNumber, String email, String companyName) {
        id = idCounter.incrementAndGet();

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }

    //returns contact details
    public String showContactDetails(){
        return "ID: ".concat(String.valueOf(this.getId())).concat("\n")
                .concat("Company Name: ").concat(this.getCompanyName()).concat("\n")
                .concat("Name: ").concat(this.getName()).concat("\n")
                .concat("Phone Number: ").concat(this.getPhoneNumber()).concat("\n")
                .concat("Email: ").concat(this.getEmail()).concat("\n");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
