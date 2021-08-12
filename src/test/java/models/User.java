package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String name;
    private String surname;
    private String email;
    private int id;
    private boolean isActive;
    private String username;
    private String password;
}
