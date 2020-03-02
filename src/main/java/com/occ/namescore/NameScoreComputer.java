/**
 * 
 */
package com.occ.namescore;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.occ.namescore.inputprocess.InputProcessorImpl_1;
import com.occ.namescore.rest.FileStorageProperties;
import com.occ.namescore.strategy.NameScoreStrategyImpl_1;

/**
 * @author JJW0712
 * 
 * Driver program for scoring names, which takes the full file path containing list of names as the program argument
 * 
 * The application is implemented with Strategy design pattern for easy change of file processing and name-scoring algorithms
 * 
 * A Spring boot application that has a REST endpoint for uploading a file to score (See com.occ.namescore.rest package)
 *
 */

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class NameScoreComputer {

	/**
	 * @param args  the full file path/name containing list of names to score, e.g. "./src/main/resources/all-names.txt"
	 */
	public static void main(String[] args) {
		SpringApplication.run(NameScoreComputer.class, args);
		if (args.length == 0) {
			System.out.println("=============================================");
			System.out.println(" USAGE: NameScoreComputer <FilePath/name> ");
			System.out.println("=============================================");
			return;
		}

		File file = new File(args[0]);
		if (!file.exists()) {
			System.out.println("=============================================");
			System.out.println(" ERROR: file path or name ("+args[0]+")is not found!");
			System.out.println("=============================================");
			return;
		}

		NameScoreContext context = new NameScoreContext(new InputProcessorImpl_1(), new NameScoreStrategyImpl_1());
		int score = context.computeNameScore(file);
		System.out.println("=============================================");
		System.out.println("Computed score is " + score);
		System.out.println("=============================================");
	}

}
