public class Lead {
    static int leadCount = 0;
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    //counts the ammount of leads created
    {
        leadCount += 1;
    }

    public Lead(String name, String phoneNumber, String email, String companyName) {
        setId();
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

//returns lead details
    public String showLeadDetails(){
        return "ID: ".concat(String.valueOf(this.getId())).concat("\n")
                .concat("Company Name: ").concat(this.getCompanyName()).concat("\n")
                .concat("Name: ").concat(this.getName()).concat("\n")
                .concat("Phone Number: ").concat(this.getPhoneNumber()).concat("\n")
                .concat("Email: ").concat(this.getEmail()).concat("\n");
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = leadCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
