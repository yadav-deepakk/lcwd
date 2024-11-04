package com.elearn.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elearn.app.service.VideoService;
import com.elearn.app.entities.Video;

@RestController
@RequestMapping("/video")
public class VideoController {
	
	private final VideoService videoService;

	public VideoController(VideoService videoService) {
		this.videoService = videoService;
	}

	@PostMapping
	public ResponseEntity<Video> saveVideo(@RequestBody Video video) {
		return ResponseEntity.ok(videoService.saveVideo(video));
	}

	@GetMapping
	public ResponseEntity<List<Video>> getAllVideos() {
		return ResponseEntity.ok(videoService.getAllVideos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Video> getVideoById(@RequestParam("id") String videoId) throws Exception {
		return ResponseEntity.ok(videoService.getVideoById(videoId));
	}

	@PutMapping
	public ResponseEntity<Video> updateVideo(@RequestBody Video video) {
		return ResponseEntity.ok(videoService.updateVideo(video));
	}

	@DeleteMapping("{id")
	public ResponseEntity<Boolean> updateVideo(@RequestParam("id") String videoId) {
		return ResponseEntity.ok(videoService.deleteVideoById(videoId));
	}
}
