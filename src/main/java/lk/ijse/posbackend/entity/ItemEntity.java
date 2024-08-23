package lk.ijse.posbackend.entity;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ItemEntity {
    String itemCode;
    String name;
    String category;
    double unitPrice;
    double qty;

}
