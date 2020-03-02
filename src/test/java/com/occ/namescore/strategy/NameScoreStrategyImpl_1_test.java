package com.occ.namescore.strategy;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

public class NameScoreStrategyImpl_1_test {
	private NameScoreStrategyImpl_1 strategy;
	
	@Before
	public void setup() {
		strategy = new NameScoreStrategyImpl_1();
	}
	
	@Test
	public void scoreName_should_compute_score_for_a_string() {
		String name = "abcd";
		int expected = 10;
		
		assertEquals(expected, strategy.scoreName(name));
	}
	
	@Test
	public void scoreName_should_ignore_non_letters_for_in_string() {
		String name = "ab`cd&*%$#@!~";
		int expected = 10;
		
		assertEquals(expected, strategy.scoreName(name));
	}
	
	@Test
	public void scoreName_should_return_0_for_empty_string() {
		String name = "";
		int expected = 0;
		
		assertEquals(expected, strategy.scoreName(name));
	}
	
	@Test
	public void scoreName_should_return_0_for_null() {
		String name = null;
		int expected = 0;
		
		assertEquals(expected, strategy.scoreName(name));
	}

	@Test
	public void score_should_compute_score_for_string_list() {
		List<String> nameList = new ArrayList<>();
		String name = "ab'cd";
		nameList.add(name);
		name = "efgh";
		nameList.add(name);
		int expected = 62;
		
		assertEquals(expected, strategy.score(Optional.of(nameList)));
	}	
	
	@Test
	public void score_should_return_0_for_empty_list() {
		int expected = 0;
		
		assertEquals(expected, strategy.score(Optional.of(new ArrayList<>())));
	}
	
	@Test
	public void score_should_return_0_for_null_list() {
		int expected = 0;
		
		assertEquals(expected, strategy.score(Optional.empty()));
	}
}
