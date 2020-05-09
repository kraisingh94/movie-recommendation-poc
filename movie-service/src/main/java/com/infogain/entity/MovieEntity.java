package com.infogain.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.infogain.dto.MovieDTO;


@Entity
@Table(name = "movie")
public class MovieEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(name = "movie_name", length = 50, nullable = false)
    private String name;
    
    @CreatedDate
    private Date createdDate;
    
    public MovieEntity() {
    }
    
    public MovieDTO toDTO(){
        return new MovieDTO(this);
    }
    
    public MovieEntity(String name) {
        this.name = name;
        this.createdDate = new Date();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
}   
