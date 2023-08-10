package com.instagram.story.service;

import com.instagram.story.dto.AddStoryDto;
import com.instagram.story.model.Story;
import com.instagram.story.repository.StoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class StoryService {
    private final StoryRepository storyRepository;

    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public List<Story> getAllStories() {
        return storyRepository.findAll();
    }

    public List<Story> getUserStories(long userid) {
        return storyRepository.findByUserId(userid);
    }
    public Optional<Story> getStoryById(long id) {
        return storyRepository.findById(id);
    }

    public Story addStory(AddStoryDto storydto){
        Story story = Story.builder()
                .userId(storydto.getUserId())
                .date(storydto.getDate())
                .storyImg(storydto.getStoryImg())
                .build();
        log.info("User {} added a Story", storydto.getUserId());
        return storyRepository.save(story);
    }

    /**
     * The method is scheduled to run every hour
     */
    @Scheduled(fixedRate = 60 * 60 * 1000) // Run every hour
    public void deleteExpiredStories() {
        /**
         *  Calculate the date and time 24 hours ago
          */

        Date twentyFourHoursAgo = new Date(System.currentTimeMillis() - (24 * 60 * 60 * 1000));

        /**
         *  Query the database for expired stories
          */

        List<Story> expiredStories = storyRepository.findByDateBefore(twentyFourHoursAgo);

        /**
         * Delete the expired stories
         */
        storyRepository.deleteAll(expiredStories);
    }

    public void deleteStory(long id) {
        storyRepository.deleteById(id);
    }
}
