package lk.ijse.posbackend.bo;



import lk.ijse.posbackend.dao.CustomerDao;
import lk.ijse.posbackend.dao.CustomerDaoImpl;
import lk.ijse.posbackend.data.CustomerDTO;
import lk.ijse.posbackend.entity.CustomerEntity;

import java.sql.Connection;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {
    CustomerDao customerDao=new CustomerDaoImpl();

    @Override
    public ArrayList<CustomerDTO> getCustomerList(Connection connection) {
        ArrayList<CustomerDTO> customerDTOArrayList = new ArrayList<>();
        ArrayList<CustomerEntity> customerList = customerDao.getCustomerList(connection);
        for (CustomerEntity customer:customerList) {
            customerDTOArrayList.add(new CustomerDTO(customer.getCusId(),customer.getName(),customer.getEmail(),
                    customer.getAddress(),customer.getContact(),customer.getDate()));

        }
        return customerDTOArrayList;
    }

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
    public boolean updateCustomer(CustomerDTO customerDTO, Connection connection) {
        System.out.println("Im in bo "+customerDTO);
        CustomerEntity customerEntity = new CustomerEntity(customerDTO.get_cusId(), customerDTO.get_cusName(), customerDTO.get_cusEmail(), customerDTO.get_cusAddress(),
                customerDTO.get_cusContact(), customerDTO.get_addCusDate());
        boolean s = customerDao.updateCustomer(customerEntity, connection);
        return s;

    }

    @Override
    public boolean deleteCustomer(String studentID, Connection connection) {
        return true;
    }
}
