package com.occ.namescore.rest;

import java.nio.file.Path;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.occ.namescore.NameScoreContext;
import com.occ.namescore.inputprocess.InputProcessor;
import com.occ.namescore.strategy.NameScoreStrategy;

@RestController
public class FileController {

    private FileStorageService fileStorageService;
    private InputProcessor processor;
    private NameScoreStrategy strategy;

    
    public FileController(FileStorageService fileStorageService, InputProcessor processor, NameScoreStrategy strategy) {
		this.fileStorageService = fileStorageService;
		this.processor = processor;
		this.strategy = strategy;
	}

	@PostMapping("/uploadFile")
    public int uploadFile(@RequestParam("file") MultipartFile file) {
        Path path = fileStorageService.storeFile(file);
        return new NameScoreContext(processor, strategy).computeNameScore(path.toFile());
    }
	
	@ExceptionHandler(FileStorageException.class)
	public ResponseEntity<?> handleStorageFileNotFound(FileStorageException ex) {
		return ResponseEntity.status(500).build();
	}
}
