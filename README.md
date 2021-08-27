# VendingMachineIF2015
Old homework test task

## Vending machine
Think about it as a physical machine.

## Task
Implement Vending machine in code using TDD approach
There are following features:
 * You can update product list at any time
 * You can insert coins, get coins back and get remainder
 * You can buy 1 product at once for inserted coins
 * Machine accepts following coins: 5ȼ, 10ȼ, 20ȼ, 50ȼ, 1 € and 2 €

## We are giving Vending machine interface:
```c#
public interface IVendingMachine
{
/// <summary>Vending machine manufacturer.</summary>
string Manufacturer { get; }
/// <summary>Amount of money inserted into vending machine. </summary>
Money Amount { get; }
/// <summary>Products that are sold.</summary>
Product[] Products { get; set; }
/// <summary>Inserts the coin into vending machine.</summary>
/// <param name="amount">Coin amount.</param>
Money InsertCoin(Money amount);
/// <summary>Returns all inserted coins back to user.</summary>
Money ReturnMoney();
/// <summary>Buys product from list of product.</summary>
/// <param name="productNumber">Product number in vending machine product list.
</param>
Product Buy(int productNumber);
}
```

## We are giving Vending machine interface:
```c#
public struct Money
{
public int Euros { get; set; }
public int Cents { get; set; }
}
public struct Product
{
/// <summary>Gets or sets the available amount of product.</summary>
public int Available { get; set; }
/// <summary>Gets or sets the product price.</summary>
public Money Price { get; set; }
/// <summary>Gets or sets the product name.</summary>
public string Name { get; set; }
}
```

## Take into account
 * User Visual Studio 2012 express or any paid and/or newer version if
available
 * Use TDD approach
 * Use C# language
 * Think about OOP design patters and S.O.L.I.D. principles
 * In case of error throw exception of different type for each situation
 * Comments and code must be in English language
 * No need for UI
 * As a result I need source code of this task
