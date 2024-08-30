package lk.ijse.posbackend.dao;

import lk.ijse.posbackend.data.ItemDTO;
import lk.ijse.posbackend.data.OrderDTO;
import lk.ijse.posbackend.entity.OrderEntity;

import java.sql.Connection;
import java.util.ArrayList;

public interface OrderDao {
    ArrayList<OrderEntity> getOrderList(Connection connection);
    OrderEntity getOrder(String itemCode, Connection connection);
    String saveOrder(OrderEntity orderEntity, Connection connection);
    boolean updateOrder(OrderEntity oderEntity, Connection connection);
    boolean deleteOrder(String orderID,Connection connection);
}
