package ch.wurmlo.week1.schedule;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question1 {

	public static void main(String[] args) {
		try {

			// translating file into list of jobs
			JobsFileReader reader = new JobsFileReader("jobs.txt");
			List<Job> jobs = reader.getJobs();

			// employing objective function by sorting the list according to the given comparator
			Collections.sort(jobs, new Comparator<Job>() {
				@Override
				public int compare(Job o1, Job o2) {
					int score1 = o1.getWeight() - o1.getLength();
					int score2 = o2.getWeight() - o2.getLength();
					if(score1 < score2) {
						return -1;
					} else if(score1 > score2) {
						return 1;
					} else {
						if(o1.getWeight() < o2.getWeight()) {
							return -1;
						} else if(o1.getWeight() > o2.getWeight()) {
							return 1;
						} else {
							return 0;
						}
					}

				}
			});

			// reversing
			Collections.reverse(jobs);

			// calculating the sum of weighted completion times
			long completionTime = 0;
			long sumOfCompletionTimes = 0;
			for (Job job : jobs) {
				completionTime += job.getLength();
				sumOfCompletionTimes += job.getWeight() * completionTime;
			}

			System.out.println("sumOfCompletionTimes = " + sumOfCompletionTimes);

		} catch (IOException e) {
			System.err.println("Could not read file");
			System.exit(1);
		}
	}

}
