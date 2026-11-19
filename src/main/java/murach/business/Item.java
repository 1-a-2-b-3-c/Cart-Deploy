package murach.business;

public class Item {
    private String Id;
    private String description;
    private Double price;
    private Integer quantity;

    public Item() {
        this.Id = "";
        this.description = "";
        this.price = 0.0;
        this.quantity = 0;
    }

    public Item(String Id, String description, Double price, Integer quantity) {
        this.Id = Id;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return this.Id;
    }

    public void SetId(String Id) {
        this.Id = Id;
    }

    // Getter và Setter cho Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    // Getter và Setter cho Price
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double Price) {
        this.price = Price;
    }

    // Getter và Setter cho Quantity
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.quantity = Quantity;
    }
    
}
