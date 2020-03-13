package fr.unice.polytech.isa.dd;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Bill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private DateTime billDate; //Date où la facture a été emise

    @NotNull
    private DateTime paymentDate; //Date du reglement de la facture

    @NotNull
    private double billAmount = 0.0; //Montant de la facture

    //PAID or UNPAID. May be have to use an enum
    @NotNull
    private String billStatus = "UNPAID";

    @NotNull
    private Provider provider;

    @NotNull
    private List<Delivery> deliveries;

    public Bill() {
        // Necessary for JPA instantiation process
    }

    public Bill(Provider p, List<Delivery> ds) {
        provider = p;
        deliveries = ds;
        billDate = new DateTime();
        for (Delivery d : ds) {
            billAmount+= d.getPrice();
        }
    }

    public int getId() {
        return id;
    }

    public DateTime getBillDate() {
        return billDate;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setPaymentDate(DateTime pd) {
       paymentDate = pd;
    }

    public void setBillStatus(String bs) {
        billStatus = bs;
    }

    /*** ecriture de la méthode hash à faire ****/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill that = (Bill) o;
        return Objects.equals(id, that.id) && Objects.equals(provider, that.provider) && Objects.equals(billAmount, that.billAmount);
    }

}