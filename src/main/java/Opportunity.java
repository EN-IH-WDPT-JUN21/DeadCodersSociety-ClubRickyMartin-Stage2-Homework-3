import java.util.concurrent.atomic.AtomicInteger;

public class Opportunity {

    private static AtomicInteger idCounter = new AtomicInteger(0);

    private final int id;
    private Status status;
    private Product product;
    private int quantity;
    private Contact decisionMaker;

    public Opportunity(Product product, int quantity, Contact decisionMaker) {
        id = idCounter.incrementAndGet();
        status = Status.OPEN;

        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }
}
