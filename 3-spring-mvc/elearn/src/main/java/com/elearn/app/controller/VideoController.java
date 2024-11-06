package com.elearn.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
import com.elearn.app.dto.VideoDto;
import com.elearn.app.entities.Video;

@RestController
@RequestMapping("/video")
public class VideoController {

	private final ModelMapper modelMapper;
	private final VideoService videoService;

	public VideoController(ModelMapper modelMapper, VideoService videoService) {
		this.modelMapper = modelMapper;
		this.videoService = videoService;
	}

	@PostMapping
	public ResponseEntity<VideoDto> saveVideo(@RequestBody Video video) {
		Video savedVid = videoService.saveVideo(video);
		VideoDto vid = modelMapper.map(savedVid, VideoDto.class);
		return ResponseEntity.ok(vid);
	}

	@GetMapping
	public ResponseEntity<List<VideoDto>> getAllVideos() {
		List<Video> videoList = videoService.getAllVideos();
		List<VideoDto> videoDtoList = videoList.stream().map(vid -> modelMapper.map(vid, VideoDto.class))
				.collect(Collectors.toList());
		return ResponseEntity.ok(videoDtoList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<VideoDto> getVideoById(@RequestParam("id") String videoId) throws Exception {
		Video vid = videoService.getVideoById(videoId); 
		return ResponseEntity.ok(modelMapper.map(vid, VideoDto.class));
	}

	@PutMapping
	public ResponseEntity<VideoDto> updateVideo(@RequestBody Video video) {
		Video vid = videoService.updateVideo(video); 
		return ResponseEntity.ok(modelMapper.map(vid, VideoDto.class));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> updateVideo(@RequestParam("id") String videoId) {
		return ResponseEntity.ok(videoService.deleteVideoById(videoId));
	}
}