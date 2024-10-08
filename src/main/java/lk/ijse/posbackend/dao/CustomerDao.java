package lk.ijse.posbackend.dao;




import lk.ijse.posbackend.data.CustomerDTO;
import lk.ijse.posbackend.entity.CustomerEntity;

import java.sql.Connection;
import java.util.ArrayList;

public  interface CustomerDao  {
    CustomerDTO getCustomer(String cusID, Connection connection);
    ArrayList<CustomerEntity> getCustomerList(Connection connection);
    String saveCustomer(CustomerEntity customerEntity, Connection connection);
    boolean updateCustomer(CustomerEntity customerEntity, Connection connection);
    boolean deleteCustomer(String cusID,Connection connection);

}
