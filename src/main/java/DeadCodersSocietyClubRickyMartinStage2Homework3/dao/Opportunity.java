package DeadCodersSocietyClubRickyMartinStage2Homework3.dao;

import DeadCodersSocietyClubRickyMartinStage2Homework3.Product;
import DeadCodersSocietyClubRickyMartinStage2Homework3.Status;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "opportunities")
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    @Column(name = "opportunity_id")
    private int id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Product product;
    private int quantity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    private Contact decisionMaker;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;

    public Opportunity(Product product, int quantity, Contact decisionMaker) {
        status = Status.OPEN;
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
    }

    public Opportunity(Product product, int quantity, Contact decisionMaker, SalesRep salesRep) {
        status = Status.OPEN;
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setSalesRep(salesRep);
    }

    //returns dao2.Opportunity details
    public String showOpportunityDetails() {
        return "Opportunity details: ".concat("\n")
                .concat("   ID: ").concat(String.valueOf(this.getId())).concat("\n")
                .concat("   Status: ").concat(this.getStatus().name()).concat("\n")
                .concat("   Product: ").concat(this.getProduct().name()).concat("\n")
                .concat("   Quantity: ").concat(String.valueOf(this.getQuantity())).concat("\n")
                .concat("   Contact details: ").concat("\n")
                .concat("   SalesRep Id: ").concat(String.valueOf(this.salesRep.getId())).concat("\n")
                .concat("   SalesRep Name: ").concat(this.salesRep.getName()).concat("\n")
                .concat(this.getDecisionMaker().showContactDetails()).concat("\n");
    }
}
