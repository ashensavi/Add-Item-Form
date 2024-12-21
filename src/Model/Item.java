package Model;

public class Item {

    private String code;
    private String name;
    private String qty;
    private Double price;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Item() {
    }

    public Item(String code, String name, String qty, double price) {
        this.code = code;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", qty='" + qty + '\'' +
                ", price=" + price +
                '}';
    }
}
