package lk.ijse.posbackend.bo;



import lk.ijse.posbackend.dao.CustomerDao;
import lk.ijse.posbackend.dao.CustomerDaoImpl;
import lk.ijse.posbackend.data.CustomerDTO;
import lk.ijse.posbackend.entity.CustomerEntity;

import java.sql.Connection;

public class CustomerBoImpl implements CustomerBo {
    CustomerDao customerDao=new CustomerDaoImpl();
    @Override
    public CustomerDTO getCustomer(String studentID, Connection connection) {
        CustomerDTO dto = new CustomerDTO();
        return dto;
    }



    @Override
    public String saveCustomer(CustomerDTO customerDTO, Connection connection) {
        System.out.println("Im in bo "+customerDTO);
        CustomerEntity customerEntity = new CustomerEntity(customerDTO.get_cusId(), customerDTO.get_cusName(), customerDTO.get_cusEmail(), customerDTO.get_cusAddress(),
                customerDTO.get_cusContact(), customerDTO.get_addCusDate());
        String s = customerDao.saveCustomer(customerEntity, connection);
        return s;

    }

    @Override
    public boolean updateCustomer(CustomerDTO studentDTO, Connection connection) {
    return true;
    }

    @Override
    public boolean deleteCustomer(String studentID, Connection connection) {
        return true;
    }
}
