package com.cpandey.siexample.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * @author Chandan Pandey
 *
 */
public class EmployeeFieldSetMapper implements FieldSetMapper<Employee> {
@Override
public Employee mapFieldSet(FieldSet fieldSet) throws BindException {
		Employee employee = new Employee();
		employee.setName(fieldSet.readString("name"));
		employee.setDesignation(fieldSet.readString("designation"));
		employee.setDept(fieldSet.readString("dept"));
		employee.setAddress(fieldSet.readString("address"));
		return employee;
	}
}