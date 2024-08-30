package lk.ijse.posbackend.bo;

import lk.ijse.posbackend.data.OrderDetailDTO;

import java.sql.Connection;
import java.util.ArrayList;

public class OrderDetailBoImpl implements OrderDetailBo {

    @Override
    public ArrayList<OrderDetailDTO> getOrderDetailsList(Connection connection) {
        return null;
    }

    @Override
    public OrderDetailDTO getOrderDetails(String itemCode, Connection connection) {
        return null;
    }

    @Override
    public String saveOrderDetails(OrderDetailDTO oorderDetailEntity, Connection connection) {
        return null;
    }

    @Override
    public boolean updateOrderDetails(OrderDetailDTO orderDetailDTO, Connection connection) {
        return false;
    }

    @Override
    public boolean deleteOrderDetails(String orderID, Connection connection) {
        return false;
    }
}
