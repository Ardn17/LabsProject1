package id.co.bankmandiri.customer.main;

import java.time.LocalDate;
import java.util.Objects;

public class Customer {
    private int custId;
    private String fName;
    private String lName;
    private LocalDate dateOB;

    public Customer(String firstName, String lastName, LocalDate dataOfBirth) {
        this.fName = firstName;
        this.lName = lastName;
        this.dateOB = dataOfBirth;
    }

    public Customer(int customerId, String firstName, String lastName, LocalDate dataOfBirth) {
        this(firstName,lastName,dataOfBirth);
        this.custId = customerId;
    }

    public Integer getCustId() {
        return custId;
    }

    public String getNamaAwal() {
        return fName;
    }

    public String getNamaAkhir() {
        return lName;
    }

    public LocalDate getDateOB() {
        return dateOB;
    }

    public void setNamaAwal(String firstName) {
        this.fName = firstName;
    }

    public void setNamaAkhir(String lastName) {
        this.lName = lastName;
    }

    public void setDateOB(LocalDate dataOfBirth) {
        this.dateOB = dataOfBirth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ",FName='" + fName + '\'' +
                ", LName='" + lName + '\'' +
                ", dateOB=" + dateOB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return custId == customer.custId &&
                Objects.equals(fName, customer.fName) &&
                Objects.equals(lName, customer.lName) &&
                Objects.equals(dateOB, customer.dateOB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custId, fName, lName, dateOB);
    }
}