package com.occ.namescore.rest;

public class FileStorageException extends RuntimeException {
	private static final long serialVersionUID = -4018597108738162849L;

	public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
