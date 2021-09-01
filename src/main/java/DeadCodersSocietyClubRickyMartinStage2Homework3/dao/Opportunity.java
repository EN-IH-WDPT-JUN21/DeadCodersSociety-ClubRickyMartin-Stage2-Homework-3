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
    private Status status;
    private Product product;
    private int quantity;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact decisionMaker;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToOne
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;

    public Opportunity(Product product, int quantity, Contact decisionMaker) {
        status = Status.OPEN;
        this.product = product;
        this.quantity = quantity;
        //this.decisionMaker = decisionMaker;
    }

    //returns dao2.Opportunity details
    public String showOpportunityDetails() {
        return "ID: ".concat(String.valueOf(this.getId())).concat("\n")
                .concat("DeadCodersSocietyClubRickyMartinStage2Homework3.Status: ").concat(this.getStatus().name()).concat("\n")
                .concat("DeadCodersSocietyClubRickyMartinStage2Homework3.Product: ").concat(this.getProduct().name()).concat("\n")
                .concat("Quantity: ").concat(String.valueOf(this.getQuantity())).concat("\n")
                .concat("dao2.Contact details: ").concat("\n")
                .concat(this.getDecisionMaker().showContactDetails()).concat("\n");
    }
}
