package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class TrelloServiceTest {
    

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private SimpleEmailService emailService;

    @Mock
    private AdminConfig adminConfig;

    @InjectMocks
    private TrelloService trelloService;

    @Test
    void shouldFetchTrelloBoards() {

        List<TrelloBoardDto> mockBoards = List.of(
                new TrelloBoardDto("1", "Board", List.of())
        );
        when(trelloClient.getTrelloBoards()).thenReturn(mockBoards);

        List<TrelloBoardDto> result = trelloService.fetchTrelloBoards();

        assertEquals(1, result.size());
        assertEquals("1", result.get(0).getId());
        verify(trelloClient, times(1)).getTrelloBoards();
    }

    @Test
    void shouldCreateTrelloCardAndSendEmail() {
        TrelloCardDto cardDto = new TrelloCardDto("Card", "desc", "top", "123");
        CreatedTrelloCardDto createdCard = new CreatedTrelloCardDto("1", "Card", "http://url");

        when(trelloClient.createNewCard(cardDto)).thenReturn(createdCard);
        when(adminConfig.getAdminMail()).thenReturn("admin@example.com");

        CreatedTrelloCardDto result = trelloService.createdTrelloCard(cardDto);

        assertEquals("1", result.getId());
        verify(trelloClient).createNewCard(cardDto);
        verify(emailService).send(argThat(mail ->
                mail.getMailTo().equals("admin@example.com") &&
                        mail.getSubject().equals("Tasks: New Trello Card") &&
                        mail.getMessage().contains("New card: Card")
        ));
    }

    @Test
    void shouldNotSendEmailWhenCardIsNull() {

        TrelloCardDto cardDto = new TrelloCardDto("Card", "desc", "top", "123");

        when(trelloClient.createNewCard(cardDto)).thenReturn(null);

        CreatedTrelloCardDto result = trelloService.createdTrelloCard(cardDto);

        assertNull(result);
        verify(trelloClient).createNewCard(cardDto);
        verify(emailService, never()).send(any());
    }

}