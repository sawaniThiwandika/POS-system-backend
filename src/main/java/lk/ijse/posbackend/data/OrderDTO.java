package lk.ijse.posbackend.data;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class OrderDTO {

     String _customer;
     LocalDate _date;
     double _total;
     ArrayList<OrderDetailDTO> _itemListOrder;
     String id;

}
