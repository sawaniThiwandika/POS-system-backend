package lk.ijse.posbackend.entity;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class OrderDetailEntity {
String itemCode;
String orderID;
int count;

}
