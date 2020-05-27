package user;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(User.class)
public interface UserDao {

    @SqlUpdate("""
        CREATE TABLE User (
            id IDENTITY PRIMARY KEY,
            username VARCHAR2 NOT NULL,
            password VARCHAR2 NOT NULL,
            name VARCHAR2 NOT NULL,
            email VARCHAR2 NOT NULL,
            gender VARCHAR2 NOT NULL,
            dob DATE NOT NULL,
            enabled BOOLEAN NOT NULL,
        )
        """
    )

    void createTable();

    @SqlUpdate("INSERT INTO User (id, username, password, name, email, gender, dob, enabled) VALUES (:id, :username, :password, :name, :email, :gender, :dob, :enabled)")
    @GetGeneratedKeys
    long insertUser(@Bind("id") long id, @Bind("username") String username, @Bind("password") String password, @Bind("name") String name, @Bind("email") String email, @Bind("gender") String gender, @Bind("dob") Date dob, @Bind("enabled") Boolean enabled);

    @SqlUpdate("INSERT INTO User (id, username, password, name, email, gender, dob, enabled) VALUES (:id, :username, :password, :name, :email, :gender, :dob, :enabled)")
    @GetGeneratedKeys
    long insertUser(@BindBean User User);

    @SqlQuery("SELECT * FROM user WHERE id = :id")
    Optional<User> findById(@Bind("id") long id);

    @SqlQuery("SELECT * FROM user WHERE username = :username")
    Optional<User> findByUsername(@Bind("username") String username);

    @SqlQuery("SELECT * FROM user ORDER BY username")
    List<User> listUsers();

    @SqlQuery("DELETE FROM User WHERE user = :user")
    void deleteUser(@Bind("User") User user);




}
