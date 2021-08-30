import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    @Column(name = "contact_id")
    private int id;
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;

    @Column(name = "company_name")
    private String companyName;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Contact(String name, String phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }

    //returns contact details
    public String showContactDetails() {
        return "ID: ".concat(String.valueOf(this.getId())).concat("\n")
                .concat("Company Name: ").concat(this.getCompanyName()).concat("\n")
                .concat("Name: ").concat(this.getName()).concat("\n")
                .concat("Phone Number: ").concat(this.getPhoneNumber()).concat("\n")
                .concat("Email: ").concat(this.getEmail()).concat("\n");
    }
}
