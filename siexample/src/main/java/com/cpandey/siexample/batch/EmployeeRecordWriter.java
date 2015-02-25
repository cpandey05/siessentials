package com.cpandey.siexample.batch;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;

/**
 * @author Chandan Pandey
 *
 */
public class EmployeeRecordWriter implements ItemWriter<Employee> {
	private static final Logger LOGGER = Logger.getLogger(EmployeeRecordWriter.class);

	@Override
	public void write(List<? extends Employee> employees) throws Exception {
		if(employees!=null){
			for (Employee employee : employees) {
				LOGGER.info(employee.toString());
			}
		}
	}
}
