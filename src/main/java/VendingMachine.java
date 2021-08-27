public class VendingMachine implements IVendingMachine {

    public VendingMachine(String manufacturer, Product[] products){
        this.manufacturer = manufacturer;
        this.products = products;
        this.amount = new Money(0,0);
    }

    private String manufacturer;
    private Money amount;
    private Product[] products;

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public Money getAmount() {
        return this.amount;
    }

    @Override
    public Product[] getProducts() {
        return this.products;
    }
    @Override
    public void setProducts(Product[] products) {
        this.products = products;
    }

    /*
     * I believe it's impossible to do complete check on coin correctness
     * with following class set to have only euros and eurocents
     * as there might be coins of another country (SEK, RUB, dollars etc)
     * also there might be sum consisting of 1,2,2 (etc) cents,
     * that still would be valid for abstract division by 5 check
     */
    @Override
    public Money insertCoin(Money amount) {

        int cents = amount.getCents();
        int euros = amount.getEuros();
        int remainder = cents % 5;

        if(remainder != 0){
            this.amount.setCents(cents - remainder);
        } else {
            this.amount.setCents(cents);
        }
        this.amount.setEuros(euros);

        return amount;
    }

    @Override
    public Money returnMoney() {
        //removing money from the vending machine
        Money change = getAmount();
        this.amount = new Money(0,0);
        return change;
    }

    @Override
    public Product buy(int productNumber) {
        int productCount = this.products[productNumber].getAvailable();
        Money productPrice = this.products[productNumber].getPrice();

        if(productCount != 0 && !productPrice.isBiggerThan(getAmount())){
            this.products[productNumber].setAvailable(productCount-1);
            this.amount = this.amount.subtract(this.products[productNumber].getPrice());
        }

        return this.products[productNumber];
    }

}
