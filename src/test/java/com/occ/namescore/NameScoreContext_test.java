package com.occ.namescore;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.occ.namescore.inputprocess.InputProcessor;
import com.occ.namescore.inputprocess.InputProcessorImpl_1;
import com.occ.namescore.strategy.NameScoreStrategyImpl_1;

public class NameScoreContext_test {
	
	@Test
	public void computeNameScore_should_compute_small_file() {
		NameScoreContext context = new NameScoreContext(new InputProcessorImpl_1(), new NameScoreStrategyImpl_1());

		File file = new File("./src/main/resources/names.txt");
		int expected = 3194;
		
		assertEquals(expected, context.computeNameScore(file));
	}
	
	@Test
	public void computeNameScore_should_compute_big_file() {
		NameScoreContext context = new NameScoreContext(new InputProcessorImpl_1(), new NameScoreStrategyImpl_1());

		File file = new File("./src/main/resources/all-names.txt");
		int expected = 871198282;
		
		assertEquals(expected, context.computeNameScore(file));
	}	

	@Test
	public void computeNameScore_should_return_0_when_exception() throws IOException {
		File file = new File("./src/main/resources/all-names.txt");
		InputProcessor mockProcessor = mock(InputProcessor.class);
		doThrow(IOException.class).when(mockProcessor).process(file);
		
		NameScoreContext context = new NameScoreContext(mockProcessor, new NameScoreStrategyImpl_1());
		int expected = 0;
		
		assertEquals(expected, context.computeNameScore(file));
	}
}
