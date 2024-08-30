package lk.ijse.posbackend.dao;

import lk.ijse.posbackend.entity.OrderEntity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDaoImpl implements OrderDao {
    OrderDetailDao orderDetailDao=new OrderDetailDaoImpl();
    @Override
    public ArrayList<OrderEntity> getOrderList(Connection connection) {
        return null;
    }

    @Override
    public OrderEntity getOrder(String itemCode, Connection connection) {
        return null;
    }

    @Override
    public String saveOrder(OrderEntity orderEntity, Connection connection) {
        String save_statement = "INSERT INTO orders VALUES (?,?,?,?,?,?)";
        int i = 0;

        try {
            System.out.println(orderEntity);
            boolean save = orderDetailDao.saveOrder(orderEntity.get_itemListOrder(), connection);
            if (save){
                PreparedStatement preparedStatement = connection.prepareStatement(save_statement);
                preparedStatement.setString(1,orderEntity.getId());
                preparedStatement.setString(2, orderEntity.get_customer());
                preparedStatement.setDouble(3, orderEntity.get_total());
                preparedStatement.setDate(4, Date.valueOf(orderEntity.get_date()));
                i = preparedStatement.executeUpdate();
                if (i > 0) {
                    return "Saved";
                }
                else {
                    return "error";
                }
            }
            else {
                return "error";
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }

    @Override
    public boolean updateOrder(OrderEntity oderEntity, Connection connection) {
        return false;
    }

    @Override
    public boolean deleteOrder(String orderID, Connection connection) {
        return false;
    }
}
