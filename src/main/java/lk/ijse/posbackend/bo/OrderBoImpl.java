package lk.ijse.posbackend.bo;

import lk.ijse.posbackend.dao.OrderDao;
import lk.ijse.posbackend.dao.OrderDaoImpl;
import lk.ijse.posbackend.data.OrderDTO;
import lk.ijse.posbackend.data.OrderDetailDTO;
import lk.ijse.posbackend.entity.OrderDetailEntity;
import lk.ijse.posbackend.entity.OrderEntity;

import java.sql.Connection;
import java.util.ArrayList;

public class OrderBoImpl implements OrderBo{
    OrderDao orderDao=new OrderDaoImpl();
    @Override
    public ArrayList<OrderDTO> getOrderList(Connection connection) {
        return null;
    }

    @Override
    public OrderDTO getOrder(String itemCode, Connection connection) {
        return null;
    }

    @Override
    public String saveOrder(OrderDTO orderDTO, Connection connection) {
        ArrayList<OrderDetailEntity> orderItemList = new ArrayList<>();
        for (OrderDetailDTO orderDetailDTO:orderDTO.get_itemListOrder()){
            orderItemList.add(new OrderDetailEntity(orderDetailDTO.get_itemCode(),orderDetailDTO.get_orderId(),orderDetailDTO.get_qty()));
        }
        String s = orderDao.saveOrder(new OrderEntity(orderDTO.get_customer(), orderDTO.get_date(), orderDTO.get_total(), orderItemList, orderDTO.getId()), connection);
        return s;
    }

    @Override
    public boolean updateOrder(OrderDTO OrderDTO, Connection connection) {
        return false;
    }

    @Override
    public boolean deleteOrder(String orderID, Connection connection) {
        return false;
    }
}
