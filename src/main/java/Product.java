public class Product {
    public Product(int available, Money price, String name){
        setAvailable(available);
        setPrice(price);
        setName(name);
    }

    private int available;
    private Money price;
    private String name;

    /**
     * Gets the available amount of product.
     */
    public int getAvailable(){
        return this.available;
    }
    /**
     * Sets the available amount of product.
     */
    public void setAvailable(int available){
        this.available = available;
    }

    /**
     * Gets the product price.
     */
    public Money getPrice(){
        return this.price;
    }
    /**
     * Sets the product price.
     */
    public void setPrice(Money price){
        this.price = price;
    }

    /**
     * Gets the product name.
     */
    public String getName(){
        return this.name;
    }
    /**
     * Sets the product name.
     */
    public void setName(String name){
        this.name = name;
    }
}