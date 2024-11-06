package com.elearn.app.service;

import java.util.List;

import com.elearn.app.entities.Video;

public interface VideoService {
	// C - Create
	Video saveVideo(Video video);

	// R - Read
	List<Video> getAllVideos();
	Video getVideoById(String id) throws Exception;

	// U - Update
	Video updateVideo(Video video);

	// D - Delete
	boolean deleteVideoById(String id);
	boolean deleteVideo(Video video);
}
