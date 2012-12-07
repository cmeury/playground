package ch.wurmlo.week1.schedule;

import java.io.IOException;
import java.util.List;

public class Question1 {

	public static void main(String[] args) {
		try {
			JobsFileReader reader = new JobsFileReader("jobs.txt");
			List<Job> jobs = reader.getJobs();
		} catch (IOException e) {
			System.err.println("Could not read file");
			System.exit(1);
		}
	}

}
