package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloCardDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrelloMapperTest {
    private final TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    void mapToCardDto() {
        TrelloCard card = new TrelloCard("Name", "Desc", "top", "123");

        TrelloCardDto cardDto = trelloMapper.mapToCardDto(card);

        assertEquals(cardDto.getName(), card.getName());
        assertEquals(cardDto.getDescription(), card.getDescription());
        assertEquals("top",cardDto.getPos());
    }

    @Test
    void mapToCard() {
        TrelloCardDto cardDto = new TrelloCardDto("Name", "Desc", "top", "123");

        TrelloCard card = trelloMapper.mapToCard(cardDto);

        assertEquals(card.getName(), cardDto.getName());
        assertEquals(card.getDescription(), cardDto.getDescription());
        assertEquals("top",card.getPos());
    }
}