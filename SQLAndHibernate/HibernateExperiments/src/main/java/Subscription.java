import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Subscriptions")
public class Subscription {
    @EmbeddedId
    private SubscriptionKey id;
    @Column(name = "subscription_date")
    private LocalDate subscriptionDate;

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDate subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
