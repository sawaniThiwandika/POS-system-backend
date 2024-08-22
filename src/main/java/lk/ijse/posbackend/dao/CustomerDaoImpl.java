package lk.ijse.posbackend.dao;



import lk.ijse.posbackend.data.CustomerDTO;
import lk.ijse.posbackend.entity.CustomerEntity;

import java.sql.*;
import java.util.ArrayList;


public class CustomerDaoImpl implements CustomerDao {
    static String save_statement = "INSERT INTO customer VALUES (?,?,?,?,?,?)";
    static String getCustomersstatement = "SELECT * FROM customer";

    @Override
    public CustomerDTO getCustomer(String cusID, Connection connection) {
        CustomerDTO dto = new CustomerDTO();
        return dto;
    }

    @Override
    public ArrayList<CustomerEntity> getCustomerList(Connection connection) {
        ArrayList<CustomerEntity> customerEntities = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getCustomersstatement);
            ResultSet resultSet = null;
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customerEntities.add(new CustomerEntity(
                        resultSet.getString("cus_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("contact"),
                        resultSet.getDate("date").toLocalDate()
                        ));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //System.out.println();
        return customerEntities;
    }


    @Override
    public String saveCustomer(CustomerEntity customer, Connection connection) {
        int i = 0;

        try {
            System.out.println(customer);

            PreparedStatement preparedStatement = connection.prepareStatement(save_statement);
                preparedStatement.setString(1, customer.getCusId());
                preparedStatement.setString(2, customer.getName());
                preparedStatement.setString(3, customer.getEmail());
                preparedStatement.setString(4, customer.getAddress());
                preparedStatement.setString(5, customer.getContact());
                preparedStatement.setDate(6, Date.valueOf(customer.getDate()));
                i = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (i > 0) {
            return "Saved";
        }
        else {
            return "error";
        }


    }

    @Override
    public boolean updateCustomer(CustomerEntity customer, Connection connection) {
    return true;
    }

    @Override
    public boolean deleteCustomer(String cusID, Connection connection) {
        return true;
    }
}
