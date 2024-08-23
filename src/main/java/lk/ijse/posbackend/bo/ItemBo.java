package lk.ijse.posbackend.bo;

import lk.ijse.posbackend.data.CustomerDTO;
import lk.ijse.posbackend.data.ItemDTO;

import java.sql.Connection;
import java.util.ArrayList;

public interface ItemBo {
    ArrayList<ItemDTO> getItemList(Connection connection);
    ItemDTO getItem(String itemCode, Connection connection);
    String saveItem(ItemDTO ItemDTO, Connection connection);
    boolean updateItem(ItemDTO ItemDTO, Connection connection);
    boolean deleteItem(String itemCode,Connection connection);
}
