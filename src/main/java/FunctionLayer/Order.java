package FunctionLayer;

public class Order {

    private final int id;
    private final int customerid;

    public Order(int id, int customerid) {
        this.id = id;
        this.customerid = customerid;
    }

    public int getId() {
        return id;
    }

    public int getCustomerid() {
        return customerid;
    }
}
