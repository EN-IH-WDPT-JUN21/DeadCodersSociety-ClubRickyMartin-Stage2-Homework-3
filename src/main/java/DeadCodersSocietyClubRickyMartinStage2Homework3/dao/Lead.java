package DeadCodersSocietyClubRickyMartinStage2Homework3.dao;

import DeadCodersSocietyClubRickyMartinStage2Homework3.repository.LeadRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "leads")
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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;

    public Lead(String name, String phoneNumber, String email, String companyName, SalesRep salesRep) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
        setSalesRep(salesRep);
    }

    public Lead(String name, String phoneNumber, String email, String companyName) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

    //returns lead details
    public String showLeadDetails() {
        return "Lead details: ".concat("\n")
                .concat("   ID: ").concat(String.valueOf(this.getId())).concat("\n")
                .concat("   Company Name: ").concat(this.getCompanyName()).concat("\n")
                .concat("   Name: ").concat(this.getName()).concat("\n")
                .concat("   Phone Number: ").concat(this.getPhoneNumber()).concat("\n")
                .concat("   Email: ").concat(this.getEmail()).concat("\n")
                .concat("   SalesRep Id: ").concat(String.valueOf(this.salesRep.getId())).concat("\n")
                .concat("   SalesRep Name: ").concat(this.salesRep.getName()).concat("\n");
    }
}
