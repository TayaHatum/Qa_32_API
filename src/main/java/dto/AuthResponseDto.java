package dto;

import lombok.*;

//{
//        "token": "string"
//        }
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class AuthResponseDto {
    String token;

}
