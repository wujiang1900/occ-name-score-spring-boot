package com.occ.namescore.inputprocess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InputProcessorImpl_1 implements InputProcessor {
	Logger logger = LoggerFactory.getLogger(InputProcessorImpl_1.class);

	/*
	 *  Java8 features utilized:  try-resource, Optional, Parallel Stream, lambda expressions
	 */
	@Override
	public Optional<List<String>> process(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        	String line;
            if ((line = br.readLine()) != null) {
                return Optional.of(Stream.of(line.split(",")).parallel().map(s->s.replace("\"", "")).collect(Collectors.toList()));
            }
        } catch (IOException e) {
            logger.error("Encountered IOException while processing file {}", file.getAbsolutePath(), e);
            throw e;
        }
        return Optional.empty();
	}

}
