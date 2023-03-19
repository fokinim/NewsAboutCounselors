import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchase {
    @EmbeddedId
    private LinkedPurchaseKey id;

    public LinkedPurchaseKey getId() {
        return id;
    }

    public void setId(LinkedPurchaseKey id) {
        this.id = id;
    }
}
