package com.occ.namescore.rest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

public class FileStorageService_test {
	@Test
	public void storeFile_happy_path() {
		FileStorageProperties props = mock(FileStorageProperties.class);
		doReturn("/Users/jjw0712/mock").when(props).getUploadDir();
		
		FileStorageService service = new FileStorageService(props);
		MockMultipartFile mockFile = new MockMultipartFile("test.txt", "abc".getBytes());
		
		assertNotNull(service.storeFile(mockFile));
	}
	
	@Test(expected=FileStorageException.class)
	public void storeFile_should_throw_ex_when_invalid_file_name() {
		FileStorageProperties props = mock(FileStorageProperties.class);
		doReturn("").when(props).getUploadDir();
		
		FileStorageService service = new FileStorageService(props);
		MockMultipartFile mockFile = new MockMultipartFile("test.txt", "abc".getBytes());
		
		service.storeFile(mockFile);
	}
}
