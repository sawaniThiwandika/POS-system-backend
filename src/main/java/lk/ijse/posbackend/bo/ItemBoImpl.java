package lk.ijse.posbackend.bo;

import lk.ijse.posbackend.dao.ItemDao;
import lk.ijse.posbackend.dao.ItemDaoImpl;
import lk.ijse.posbackend.data.CustomerDTO;
import lk.ijse.posbackend.data.ItemDTO;
import lk.ijse.posbackend.entity.CustomerEntity;
import lk.ijse.posbackend.entity.ItemEntity;

import java.sql.Connection;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {
    ItemDao itemDao=new ItemDaoImpl();
    @Override
    public ArrayList<ItemDTO> getItemList(Connection connection) {
        ArrayList<ItemDTO> itemDTOArrayList = new ArrayList<>();
        ArrayList<ItemEntity> itemList = itemDao.getItemList(connection);
        for (ItemEntity item:itemList) {
            itemDTOArrayList.add(new ItemDTO(item.getItemCode(),item.getName(),item.getCategory(),
                    item.getUnitPrice(),item.getQty()));

        }
        return itemDTOArrayList;
    }

    @Override
    public ItemDTO getItem(String itemCode, Connection connection) {
        return null;
    }

    @Override
    public String saveItem(ItemDTO itemDTO, Connection connection) {
        System.out.println("Im in bo "+itemDTO);
        ItemEntity itemEntity = new ItemEntity(itemDTO.getItemCode(), itemDTO.getName(), itemDTO.getCategory(),
                itemDTO.getUnitPrice(), itemDTO.getUnitPrice());
        String s = itemDao.saveItem(itemEntity, connection);
        return s;
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO, Connection connection) {
        System.out.println("Im in bo "+itemDTO);
        ItemEntity itemEntity = new ItemEntity(itemDTO.getItemCode(), itemDTO.getName(), itemDTO.getCategory(),
                itemDTO.getUnitPrice(), itemDTO.getUnitPrice());
        boolean s = itemDao.updateItem(itemEntity, connection);
        return s;
    }

    @Override
    public boolean deleteItem(String itemCode, Connection connection) {
        System.out.println("Im in bo "+itemCode);
        boolean s = itemDao.deleteItem(itemCode, connection);
        return s;
    }
}
