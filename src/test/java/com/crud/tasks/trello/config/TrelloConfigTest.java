package com.crud.tasks.trello.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TrelloConfigTest {

    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    void getTrelloConfig() {
        assertNotNull(trelloConfig.getTrelloApiEndpoint());
        assertNotNull(trelloConfig.getTrelloToken());
        assertNotNull(trelloConfig.getTrelloUser());
        assertNotNull(trelloConfig.getTrelloAppKey());

    }


}