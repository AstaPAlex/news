package org.javaacademy.news.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.news.dto.NewsDto;
import org.javaacademy.news.dto.NewsDtoRs;
import org.javaacademy.news.dto.NewsListByDateDto;
import org.javaacademy.news.service.NewsService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {
    private final NewsService newsService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void createNews(@RequestBody NewsDto newsDto) {
        newsService.createNews(newsDto);
    }

    @GetMapping("/today")
    @ResponseStatus(OK)
    public NewsListByDateDto getNewsToday() {
        return newsService.getNewsByDate(LocalDate.now());
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<NewsDtoRs> getNewsByDateAndByCategory(@RequestParam LocalDate date,
                                                      @RequestParam String nameCategory) {
        return newsService.getNewsByDateAndByCategory(date, nameCategory);
    }
}
