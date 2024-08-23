package lk.ijse.posbackend.dao;

import lk.ijse.posbackend.data.CustomerDTO;
import lk.ijse.posbackend.entity.CustomerEntity;
import lk.ijse.posbackend.entity.ItemEntity;

import java.sql.Connection;
import java.util.ArrayList;

public interface ItemDao {
    CustomerDTO getItem(String itemCode, Connection connection);
    ArrayList<ItemEntity> getItemList(Connection connection);
    String saveItem(ItemEntity ItemEntity, Connection connection);
    boolean updateItem(ItemEntity ItemEntity, Connection connection);
    boolean deleteItem(String itemCode,Connection connection);
}
