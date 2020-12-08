package pl.tomozak.warsztaty.models;


import javax.persistence.*;

@Entity
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String name;
    private String color;
    private double price;

    @Enumerated(EnumType.STRING)
    private TypeOfProduct typeOfProduct;

    public Product() {
    }

    public Product(String name, String color, double price, TypeOfProduct typeOfProduct) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.typeOfProduct = typeOfProduct;
    }

    public Product(Long id ,String name, String color, double price, TypeOfProduct typeOfProduct) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.typeOfProduct = typeOfProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TypeOfProduct getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(TypeOfProduct typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }
}
