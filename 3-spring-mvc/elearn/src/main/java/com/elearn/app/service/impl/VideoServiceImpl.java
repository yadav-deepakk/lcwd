package com.elearn.app.service.impl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elearn.app.dto.PageResponse;
import com.elearn.app.dto.VideoDto;
import com.elearn.app.entities.Video;
import com.elearn.app.exception.ResourceNotFoundException;
import com.elearn.app.repository.VideoRepo;
import com.elearn.app.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {

	private final ModelMapper modelMapper;
	private final VideoRepo videoRepo;

	public VideoServiceImpl(ModelMapper modelMapper, VideoRepo videoRepo) {
		this.modelMapper = modelMapper;
		this.videoRepo = videoRepo;
	}

	@Override
	public VideoDto saveVideo(VideoDto videoDto) {
		Video vid = modelMapper.map(videoDto, Video.class);
		vid.setUploadedAt(new Date());
		Video savedVideo = videoRepo.save(vid);
		return modelMapper.map(savedVideo, VideoDto.class);
	}

	@Override
	public PageResponse<VideoDto> getAllVideos(Pageable pageable) {
		Page<Video> videoPage = videoRepo.findAll(pageable);
		PageResponse<VideoDto> response = PageResponse.<VideoDto>builder().pageNumber(videoPage.getNumber())
				.pageSize(videoPage.getSize()).totalElements(videoPage.getTotalElements())
				.totalPages(videoPage.getTotalPages())
				.content(videoPage.getContent().stream().map(vid -> modelMapper.map(vid, VideoDto.class)).toList())
				.build();
		return response;
	}

	@Override
	public VideoDto getVideoById(String id) throws ResourceNotFoundException, Exception {
		Video v = videoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Such video."));
		return modelMapper.map(v, VideoDto.class);
	}

	@Override
	public VideoDto updateVideo(String id, VideoDto videoDto) throws ResourceNotFoundException, Exception {
		Video vid = videoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Such video to update the details."));
		
		vid.setTitle(videoDto.getTitle());

//		private String id;
//		private String title;
//		private String filePath;  
//		private Date uploadedAt;
//	    private String contentType;
		
		videoRepo.save(vid); 
		return modelMapper.map(vid, VideoDto.class);
	}

	@Override
	public void deleteVideoById(String id) throws ResourceNotFoundException, Exception {
		Video v = videoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Such video to delete."));
		videoRepo.delete(v);
	}

}
