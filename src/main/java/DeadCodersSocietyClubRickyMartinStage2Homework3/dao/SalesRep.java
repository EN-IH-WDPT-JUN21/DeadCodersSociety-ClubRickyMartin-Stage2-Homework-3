package DeadCodersSocietyClubRickyMartinStage2Homework3.dao;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sales_reps")
public class SalesRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    @Column(name = "sales_rep_id")
    private int id;
    private String name;

    @OneToMany(mappedBy = "salesRep")
    private Set<Lead> leads;

    @OneToMany(mappedBy = "salesRep")
    private Set<Opportunity> opportunities;

    public SalesRep(String name) {
        this.name = name;
    }

    //returns dao2.SalesRep details
    public String showSalesRepDetails() {
        return "ID: ".concat(String.valueOf(this.getId())).concat("\n")
                .concat("Name: ").concat(this.getName()).concat("\n");
    }
}