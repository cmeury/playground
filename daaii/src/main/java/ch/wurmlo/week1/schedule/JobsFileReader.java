package ch.wurmlo.week1.schedule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public class JobsFileReader {

	private final List<Job> jobs;

	public JobsFileReader(String fileName) throws IOException {
		@SuppressWarnings("unchecked")
		List<String> list = IOUtils.readLines(JobsFileReader.class.getResourceAsStream(fileName));
		int size = Integer.valueOf(list.get(0));
		jobs = new ArrayList<Job>(size);
		for (String s : list.subList(1, list.size())) {
			String[] split = StringUtils.split(s, " ");
			int weight = Integer.valueOf(split[0]);
			int length = Integer.valueOf(split[1]);
			jobs.add(new Job(weight, length));
		}
		if(jobs.size() != size) {
			throw new IOException("file line count does not match actual jobs");
		}
	}

	public List<Job> getJobs() {
		return jobs;
	}
}
