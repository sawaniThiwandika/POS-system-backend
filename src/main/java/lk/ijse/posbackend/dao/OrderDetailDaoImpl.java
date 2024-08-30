package lk.ijse.posbackend.dao;

import lk.ijse.posbackend.entity.OrderDetailEntity;

import java.sql.Connection;
import java.util.ArrayList;

public class OrderDetailDaoImpl implements OrderDetailDao{
    @Override
    public ArrayList<OrderDetailEntity> getOrderList(Connection connection) {
        return null;
    }

    @Override
    public OrderDetailEntity getOrder(String itemCode, Connection connection) {
        return null;
    }

    @Override
    public boolean saveOrder(ArrayList<OrderDetailEntity> itemList, Connection connection) {
        return true;
    }

    @Override
    public boolean updateOrder(OrderDetailEntity orderDetailEntity, Connection connection) {
        return false;
    }

    @Override
    public boolean deleteOrder(String orderID, Connection connection) {
        return false;
    }
}
