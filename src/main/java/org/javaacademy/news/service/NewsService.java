package org.javaacademy.news.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.news.dto.CategoryDto;
import org.javaacademy.news.dto.NewsDto;
import org.javaacademy.news.dto.NewsDtoRs;
import org.javaacademy.news.dto.NewsListByDateDto;
import org.javaacademy.news.entity.Category;
import org.javaacademy.news.entity.News;
import org.javaacademy.news.mapper.CategoryMapper;
import org.javaacademy.news.mapper.NewsMapper;
import org.javaacademy.news.repository.NewsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;
    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    @Transactional
    public void createNews(NewsDto newsDto) {
        News news = newsMapper.convertToEntity(newsDto);
        Optional<Category> category = categoryService.getOptionalCategoryByName(newsDto.getNameCategory());
        if (category.isPresent()) {
            news.setCategory(category.orElseThrow());
        }
        newsRepository.save(news);
    }

    @Transactional
    public NewsListByDateDto getNewsByDate(LocalDate date) {
        NewsListByDateDto newsListByDateDto = new NewsListByDateDto(date);
        List<CategoryDto> listNewsByDate = getCategoryByDate(LocalDate.now());
        newsListByDateDto.setCategoryDtoList(listNewsByDate);
        return newsListByDateDto;
    }

    @Transactional
    public List<NewsDtoRs> getNewsByDateAndByCategory(LocalDate date, String nameCategory) {
        Category category = categoryService.getCategoryByNameAndDate(date, nameCategory);
        return newsMapper.convertToDto(category.getNewsList());
    }

    private List<CategoryDto> getCategoryByDate(LocalDate date) {
        return categoryService.getAllCategoryByDate(date).stream()
                .map(categoryMapper::convertToDto)
                .toList();
    }
}
