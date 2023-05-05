package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class UserRegisterResponse {

    private Integer id;

    private String token;
}