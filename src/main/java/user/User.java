package user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {

    public static enum Gender {
        FEMALE,
        MALE
    }

    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private Gender gender;
    private LocalDate dob;
    private boolean enabled;

    public User (){
    }

    public User (Long id, String username, String password, String name, String email, Gender gender, LocalDate dob, boolean enabled)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.enabled = enabled;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username +
                ", password=" + password +
                ", name=" + name +
                ", email=" + email +
                ", gender=" + gender +
                ", dob=" + dob +
                ", enabled=" + enabled +
                '}';
    }

}
