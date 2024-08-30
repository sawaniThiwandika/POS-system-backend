package lk.ijse.posbackend.bo;

import lk.ijse.posbackend.data.OrderDetailDTO;
import lk.ijse.posbackend.entity.OrderDetailEntity;

import java.sql.Connection;
import java.util.ArrayList;

public interface OrderDetailBo {
    ArrayList<OrderDetailDTO> getOrderDetailsList(Connection connection);
    OrderDetailDTO getOrderDetails(String itemCode, Connection connection);
    String saveOrderDetails(OrderDetailDTO oorderDetailEntity, Connection connection);
    boolean updateOrderDetails(OrderDetailDTO orderDetailDTO ,Connection connection);
    boolean deleteOrderDetails(String orderID,Connection connection);
}
