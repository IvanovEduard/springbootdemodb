package com.example.demodb.controller;

import com.example.demodb.entities.User;
import com.example.demodb.entities.UserRO;
import com.example.demodb.repository.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by Eduard Ivanov on 7/1/21
 */
@RestController
public class DBController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserService userService;
    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @RequestMapping("/insert")
    public User insert() {
//        jdbcTemplate.execute("insert into user(name,email) values('ivan','ivan@gmail.com')");
+*-7777        User user = new User();
        user.setEmail("email");
        user.setName("Ivan");
        long save = userService.save(user);

//        String name1 = jdbcTemplate.queryForObject("SELECT u.name as name FROM user u WHERE u.id = 11", ((rs, rowNum) -> rs.getString("name")));
//        String name = userService.getName(save);
        return user;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestBody UserRO userRO) {
//        jdbcTemplate.execute("insert into user(name,email) values('ivan','ivan@gmail.com')");
        User user = new User();
        user.setEmail(userRO.getEmail());
        user.setName(userRO.getName());
        long save = userService.save(user);
        String name = userService.getName(save);
        return "success!" + save;
    }


    @RequestMapping(value = "/inputParams", method = RequestMethod.GET)
    public String inputParams(
            @RequestParam(value = "value") String value,
            @RequestParam(value = "array", required = false) String[] arrValues,
            @RequestParam(value = "list3", required = false) List<String> listValues) {
        return "success!";
    }
}
