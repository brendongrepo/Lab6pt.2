/**
 * BankAccount:
 * 1) Stores running totals for balance, deposits, withdrawals, and interest.
 * 2) Supports whole-dollar and currency transactions via overloaded methods.
 * 3) Applies monthly interest using an APR entered as a percent (ie 3.5 -> 3.5% APR).
 * 4) Provides getters/setters for all fields.
 *
 * @author Brendon Grepo, bgrepo@student.sdccd.edu
 * @version v1.0
 * @since 10/19/2025
 */
public class BankAccount {
    //// field variables (private)
    private double balance;
    private double deposit;
    private double withdraw;
    private double interest;
    private double monthlyIntRate;

    //// constructors (public)
    /** No-arg constructor initializes to zero values. */
    public BankAccount() {
        balance = 0.0;
        deposit = 0.0;
        withdraw = 0.0;
        interest = 0.0;
        monthlyIntRate = 0.0;
    }

    /**
     * Whole-dollar mode constructor.
     * @param startingBalance whole-dollar starting balance
     * @param aprPercent annual percentage rate (ie 3.5 for 3.5%)
     */
    public BankAccount(int startingBalance, double aprPercent) {
        this(startingBalance * 1.0, aprPercent);
    }

    /**
     * Currency mode constructor.
     * @param startingBalance currency starting balance
     * @param aprPercent annual percentage rate (ie 3.5 for 3.5%)
     */
    public BankAccount(double startingBalance, double aprPercent) {
        balance = startingBalance;
        deposit = 0.0;
        withdraw = 0.0;
        interest = 0.0;
        monthlyIntRate = (aprPercent / 100.0) / 12.0;
    }

    //// getters and setters (public)
    public double getBalance()  { return balance;  }

    public double getDeposit()  { return deposit;  }

    public double getWithdraw() { return withdraw; }

    public double getInterest() { return interest; }

    public double getMonthlyIntRate() { return monthlyIntRate; }

    public void setMonthlyIntRate(double aprPercent) {
        monthlyIntRate = (aprPercent / 100.0) / 12.0;
    }

    public void setBalance(double balance)     { this.balance = balance; }

    public void setDeposit(double deposit)     { this.deposit = deposit; }

    public void setWithdraw(double withdraw)   { this.withdraw = withdraw; }

    public void setInterest(double interest)   { this.interest = interest; }

    //// input methods (public)
    /** Deposit (whole-dollar). */
    public void makeDeposit(int amount) {
        double a = amount;
        balance += a;
        deposit += a;
    }

    /** Deposit (currency). */
    public void makeDeposit(double amount) {
        balance += amount;
        deposit += amount;
    }

    /** Withdraw (whole-dollar). */
    public void makeWithdraw(int amount) {
        double a = amount;
        balance -= a;
        withdraw += a;
    }

    /** Withdraw (currency). */
    public void makeWithdraw(double amount) {
        balance -= amount;
        withdraw += amount;
    }

    /** Calculate and apply one month of interest. */
    public void calcInterest() {
        double monthInt = balance * monthlyIntRate;
        balance += monthInt;
        interest += monthInt;
    }
}
