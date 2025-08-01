package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmailSchedulerTest {
    @InjectMocks
    private EmailScheduler emailScheduler;

    @Mock
    private SimpleEmailService simpleEmailService;

    @Mock
    private AdminConfig adminConfig;

    @Mock
    private TaskRepository taskRepository;

    @Test
    void shouldWriteTaskWhenOneTask() {
        long taskCount = 1;

        when(taskRepository.count()).thenReturn(taskCount);
        when(adminConfig.getAdminMail()).thenReturn("admin@email.com");

        ArgumentCaptor<Mail> captor = ArgumentCaptor.forClass(Mail.class);

        emailScheduler.sendInformationEmail();

        verify(simpleEmailService).send(captor.capture());
    }

}