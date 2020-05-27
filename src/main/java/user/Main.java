package user;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        User user = User.builder()
                .name("Pelda Patrik")
                .username("PP")
                .password("asdasd")
                .email("test@test.com")
                .gender(User.Gender.MALE)
                .dob(LocalDate.parse("1999-01-01"))
                .enabled(true)
                .build();

        Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test");
        jdbi.installPlugin(new SqlObjectPlugin());

        try (Handle handle = jdbi.open()) {
            UserDao dao = handle.attach(UserDao.class);
            dao.createTable();
            dao.insertUser(user);
            dao.findById(1);
            dao.findByUsername("PP");
            dao.listUsers();
            dao.deleteUser(dao.findById(1).get());
        }
    }
}
