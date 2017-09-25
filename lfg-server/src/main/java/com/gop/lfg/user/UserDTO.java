package com.gop.lfg.user;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "users")
public class UserDTO {
    @Id
    private String login;
    private int version;

    private String email;
    private String password;
    private String salt;

    private String playerProfile;
}
