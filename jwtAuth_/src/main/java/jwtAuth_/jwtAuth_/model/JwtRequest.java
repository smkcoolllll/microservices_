package jwtAuth_.jwtAuth_.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class JwtRequest {
    private  String email;
    private  String password;
}
