package lk.ijse.posbackend.data;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ItemDTO {
    String _itemCode;
    double _unitPrice;
    String _category;
    String _itemName;
    double _itemQty;
}
