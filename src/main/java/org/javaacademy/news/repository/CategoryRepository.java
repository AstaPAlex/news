package org.javaacademy.news.repository;

import org.javaacademy.news.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository <Category, Long> {

    @Transactional(readOnly = true)
    Optional<Category> findFirstByName(String name);

    @Transactional(readOnly = true)
    List<Category> findAllByNewsList_Date(LocalDate date);

    @Transactional(readOnly = true)
    Optional<Category> findFirstByNewsList_DateAndName(LocalDate date, String nameCategory);

}
