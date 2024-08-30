package lk.ijse.posbackend.entity;

import lk.ijse.posbackend.data.OrderDetailDTO;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class OrderEntity {
    String _customer;
    LocalDate _date;
    double _total;
    ArrayList<OrderDetailEntity> _itemListOrder;
    String id;
}
