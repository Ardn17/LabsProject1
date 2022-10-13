package id.co.bankmandiri.customer;

import id.co.bankmandiri.customer.main.CustomerDAO;
import id.co.bankmandiri.customer.utils.DatabaseConnection;
import id.co.bankmandiri.customer.main.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ConnectionDBTest {
    @Test
    void getProps(){

        String url = DatabaseConnection.getProperties("url");
        Assertions.assertEquals("jdbc:mysql://localhost:3306/testproject",url);

    }



    private static CustomerDAO cdao = new CustomerDAO();

    @Test
    void addCustomers(){

        Customer customer = new Customer("Faris", "Bhagaskoro", LocalDate.of(1998,7,17));
        try{
            cdao.tambahCustomer(customer);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    void cariCustomers(){

        try{
            cdao.cariCustomer(1);
        }catch (Exception e){
            System.out.println(e);
        }
    }


    @Test
    void editCustomers(){

        Customer customer = new Customer(1,"Prita", "Bhagaskoro", LocalDate.of(1921,7,17));
        try{
            cdao.editCustomer(customer);
            cdao.cariCustomer(1);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
