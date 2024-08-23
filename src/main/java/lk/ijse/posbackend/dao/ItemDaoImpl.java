package lk.ijse.posbackend.dao;

import lk.ijse.posbackend.data.CustomerDTO;
import lk.ijse.posbackend.entity.CustomerEntity;
import lk.ijse.posbackend.entity.ItemEntity;

import java.sql.Connection;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDao{

    @Override
    public CustomerDTO getItem(String itemCode, Connection connection) {
        return null;
    }

    @Override
    public ArrayList<ItemEntity> getItemList(Connection connection) {
        return null;
    }

    @Override
    public String saveItem(ItemEntity ItemEntity, Connection connection) {
        return null;
    }

    @Override
    public boolean updateItem(ItemEntity ItemEntity, Connection connection) {
        return false;
    }

    @Override
    public boolean deleteItem(String itemCode, Connection connection) {
        return false;
    }
}
