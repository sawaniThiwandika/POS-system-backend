package lk.ijse.posbackend.dao;

import lk.ijse.posbackend.entity.OrderDetailEntity;
import lk.ijse.posbackend.entity.OrderEntity;

import java.sql.Connection;
import java.util.ArrayList;

public interface OrderDetailDao {
    ArrayList<OrderDetailEntity> getOrderList(Connection connection);
    OrderDetailEntity getOrder(String itemCode, Connection connection);
    boolean saveOrder(ArrayList<OrderDetailEntity> itemList, Connection connection);
    boolean updateOrder(OrderDetailEntity orderDetailEntity, Connection connection);
    boolean deleteOrder(String orderID,Connection connection);
}
