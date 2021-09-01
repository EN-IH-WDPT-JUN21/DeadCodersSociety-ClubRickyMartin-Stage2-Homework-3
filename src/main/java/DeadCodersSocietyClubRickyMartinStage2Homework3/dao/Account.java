package DeadCodersSocietyClubRickyMartinStage2Homework3.dao;

import DeadCodersSocietyClubRickyMartinStage2Homework3.Industry;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Setter(value = AccessLevel.NONE)
  @Column(name = "account_id")
  private int id;

  private Industry industry;

  @Column(name = "employee_count")
  private int employeeCount;

  private String city;
  private String country;

  @OneToMany(mappedBy = "account")
  private Set<Opportunity> opportunities;

  @OneToMany(mappedBy = "account")
  private Set<Contact> contacts;


  public Account(Industry industry, int employeeCount, String city, String country, List<Contact> contactList, List<Opportunity> opportunityList) {
    this.industry = industry;
    this.employeeCount = employeeCount;
    this.city = city;
    this.country = country;
    //this.contactList = contactList;
    //this.opportunityList = opportunityList;
  }

  public Account(Industry industry, int employeeCount, String city, String country, Contact contact, Opportunity opportunity) {
    this.industry = industry;
    this.employeeCount = employeeCount;
    this.city = city;
    this.country = country;
    //this.contactList = new ArrayList<dao2.Contact>();
    //this.contactList.add(contact);
    //this.opportunityList = new ArrayList<dao2.Opportunity>();
    //this.opportunityList.add(opportunity);
  }

  //returns dao2.Account details
  public String showAccountDetails(){
    return "ID: ".concat(String.valueOf(this.getId())).concat("\n")
            .concat("DeadCodersSocietyClubRickyMartinStage2Homework3.Industry: ").concat(String.valueOf(this.getIndustry())).concat("\n")
            .concat("Employee count: ").concat(String.valueOf(this.getEmployeeCount())).concat("\n")
            .concat("City: ").concat(this.getCity()).concat("\n")
            .concat("Country: ").concat(this.getCountry()).concat("\n");
  }
}
