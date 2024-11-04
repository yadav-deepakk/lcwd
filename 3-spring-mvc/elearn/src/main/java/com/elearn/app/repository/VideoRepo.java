package com.elearn.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elearn.app.entities.Video;

@Repository
public interface VideoRepo extends JpaRepository<Video, String> {

}
