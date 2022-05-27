package dto;
// "address": "string",
//         "description": "string",
//         "email": "string",
//         "id": 0,
//         "lastName": "string",
//         "name": "string",
//         "phone": "string"

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class ContactDto {

    String address;
    String description;
    String email;
    String lastName;
    String name;
    String phone;
    int id;
}
