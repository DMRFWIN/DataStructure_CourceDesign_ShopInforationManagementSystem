package Bean;

public class Store {
    private String id;
    private String name;
    private String cre;//信誉值

    private Store next_Store;

    public Store() {
        id = name = cre = null;
        next_Store=null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCre() {
        return cre;
    }

    public void setCre(String cre) {
        this.cre = cre;
    }

    public Store getNext_Store() {
        return next_Store;
    }

    public void setNext_Store(Store next_Store) {
        this.next_Store = next_Store;
    }

    public Store(String id, String name, String cre, Store next_Store) {
        this.id = id;
        this.name = name;
        this.cre = cre;
        this.next_Store = next_Store;
    }
}
