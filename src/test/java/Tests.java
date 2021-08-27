import org.junit.Assert;
import org.junit.Test;

public class Tests {
    String manufacturer = "VendingMachineMaker";
    Product[] products = new Product[6];
    VendingMachine vendingMachine;

    Money correctSum = new Money(1,15);
    Money incorrectSum = new Money(9,78);
    Money correctedSum = new Money(9,75);
    Money emptyBankSum = new Money(0,0);

    private void prepareVariables(){
        products[0] = new Product(1, new Money(0, 30), "Chocolate");
        products[1] = new Product(3, new Money(1, 15), "Nuka Cola");
        products[2] = new Product(1, new Money(0, 70), "Cookies");
        products[3] = new Product(7, new Money(1, 35), "Chips");
        products[4] = new Product(9, new Money(4, 45), "Peanuts");
        products[5] = new Product(4, new Money(9, 75), "Very Expensive Thing");

        vendingMachine = new VendingMachine(manufacturer, products);
    }

    @Test
    public void updateProductList(){
        prepareVariables();

        vendingMachine.setProducts(products);
        //Check machine has updated list
        Assert.assertArrayEquals(products, vendingMachine.getProducts());
    }

    @Test
    public void insertCorrectCoinsAndGetCoinsBack(){
        prepareVariables();

        vendingMachine.insertCoin(correctSum);

        Money remainder = vendingMachine.returnMoney();

        //Check if everything is returned
        Assert.assertTrue(correctSum.isEqualTo(remainder));

        //Check if machine bank is empty
        Assert.assertTrue(emptyBankSum.isEqualTo(vendingMachine.getAmount()));
    }
    @Test
    public void insertIncorrectCoinsAndGetCoinsBack(){
        prepareVariables();

        vendingMachine.insertCoin(incorrectSum);

        Money remainder = vendingMachine.returnMoney();

        //Check if accepted money not equals inserted one
        Assert.assertEquals(incorrectSum.getEuros(), remainder.getEuros());
        Assert.assertNotEquals(incorrectSum.getCents(), remainder.getCents());
        Assert.assertFalse(incorrectSum.isEqualTo(remainder));

        //Check if everything is returned
        Assert.assertTrue(correctedSum.isEqualTo(remainder));

        //Check if machine bank is empty
        Assert.assertTrue(emptyBankSum.isEqualTo(vendingMachine.getAmount()));
    }

    @Test
    public void insertTooLittleMoneyToBuyProduct(){
        prepareVariables();

        //insert not enough coins, try to buy product
        vendingMachine.insertCoin(correctSum);

        int productsBeforeBuy = products[5].getAvailable();
        Product productToCheck = vendingMachine.buy(5);

        Money returnedMoney = vendingMachine.returnMoney();

        Assert.assertEquals(productsBeforeBuy, productToCheck.getAvailable());
        Assert.assertTrue(correctSum.isEqualTo(returnedMoney));
    }

    @Test
    public void insertPreciseMoneyToBuyProduct(){
        prepareVariables();

        //insert enough coins, buy product and get remainder
        vendingMachine.insertCoin(correctSum);

        int productsBeforeBuy = products[1].getAvailable();
        Product productToCheck = vendingMachine.buy(1);

        Money returnedMoney = vendingMachine.returnMoney();

        Assert.assertEquals(productsBeforeBuy-1, productToCheck.getAvailable());
        Assert.assertFalse(correctSum.isEqualTo(returnedMoney));
        Assert.assertTrue(returnedMoney.isEqualTo(emptyBankSum));
    }
    @Test
    public void insertTooBigMoneyToBuyProduct(){
        prepareVariables();

        //insert more then required coins, buy product and get remainder
        vendingMachine.insertCoin(correctedSum);

        int productsBeforeBuy = products[1].getAvailable();
        Product productToCheck = vendingMachine.buy(1);

        Money returnedMoney = vendingMachine.returnMoney();

        Assert.assertEquals(productsBeforeBuy-1, productToCheck.getAvailable());
        Assert.assertFalse(correctedSum.isEqualTo(returnedMoney));
        Assert.assertTrue(returnedMoney.isEqualTo(correctedSum.subtract(productToCheck.getPrice())));
    }


}