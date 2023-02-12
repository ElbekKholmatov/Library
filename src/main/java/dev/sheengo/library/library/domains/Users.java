package dev.sheengo.library.library.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String role;
    private Boolean active;
}
