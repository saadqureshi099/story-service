package com.instagram.story.controller;

import com.instagram.story.dto.AddStoryDto;

import com.instagram.story.model.Story;
import com.instagram.story.service.StoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/story")
public class StoryController {
    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }
    @GetMapping("/stories")
    public List<Story> getStories(){
        return storyService.getAllStories();
    }
    @GetMapping("/{id}")
    public Optional<Story> getStory(@PathVariable long id){
        return storyService.getStoryById(id);
    }
    @GetMapping("/stories/{userid}")
    public List<Story> getUserStories(@PathVariable long userid){
        return storyService.getUserStories(userid);
    }
    @PostMapping("/addStory")
    public Story addStory(@RequestBody AddStoryDto storydto){
        return storyService.addStory(storydto);
    }
    @DeleteMapping("/{id}")
    public void deleteStory(@PathVariable long id){
        storyService.deleteStory(id);
    }
}
