package com.cpandey.siexample;

/**
 * Class to launch the batch Job.
 *
 * @author Chandan Pandey
 * 
 * Spring Bacth Job Support
 *
 */
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BatchJobLauncher {
	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/integration/spring-integration-batch.xml");
		Job job = context.getBean("importEmployeeRecords", Job.class);
		JobLauncher jobLauncher= context.getBean("jobLauncher", JobLauncher.class);
		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
		jobParametersBuilder.addString("input.file.name", "C:/workspace_sts/siexample/src/main/resources/META-INF/spring/integration/employee.input");
		JobExecution execution =jobLauncher.run(job, jobParametersBuilder.toJobParameters());
	}
}
