package lk.ijse.posbackend.bo;

import lk.ijse.posbackend.data.ItemDTO;
import lk.ijse.posbackend.data.OrderDTO;

import java.sql.Connection;
import java.util.ArrayList;

public interface OrderBo {
    ArrayList<OrderDTO> getOrderList(Connection connection);
    OrderDTO getOrder(String itemCode, Connection connection);
    String saveOrder(OrderDTO orderDTO, Connection connection);
    boolean updateOrder(OrderDTO OrderDTO, Connection connection);
    boolean deleteOrder(String orderID,Connection connection);
}
