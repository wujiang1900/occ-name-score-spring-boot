/**
 * 
 */
package com.occ.namescore;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.occ.namescore.inputprocess.InputProcessor;
import com.occ.namescore.strategy.NameScoreStrategy;

/**
 * @author JJW0712
 * 
 * This class encapsulates the context that implements the Strategy design pattern
 * 
 * The constructor takes InputProcessor and NameScoreStrategy as the arguments, which can be configured during run-time, through config file
 *
 */

@Component
public class NameScoreContext {
	private Logger logger = LoggerFactory.getLogger(NameScoreContext.class);
	private InputProcessor inputProcessor;
	private NameScoreStrategy nameScoreStrategy;
	
	public NameScoreContext(InputProcessor inputProcessor, NameScoreStrategy nameScoreStrategy) {
		this.inputProcessor = inputProcessor;
		this.nameScoreStrategy = nameScoreStrategy;
	}
	/**
	 * 
	 * @param file
	 * @return computed score; 0 if there are any exceptions
	 */
	public int computeNameScore(File file) {
		try {
			return nameScoreStrategy.score(inputProcessor.process(file));
		} catch (Exception e) {
			logger.error("Unexpected exception when scoring file {}", file.getAbsolutePath(), e);
			return 0;
		}
	}
}
