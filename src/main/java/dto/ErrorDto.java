package dto;

import lombok.*;

//{
//        "message": "Wrong email format! Example: name@mail.com",
//        "details": "uri=/api/login",
//        "code": 400,
//        "timestamp": "2022-05-27T07:11:15.480+0000"
//        }
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class ErrorDto {
    String message;
    String details;
    int code;

}
