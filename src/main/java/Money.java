public class Money {
    public Money(int euros, int cents){
        setEuros(euros);
        setCents(cents);
    }


    private int euros;	//in coins these are always 1e & 2e
    private int cents;	//in coins these are 1c, 2c, 5c, 10c, 20c, 50c; 1c & 2c coins are not allowed;

    public int getEuros(){
        return this.euros;
    }
    public void setEuros(int euros){
        this.euros = euros;
    }

    public int getCents(){
        return this.cents;
    }
    public void setCents(int cents){
        this.cents = cents;
    }

    /**
     * Subtracts money from money and returns the remainder
     * @param part subtrahend money
     * @return Money result of substraction
     */
    public Money subtract(Money part){
        int totalSum1 = this.getEuros()*100 + this.getCents();
        int totalSum2 = part.getEuros()*100 + part.getCents();

        int remainder = totalSum1 - totalSum2;
        int euros = remainder / 100;
        int cents = remainder % 100;

        return new Money(euros, cents);
    }

    /**
     * Compares if first Money is bigger than other one
     * @param part compared Money
     * @return boolean
     */
    public boolean isBiggerThan(Money part){
        int totalSum1 = this.getEuros()*100 + this.getCents();
        int totalSum2 = part.getEuros()*100 + part.getCents();

        return totalSum1 > totalSum2;
    }

    /**
     * Compares if first Money is equal to other one
     * @param part compared Money
     * @return boolean
     */
    public boolean isEqualTo(Money part){
        int totalSum1 = this.getEuros()*100 + this.getCents();
        int totalSum2 = part.getEuros()*100 + part.getCents();

        return totalSum1 == totalSum2;
    }
}
