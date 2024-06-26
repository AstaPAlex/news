package org.javaacademy.news.mapper;

import org.javaacademy.news.dto.NewsDto;
import org.javaacademy.news.dto.NewsDtoRs;
import org.javaacademy.news.entity.Category;
import org.javaacademy.news.entity.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NewsMapper {

    @Mapping(target = "category", source = "nameCategory", qualifiedByName = "getCategory")
    News convertToEntity(NewsDto dto);

    @Named("getCategory")
    default Category getCategory(String nameCategory) {
        return Category.builder().name(nameCategory).build();
    }

    List<NewsDtoRs> convertToDto(List<News> entities);
}
