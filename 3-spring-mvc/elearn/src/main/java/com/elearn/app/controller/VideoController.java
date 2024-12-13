package com.elearn.app.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elearn.app.service.VideoService;

import jakarta.validation.Valid;

import com.elearn.app.constants.AppConstants;
import com.elearn.app.dto.CustomMessage;
import com.elearn.app.dto.PageResponse;
import com.elearn.app.dto.VideoDto;
import com.elearn.app.entities.Video;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoController {

	private final VideoService videoService;

	public VideoController(VideoService videoService) {
		this.videoService = videoService;
	}

	@PostMapping
	public ResponseEntity<VideoDto> saveVideo(@RequestBody @Valid VideoDto videoDto) {
		VideoDto savedVideo = videoService.saveVideo(videoDto);
		return ResponseEntity.ok(savedVideo);
	}

	@GetMapping
	public ResponseEntity<PageResponse<VideoDto>> getAllVideos(
			@RequestParam(name = "page", defaultValue = AppConstants.VIDEO_DEFAULT_PAGE_NO) int pageNumber,
			@RequestParam(name = "size", defaultValue = AppConstants.VIDEO_DEFAULT_PAGE_SIZE) int pageSize,
			@RequestParam(name = "sort", defaultValue = AppConstants.VIDEO_DEFAULT_SORT_BY) String sortBy,
			@RequestParam(name = "dir", defaultValue = AppConstants.VIDEO_DEFAULT_SORT_DIR) String sortDirection

	) throws Exception {
		Sort sort = sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		PageRequest pageable = PageRequest.of(pageNumber, pageSize, sort);
		return ResponseEntity.ok(videoService.getAllVideos(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<VideoDto> getVideoById(@RequestParam("id") String videoId) throws Exception {
		return ResponseEntity.ok(videoService.getVideoById(videoId));
	}

	@PutMapping("/{id}")
	public ResponseEntity<VideoDto> updateVideo(@PathVariable("id") String videoId, @RequestBody VideoDto videoDto) throws Exception {
		return ResponseEntity.ok(videoService.updateVideo(videoId, videoDto));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<CustomMessage> deleteVideo(@RequestParam("id") String videoId) throws Exception {
		videoService.deleteVideoById(videoId);
		CustomMessage message = CustomMessage.builder().message("course deleted!")
				.details("video with id: " + videoId + " has been deleted!").success(true).build();
		return ResponseEntity.ok(message);
	}
}
