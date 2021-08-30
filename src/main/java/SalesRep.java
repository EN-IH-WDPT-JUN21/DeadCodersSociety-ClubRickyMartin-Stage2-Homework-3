import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "sales_rep")
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

    //returns SalesRep details
    public String showSalesRepDetails() {
        return "ID: ".concat(String.valueOf(this.getId())).concat("\n")
                .concat("Name: ").concat(this.getName()).concat("\n");
    }
}