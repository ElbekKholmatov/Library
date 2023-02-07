package com.example.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categories {
    private long id;
    private String name;
    private String description;
    private boolean active;
    private boolean isDeleted;
    private Date createdAt;
    private Date updatedAt;

}
