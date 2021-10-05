package my.dal;

public class Product {
    private int productID;
    private String name;
    private String productNumber;
    private  Double listPrice;

    public Product(){}

    public Product(int id, String name, String code, Double price) {
        this.productID = id;
        this.name = name;
        this.productNumber = code;
        this.listPrice = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }
}
