package id.co.bankmandiri.customer.main;

import id.co.bankmandiri.customer.service.CustomerIFace;
import id.co.bankmandiri.customer.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements CustomerIFace {
    private Connection connection;

    public CustomerDAO(){
        connection = DatabaseConnection.getConnection();
    }
    public CustomerDAO(Connection connection){
        this.connection = connection;
    }

    private final String queryTampilkanAllCustomer= "INSERT INTO customers (fname,lastname,dob) VALUES (?,?,?)";
    public List<Customer> tampilkanAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (
//                Connection connection = DriverManager.getConnection(dburl,username,password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(queryTampilkanAllCustomer);
        ){
            while (resultSet.next()){
                System.out.print(resultSet.getInt("id") + " ");
                System.out.print(resultSet.getString("firstname") + " ");
                System.out.print(resultSet.getString("lastname") + " ");
                System.out.print(resultSet.getDate("dob") + " ");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    private final String querycariCustomer= "SELECT * FROM `employee` WHERE emp_id = ?";

    @Override
    public Customer cariCustomer(int id) {
        Customer customer = null;
        try (
//                Connection connection = DriverManager.getConnection(dburl,username,password);
                PreparedStatement preparedStatement = connection.prepareStatement(querycariCustomer);
        ){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                customer = new Customer(
                        resultSet.getInt("emp_id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getDate("emp_birthdate").toLocalDate());
            }
        }catch (Exception e){
            System.out.println(e);
        }
        if (customer != null){
            System.out.println(customer);
        }else{
            CustomerException customerException = new CustomerException("AAAAAAAAAA");
            customerException.printStackTrace();
        }

        return customer;
    }

    @Override
    public void hapusCustomer(int id) throws CustomerException {

    }

    private final String queryTambahCustomer= "INSERT INTO employee (firstname,lastname,emp_birthdate) VALUES (?,?,?)";
    public void tambahCustomer(Customer customer){
        try (
            PreparedStatement preparedStatement = connection.prepareStatement(queryTambahCustomer);
        ){
            preparedStatement.setString(1,customer.getNamaAwal());
            preparedStatement.setString(2,customer.getNamaAkhir());
            preparedStatement.setDate(3,Date.valueOf(customer.getDateOB()));
            preparedStatement.execute();

        }catch (Exception e){

        }
    }


    private final String queryEditCustomer= "UPDATE employee SET firstname = ?, lastname = ?, emp_birthdate = ?  WHERE emp_id = ? ";
    public void editCustomer(Customer customer){
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(queryEditCustomer);
        ){
            preparedStatement.setString(1,customer.getNamaAwal());
            preparedStatement.setString(2,customer.getNamaAkhir());
            preparedStatement.setDate(3,Date.valueOf(customer.getDateOB()));
            preparedStatement.setInt(4,customer.getCustId());
            preparedStatement.executeUpdate();



        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
