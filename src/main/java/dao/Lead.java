package dao;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    @Column(name = "lead_id")
    private int id;
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;

    @Column(name = "company_name")
    private String companyName;

    @OneToOne
    @JoinColumn(name = "contact_id")    //maybe to delete
    private Contact contact;

    @OneToOne       //maybe @ManyToOne... salesRep could have many Leads
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;

    public Lead(String name, String phoneNumber, String email, String companyName) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

    //returns lead details
    public String showLeadDetails() {
        return "ID: ".concat(String.valueOf(this.getId())).concat("\n")
                .concat("Company Name: ").concat(this.getCompanyName()).concat("\n")
                .concat("Name: ").concat(this.getName()).concat("\n")
                .concat("Phone Number: ").concat(this.getPhoneNumber()).concat("\n")
                .concat("Email: ").concat(this.getEmail()).concat("\n");
    }
}
