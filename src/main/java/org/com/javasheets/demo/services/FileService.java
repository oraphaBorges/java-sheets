package org.com.javasheets.demo.services;

import org.com.javasheets.demo.exceptions.StorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	@Value("${upload.path}")
	public String path;
	
	public void uploadFile(MultipartFile file) {

		if (file.isEmpty()) {
            throw new StorageException("Arquivo não existente!");
        }

	}
}
