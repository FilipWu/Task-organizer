package com.crud.tasks;

import com.crud.tasks.avg.Average;
import com.crud.tasks.domain.TaskDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TasksApplication {

	public static void main(String[] args) {
		TaskDto taskDto = new TaskDto(
				(long) 1,
				"Test title",
				"i want to be a coder!");
		Long id = taskDto.getId();
		String title = taskDto.getTitle();;
		String content = taskDto.getContent();

//		List<Integer> oceny = List.of(3, 1, 1, 5, 6, 4);
//		List<Integer> wagi = List.of(4, 6, 8, 4, 4, 10);
//
//		Average average = new Average();
//
//		double wynik = average.average(oceny,wagi);
//
//		System.out.println(wynik);

		System.out.println(id + " " + title + " " + content);
		SpringApplication.run(TasksApplication.class, args);
	}

}
