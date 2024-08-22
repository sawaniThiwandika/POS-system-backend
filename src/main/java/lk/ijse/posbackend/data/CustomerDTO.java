package lk.ijse.posbackend.data;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
@ToString
public class CustomerDTO implements Serializable {
String _cusId;
String _cusName;
String _cusEmail;
String _cusAddress;
String _cusContact;
LocalDate _addCusDate;


    public CustomerDTO(String string) {

    }


}
