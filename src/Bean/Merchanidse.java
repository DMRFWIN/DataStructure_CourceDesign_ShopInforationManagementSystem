package Bean;

public class Merchanidse {

    private String name;
    private double price;
    private int Sales;

    private String id;

    public Merchanidse() {
    }

    public Merchanidse(String name, double price, int sales, String id, Merchanidse next_merchanidse) {

        this.name = name;
        this.price = price;
        Sales = sales;
        this.id = id;
        this.next_merchanidse = next_merchanidse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Merchanidse next_merchanidse;

    public Merchanidse getNext_merchanidse() {
        return next_merchanidse;
    }

    public void setNext_merchanidse(Merchanidse next_merchanidse) {
        this.next_merchanidse = next_merchanidse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSales() {
        return Sales;
    }

    public void setSales(int sales) {
        Sales = sales;
    }



}
