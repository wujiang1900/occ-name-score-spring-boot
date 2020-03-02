package com.occ.namescore.strategy;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;


/**
 *  To score a list of names, you must sort it alphabetically and sum the individual scores for all the names. 
 *  To score a name, sum the alphabetical value of each letter (A=1, B=2, C=3, etc...) 
 *  and multiply the sum by the name’s position in the list (1-based).
 */

@Service
public class NameScoreStrategyImpl_1 implements NameScoreStrategy {

	@Override
	public int score(Optional<List<String>> names) {
		if(names.isEmpty()) {
			return 0;
		}
		List<String> sorted = names.get().stream().sorted().collect(Collectors.toList());
		return IntStream.range(1, sorted.size()+1)
				.map(i->i*scoreName(sorted.get(i-1)))
				.sum();
	}

	protected int scoreName(String name) {
		if(name == null) {
			return 0;
		}
		return name.toUpperCase().chars()
				.filter(ch->(ch>=(int)'A' && ch<=(int)'Z'))
				.map(ch->ch-(int)'A'+1).sum();
	}

}
