package lk.ijse.posbackend.entity;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class CustomerEntity implements Serializable {
String cusId;
String name;
String email;
String address;
String contact;
LocalDate date;


}
