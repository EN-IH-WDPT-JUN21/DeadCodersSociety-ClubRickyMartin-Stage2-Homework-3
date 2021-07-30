import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Account {

  private static AtomicInteger idCounter = new AtomicInteger(0);
  private final int id;
  private Industry industry;
  private int employeeCount;
  private String city;
  private String country;
  private List<Contact> contactList;
  private List<Opportunity> opportunityList;

  public Account(Industry industry, int employeeCount, String city, String country, List<Contact> contactList, List<Opportunity> opportunityList) {
    this.id = idCounter.incrementAndGet();
    this.industry = industry;
    this.employeeCount = employeeCount;
    this.city = city;
    this.country = country;
    this.contactList = contactList;
    this.opportunityList = opportunityList;
  }

  public Account(Industry industry, int employeeCount, String city, String country, Contact contact, Opportunity opportunity) {
    this.id = idCounter.incrementAndGet();
    this.industry = industry;
    this.employeeCount = employeeCount;
    this.city = city;
    this.country = country;
    this.contactList = new ArrayList<>();
    this.contactList.add(contact);
    this.opportunityList = new ArrayList<>();
    this.opportunityList.add(opportunity);
  }

  //returns Account details
  public String showAccountDetails(){
    return "ID: ".concat(String.valueOf(this.getId())).concat("\n")
            .concat("Industry: ").concat(String.valueOf(this.getIndustry())).concat("\n")
            .concat("Employee count: ").concat(String.valueOf(this.getEmployeeCount())).concat("\n")
            .concat("City: ").concat(this.getCity()).concat("\n")
            .concat("Country: ").concat(this.getCountry()).concat("\n");
  }

  public int getId() {
    return id;
  }

  public Industry getIndustry() {
    return industry;
  }

  public void setIndustry(Industry industry) {
    this.industry = industry;
  }

  public int getEmployeeCount() {
    return employeeCount;
  }

  public void setEmployeeCount(int employeeCount) {
    this.employeeCount = employeeCount;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public List<Contact> getContactList() {
    return contactList;
  }

  public void setContactList(List<Contact> contactList) {
    this.contactList = contactList;
  }

  public List<Opportunity> getOpportunityList() {
    return opportunityList;
  }

  public void setOpportunityList(List<Opportunity> opportunityList) {
    this.opportunityList = opportunityList;
  }
}
