/**
 * 
 */
package com.occ.namescore.inputprocess;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author JJW0712
 * 
 * This interface defines the input file processor functionality
 *
 */
public interface InputProcessor {
	
	/**
	 * 
	 * @param file
	 * @return List of names to be scored; Optional is returned to eliminate null return value
	 * @throws IOException
	 */
	Optional<List<String>> process(File file) throws IOException;
}
