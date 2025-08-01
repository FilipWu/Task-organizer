package com.crud.tasks.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminConfigTest {
    @Autowired
    private AdminConfig adminConfig;

    @Test
    void getAdminMail() {
        assertNotNull(adminConfig.getAdminMail());
    }
}