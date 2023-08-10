package com.instagram.story.dto;

import lombok.Builder;
import lombok.Data;


import java.util.Date;

@Data
@Builder
public class StoryDto {
    private long id;
    private Date date;
    private long userId;
    private String storyImg;
}
