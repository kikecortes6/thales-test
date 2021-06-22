package thales.oscar.test.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class EmpleadoDto implements Serializable {

	private static final long serialVersionUID = -6652804233178757581L;

	private Long id;

	@JsonProperty("employee_name")
	private String employeeName;

	@JsonProperty("employee_salary")
	private Long employeeSalary;

	@JsonProperty("employee_anual_salary")
	private Long employeeAnualSalary;

	@JsonProperty("employee_age")
	private Long employeeAge;

	@JsonProperty("profile_image")
	private String profileImage;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(final String employeeName) {
		this.employeeName = employeeName;
	}

	public Long getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(final Long employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public Long getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(final Long employeeAge) {
		this.employeeAge = employeeAge;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(final String profileImage) {
		this.profileImage = profileImage;
	}

	public Long getEmployeeAnualSalary() {
		return employeeAnualSalary;
	}

	public void setEmployeeAnualSalary(final Long employeeAnualSalary) {
		this.employeeAnualSalary = employeeAnualSalary;
	}

}
