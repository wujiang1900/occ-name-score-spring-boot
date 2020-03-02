/**
 * 
 */
package com.occ.namescore.strategy;

import java.util.List;
import java.util.Optional;

/**
 * @author JJW0712
 *
 */
public interface NameScoreStrategy {
	int score(Optional<List<String>> optional);
}
