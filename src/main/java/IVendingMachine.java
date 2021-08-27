public interface IVendingMachine {
    /**
     * Vending machine manufacturer.
     */
    String getManufacturer();

    /**
     * Amount of money inserted into vending machine.
     */
    Money getAmount();

    /**
     * Gets products that are sold.
     */
    Product[] getProducts();
    /**
     * Sets products that are sold.
     */
    void setProducts(Product[] products);

    /**
     * Inserts the coin into vending machine.
     * @param amount Coin amount.
     */
    Money insertCoin(Money amount);

    /**
     * Returns all inserted coins back to user.
     */
    Money returnMoney();

    /**
     * Buys product from list of product.
     * @param productNumber Product number in vending machine product list.
     */
    Product buy(int productNumber);
}
