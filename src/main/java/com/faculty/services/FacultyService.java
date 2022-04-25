package com.faculty.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FacultyService {

	public void saveFile(MultipartFile file, Path path) {

		try {
			Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
			System.out.println("Copy in dao");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
