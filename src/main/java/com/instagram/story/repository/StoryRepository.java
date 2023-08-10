package com.instagram.story.repository;

import com.instagram.story.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface StoryRepository extends JpaRepository<Story,Long> {

    List<Story> findByUserId(long uid);
    List<Story> findByDateBefore(Date date);
}
