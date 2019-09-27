package ru.solon4ak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.solon4ak.model.User;
import ru.solon4ak.model.UserRoles;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class DBInit {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder encoder;

    @PostConstruct
    public void initDB() {
        User user = new User(
                "Marcy",
                "Gray",
                "marcy@",
                "",
                "",
                new Date(new GregorianCalendar(1977, Calendar.OCTOBER, 6).getTime().getTime()),
                "mc",
                encoder.encode("marcy")
        );
        user.setRole(UserRoles.valueOf("ADMIN").name());
        userService.save(user);

        user = new User(
                "Henry",
                "Moore",
                "henry@",
                "",
                "",
                new Date(new GregorianCalendar(1998, Calendar.JUNE, 25).getTime().getTime()),
                "henry",
                encoder.encode("henry")
        );
        user.setRole(UserRoles.valueOf("USER").name());
        userService.save(user);
    }
}
