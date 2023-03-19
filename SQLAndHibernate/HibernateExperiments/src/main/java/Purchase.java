import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity
@Table(name = "PurchaseList")
public class Purchase {
    @EmbeddedId
    private PurchaseKey id;

    private int price;
    @Column(name = "subscription_date")
    private LocalDate subscriptionDate;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDate subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public PurchaseKey getId() {
        return id;
    }

    public void setId(PurchaseKey id) {
        this.id = id;
    }
}
