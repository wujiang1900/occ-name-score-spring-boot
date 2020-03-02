package com.occ.namescore.inputprocess;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class InputProcessorImpl_1_test {
	private InputProcessorImpl_1 processor;
	
	@Before
	public void setup() {
		processor = new InputProcessorImpl_1();
	}
	
	@Test
	public void process_should_return_string_list() throws IOException {
		Object[] names = {"MARY","PATRICIA","LINDA","BARBARA","VINCENZO","SHON","LYNWOOD","JERE","HAI"};
		List<Object> expected = Arrays.asList(names);

		File file = new File("./src/main/resources/names.txt");
		assertEquals(expected, processor.process(file).get());
	}
}
