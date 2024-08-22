package lk.ijse.posbackend.dao;



import lk.ijse.posbackend.data.CustomerDTO;
import lk.ijse.posbackend.entity.CustomerEntity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CustomerDaoImpl implements CustomerDao {
    static String save_statement = "INSERT INTO customer VALUES (?,?,?,?,?,?)";
    @Override
    public CustomerDTO getCustomer(String cusID, Connection connection) {
        CustomerDTO dto = new CustomerDTO();
        return dto;
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
