package id.co.bankmandiri.customer.service;

import id.co.bankmandiri.customer.main.Customer;
import id.co.bankmandiri.customer.main.CustomerException;

public interface CustomerIFace {
    void tambahCustomer(Customer customer) throws CustomerException;
    void editCustomer(Customer customer) throws CustomerException;
    Customer cariCustomer(int id) throws CustomerException;
    void hapusCustomer(int id) throws CustomerException;
}
