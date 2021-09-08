package DeadCodersSocietyClubRickyMartinStage2Homework3.dao;

import DeadCodersSocietyClubRickyMartinStage2Homework3.enums.Industry;
import lombok.*;

import javax.persistence.*;
import java.util.Collections;
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
  @Enumerated(EnumType.STRING)
  private Industry industry;

  @Column(name = "employee_count")
  private int employeeCount;

  private String city;
  private String country;

  @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
  private Set<Opportunity> opportunities;

  @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
  private Set<Contact> contacts;


  public Account(Industry industry, int employeeCount, String city, String country, List<Contact> contactList, List<Opportunity> opportunityList) {
    this.industry = industry;
    this.employeeCount = employeeCount;
    this.city = city;
    this.country = country;
    //this.contactList = contactList;
    //this.opportunityList = opportunityList;
  }

  public Account(Industry industry, int employeeCount, String city, String country, Opportunity opportunity,Contact contact) {
    setIndustry(industry);
    setEmployeeCount(employeeCount);
    setCity(city);
    setCountry(country);
    this.opportunities= Collections.singleton(opportunity);
    this.contacts= Collections.singleton(contact);
  }

  //returns dao2.Account details
  public String showAccountDetails(){
    return "Account details: ".concat("\n")
            .concat(" ID: ").concat(String.valueOf(this.getId())).concat("\n")
            .concat(" Industry: ").concat(String.valueOf(this.getIndustry())).concat("\n")
            .concat(" Employee count: ").concat(String.valueOf(this.getEmployeeCount())).concat("\n")
            .concat(" City: ").concat(this.getCity()).concat("\n")
            .concat(" Country: ").concat(this.getCountry()).concat("\n");
  }
}
