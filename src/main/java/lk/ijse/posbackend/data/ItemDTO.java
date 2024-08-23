package lk.ijse.posbackend.data;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ItemDTO {
    String itemCode;
    String name;
    String category;
    double unitPrice;
    double qty;
}
