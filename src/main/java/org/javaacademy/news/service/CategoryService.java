package org.javaacademy.news.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.news.entity.Category;
import org.javaacademy.news.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> getOptionalCategoryByName(String name) {
        return categoryRepository.findFirstByName(name);
    }

    public Category getCategoryByNameAndDate(LocalDate date, String name) {
        return categoryRepository.findFirstByNewsList_DateAndName(date, name).orElseThrow();
    }

    public List<Category> getAllCategoryByDate(LocalDate date) {
        return categoryRepository.findAllByNewsList_Date(date);
    }

}
