package lk.ijse.posbackend.dao;




import lk.ijse.posbackend.data.CustomerDTO;
import lk.ijse.posbackend.entity.CustomerEntity;

import java.sql.Connection;

public  interface CustomerDao  {
    CustomerDTO getCustomer(String cusID, Connection connection);
    String saveCustomer(CustomerEntity customerEntity, Connection connection);
    boolean updateCustomer(CustomerEntity customerEntity, Connection connection);
    boolean deleteCustomer(String cusID,Connection connection);

}
