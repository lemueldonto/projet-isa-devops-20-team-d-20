package fr.unice.polytech.isa.dd.entities;
import org.joda.time.DateTime;
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Package implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int secretNumber;

    @NotNull
    private double weight;

    private int number;

//    @NotNull
    private DateTime deliveryDate;

    @ManyToOne
    private Provider provider;

    public Package() {
        // Necessary for JPA instantiation process
    }

    public Package(int nb, Double w,DateTime d, Provider pro) {
        number = nb;
        weight = w;
        deliveryDate = d;
        provider = pro;
    }

    public int getNumber() { return number; }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Provider getProvider() {
        return provider;
    }

    public int getProvider_id() {
        return provider.getId();
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public int getSecret_number() {
        return secretNumber;
    }

    public void setSecret_number(int secret_number) {
        this.secretNumber = secret_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(DateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /*** ecriture de la méthode hash à faire ****/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package that = (Package) o;
        return Objects.equals(id, that.id) && Double.compare(that.weight, weight) == 0;
    }

}
