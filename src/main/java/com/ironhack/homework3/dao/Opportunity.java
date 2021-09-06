package com.ironhack.homework3.dao;

import com.ironhack.homework3.enums.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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

    @OneToOne       //Maybe @ManyToOne - Account could have relation with Opportunities
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToOne       //Maybe @ManyToOne - salesRep could have many Opportunities
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;

    public Opportunity(Product product, int quantity, Contact decisionMaker) {
        status = Status.OPEN;
        this.product = product;
        this.quantity = quantity;
        //this.decisionMaker = decisionMaker;
    }

    //returns dao.Opportunity details
    public String showOpportunityDetails() {
        return "ID: ".concat(String.valueOf(this.getId())).concat("\n")
                .concat("enums.Status: ").concat(this.getStatus().name()).concat("\n")
                .concat("enums.Product: ").concat(this.getProduct().name()).concat("\n")
                .concat("Quantity: ").concat(String.valueOf(this.getQuantity())).concat("\n")
                .concat("dao.Contact details: ").concat("\n")
                .concat(this.getDecisionMaker().showContactDetails()).concat("\n");
    }
}
