package com.elearn.app.service;

import org.springframework.data.domain.Pageable;

import com.elearn.app.dto.PageResponse;
import com.elearn.app.dto.VideoDto;
import com.elearn.app.exception.ResourceNotFoundException;

public interface VideoService {
	// C - Create
	VideoDto saveVideo(VideoDto videoDto);

	// R - Read
	PageResponse<VideoDto> getAllVideos(Pageable pageable);
	VideoDto getVideoById(String id) throws ResourceNotFoundException, Exception;

	// U - Update
	VideoDto updateVideo(String id, VideoDto video) throws ResourceNotFoundException, Exception;

	// D - Delete
	void deleteVideoById(String id) throws ResourceNotFoundException, Exception;

}
