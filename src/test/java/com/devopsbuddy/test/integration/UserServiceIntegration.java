package com.devopsbuddy.test.integration;

import com.devopsbuddy.backend.persistence.domain.backend.Role;
import com.devopsbuddy.backend.persistence.domain.backend.User;
import com.devopsbuddy.backend.persistence.domain.backend.UserRole;
import com.devopsbuddy.backend.service.UserService;
import com.devopsbuddy.enums.PlansEnum;
import com.devopsbuddy.enums.RolesEnum;
import com.devopsbuddy.utils.UserUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceIntegration {

    @Autowired
    private UserService userService;


    @Test
    public void testCreateUser() {
        Set<UserRole> userRoles = new HashSet<UserRole>();

        User basicUser = UserUtils.createBasicUser("richard","aaa@mmmm.com");
        userRoles.add(new UserRole(basicUser,new Role(RolesEnum.BASIC)));
        User user = userService.createUser(basicUser, PlansEnum.BASIC,userRoles);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());


    }

}
