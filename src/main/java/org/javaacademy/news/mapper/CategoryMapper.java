package org.javaacademy.news.mapper;

import org.javaacademy.news.dto.CategoryDto;
import org.javaacademy.news.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {NewsMapper.class})
public interface CategoryMapper {

    @Mapping(target = "newsListDto", source = "newsList")
    CategoryDto convertToDto(Category entity);

}
