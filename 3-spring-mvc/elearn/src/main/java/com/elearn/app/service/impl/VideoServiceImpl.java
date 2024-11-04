package com.elearn.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.elearn.app.entities.Video;
import com.elearn.app.exception.ResourceNotFoundException;
import com.elearn.app.repository.VideoRepo;
import com.elearn.app.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {

	private final VideoRepo videoRepo;

	public VideoServiceImpl(VideoRepo videoRepo) {
		this.videoRepo = videoRepo;
	}

	@Override
	public Video saveVideo(Video video) {
		return videoRepo.save(video);
	}

	@Override
	public List<Video> getAllVideos() {
		return videoRepo.findAll();
	}

	@Override
	public Video getVideoById(String id) throws Exception {
		return videoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Such video found!"));
	}

	@Override
	public Video updateVideo(Video video) {
		return videoRepo.save(video);
	}

	@Override
	public boolean deleteVideoById(String id) {
		videoRepo.deleteById(id);
		return videoRepo.findById(id).isEmpty();
	}

	@Override
	public boolean deleteVideo(Video video) {
		videoRepo.delete(video);
		return videoRepo.findById(video.getId()).isEmpty();
	}
}
