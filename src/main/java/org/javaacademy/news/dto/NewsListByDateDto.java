package org.javaacademy.news.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@RequiredArgsConstructor
public class NewsListByDateDto {
    private final LocalDate date;
    private List<CategoryDto> categoryDtoList;
}
