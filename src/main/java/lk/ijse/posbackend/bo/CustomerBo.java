package lk.ijse.posbackend.bo;


import lk.ijse.posbackend.data.CustomerDTO;

import java.sql.Connection;
import java.util.ArrayList;

public interface CustomerBo {
    ArrayList<CustomerDTO> getCustomerList(Connection connection);
    CustomerDTO getCustomer(String studentID, Connection connection);
    String saveCustomer(CustomerDTO customerDTO, Connection connection);
    boolean updateCustomer(CustomerDTO customerDTO, Connection connection);
    boolean deleteCustomer(String customerID,Connection connection);

}
