package lk.ijse.posbackend.dao;

import lk.ijse.posbackend.data.CustomerDTO;
import lk.ijse.posbackend.entity.ItemEntity;

import java.sql.*;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDao{

    @Override
    public CustomerDTO getItem(String itemCode, Connection connection) {
        return null;
    }

    @Override
    public ArrayList<ItemEntity> getItemList(Connection connection) {
        String getItemsStatement = "SELECT * FROM item";
        ArrayList<ItemEntity> itemEntities = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getItemsStatement);
            ResultSet resultSet = null;
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                itemEntities.add(new ItemEntity(
                        resultSet.getString("item_code"),
                        resultSet.getString("name"),
                        resultSet.getString("category"),
                        resultSet.getDouble("unitPrice"),
                        resultSet.getDouble("qty")

                ));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //System.out.println();
        return itemEntities;
    }

    @Override
    public String saveItem(ItemEntity itemEntity, Connection connection) {
        int i = 0;
        String save_statement = "INSERT INTO item VALUES (?,?,?,?,?,?)";
        try {
            System.out.println(itemEntity);

            PreparedStatement preparedStatement = connection.prepareStatement(save_statement);
            preparedStatement.setString(1, itemEntity.getItemCode());
            preparedStatement.setString(2, itemEntity.getName());
            preparedStatement.setString(3, itemEntity.getCategory());
            preparedStatement.setDouble(4, itemEntity.getUnitPrice());
            preparedStatement.setDouble(5, itemEntity.getQty());

            i = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (i > 0) {
            return "Saved";
        } else {
            return "error";
        }

    }

    @Override
    public boolean updateItem(ItemEntity itemEntity, Connection connection) {
        int rowsAffected = 0;

        String updateCustomerQuery = "UPDATE item SET name = ?, category = ?, unitPrice= ?, qty = ? WHERE item_code= ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateCustomerQuery)) {
            preparedStatement.setString(1, itemEntity.getName());
            preparedStatement.setString(2, itemEntity.getCategory());
            preparedStatement.setDouble(3, itemEntity.getUnitPrice());
            preparedStatement.setDouble(4, itemEntity.getQty());
            preparedStatement.setDate(5, Date.valueOf(itemEntity.getItemCode()));


            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Log the exception message
            e.printStackTrace(); // or use a logging framework
            throw new RuntimeException("Error updating item", e);
        }

        return rowsAffected > 0;
    }

    @Override
    public boolean deleteItem(String itemCode, Connection connection) {
        int rowsAffected = 0;

        // Correct SQL DELETE query with table name
        String deleteItemQuery = "DELETE FROM item WHERE item_code = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteItemQuery)) {
            // Set the parameter for the query
            preparedStatement.setString(1, itemCode);

            // Execute the update and get the number of rows affected
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Log the exception message
            e.printStackTrace(); // or use a logging framework
            throw new RuntimeException("Error deleting item", e);
        }

        // Return true if at least one row was affected, otherwise false
        return rowsAffected > 0;
    }
}
