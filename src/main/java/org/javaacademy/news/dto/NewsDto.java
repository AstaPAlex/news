package org.javaacademy.news.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    private String headLine;
    private String nameCategory;
    private LocalDate date;
    private String text;

}
