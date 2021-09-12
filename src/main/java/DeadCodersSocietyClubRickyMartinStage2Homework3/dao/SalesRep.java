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

    @OneToMany(mappedBy = "salesRep", fetch = FetchType.EAGER)
    private Set<Lead> leads;

    @OneToMany(mappedBy = "salesRep", fetch = FetchType.EAGER)
    private Set<Opportunity> opportunities;

    public SalesRep(String name) {
        this.name = name;
    }

    //returns SalesRep details
    public String showSalesRepDetails() {
        return "SalesRep details: ".concat("\n")
                .concat("ID: ").concat(String.valueOf(this.getId())).concat("\n")
                .concat("Name: ").concat(this.getName()).concat("\n");
    }
}