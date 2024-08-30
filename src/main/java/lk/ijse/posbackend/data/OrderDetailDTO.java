package lk.ijse.posbackend.data;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class OrderDetailDTO {
    String _orderId;
    String _itemCode;
    int _qty;
    double _unitPrice;
    double _total;
    String _itemName;
}
