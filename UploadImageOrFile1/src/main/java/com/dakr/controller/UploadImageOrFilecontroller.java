package com.dakr.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadImageOrFilecontroller {

	@PostMapping("/uploadeimage")
	public String uploadImage(@RequestParam("file") MultipartFile file) throws Exception {

		System.out.println(file.getOriginalFilename());
		System.out.println(file.getName());
		System.out.println(file.getContentType());
		System.out.println(file.getSize());

		// Directory to save the file in ur project
		//String path_Directory = "D:\\AdvJava\\App\\DAKRPROJECT\\UploadImageOrFile1\\src\\main\\resources\\static\\image";
		String path_Directory = new ClassPathResource("static/image/").getFile().getAbsolutePath();
		// This will copy the source file(C:/download) image to Target
		// file(/static/image)
		Files.copy(file.getInputStream(), Paths.get(path_Directory + File.separator + file.getOriginalFilename()),
				StandardCopyOption.REPLACE_EXISTING);
		
		return "Successfully Image Is Uploaded";
	}
}
