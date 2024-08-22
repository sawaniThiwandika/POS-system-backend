package lk.ijse.posbackend.bo;


import lk.ijse.posbackend.data.CustomerDTO;

import java.sql.Connection;

 public interface CustomerBo {
    CustomerDTO getCustomer(String studentID, Connection connection);
    String saveCustomer(CustomerDTO customerDTO, Connection connection);
    boolean updateCustomer(CustomerDTO studentDTO, Connection connection);
    boolean deleteCustomer(String studentID,Connection connection);

}
