package DeadCodersSocietyClubRickyMartinStage2Homework3.dao;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contacts")
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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    public Contact(String name, String phoneNumber, String email, String companyName) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }
    public Contact(String name, String phoneNumber, String email, String companyName, Account account) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
        setAccount(account);
    }

    //returns contact details
    public String showContactDetails() {
        return "Contact Details: ".concat("\n")
                .concat("   ID: ").concat(String.valueOf(this.getId())).concat("\n")
                .concat("   Company Name: ").concat(this.getCompanyName()).concat("\n")
                .concat("   Name: ").concat(this.getName()).concat("\n")
                .concat("   Phone Number: ").concat(this.getPhoneNumber()).concat("\n")
                .concat("   Email: ").concat(this.getEmail()).concat("\n");
    }
}
