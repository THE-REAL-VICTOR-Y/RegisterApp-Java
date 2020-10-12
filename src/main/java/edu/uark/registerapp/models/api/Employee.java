package edu.uark.registerapp.models.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.registerapp.commands.employees.helpers.EmployeeHelper;
import edu.uark.registerapp.models.entities.EmployeeEntity;

public class Employee extends ApiResponse {
	private UUID id;
	private String employeeID;
	private String firstName;
	private String lastName;
	private String password;
	private boolean isActive;
	private int classification;
	private UUID managerID;
	private String createdOn;
	private boolean isInitialEmployee;




    public UUID getId() {
    	return this.id;
    }
    public Employee setId(final UUID id) {
		this.id = id;
		return this;
	}

	public String getEmployeeId() {
		return this.employeeID;
	}
	public Employee setEmployeeId(final int employeeID) {
		this.employeeID = EmployeeHelper.padEmployeeId(employeeID);
		return this;
	}
	public Employee setEmployeeId(final String employeeID) {
		this.employeeID = employeeID;
		return this;
	}

	public String getFirstName() {
		return this.firstName;
	}
	public Employee setFirstName(final String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return this.lastName;
	}
	public Employee setLastName(final String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getPassword() {
		return this.password;
	}
	public Employee setPassword(final String password) {
		this.password = password;
		return this;
	}

	public boolean getIsActive() {
		return this.isActive;
	}
	public Employee setIsActive(final boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public int getClassification() {
		return this.classification;
	}
	public Employee setClassification(final int classification) {
		this.classification = classification;
		return this;
	}

	public UUID getManagerId() {
		return this.managerID;
	}
	public Employee setManagerId(final UUID managerID) {
		this.managerID = managerID;
		return this;
	}

	public String getCreatedOn() {
		return this.createdOn;
	}
	public Employee setCreatedOn(final String createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	public Employee setCreatedOn(final LocalDateTime createdOn) {
		this.createdOn =
			createdOn.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		return this;
	}

	public boolean getIsInitialEmployee() {
		return this.isInitialEmployee;
	}
	public Employee setIsInitialEmployee(final boolean isInitialEmployee) {
		this.isInitialEmployee = isInitialEmployee;
		return this;
	}

	public Employee() {
		super();

		this.isActive = true;
		this.id = new UUID(0, 0);
		this.classification = -1;
		this.isInitialEmployee = false;
		this.managerID = new UUID(0, 0);
		this.lastName = StringUtils.EMPTY;
		this.password = StringUtils.EMPTY;
		this.firstName = StringUtils.EMPTY;
		this.employeeID = StringUtils.EMPTY;

		this.setCreatedOn(LocalDateTime.now());
	}

	public Employee(final EmployeeEntity employeeEntity) {
		super(false);

		this.isInitialEmployee = false;
		this.id = employeeEntity.getId();
		this.password = StringUtils.EMPTY;
		this.isActive = employeeEntity.getIsActive();
		this.lastName = employeeEntity.getLastName();
		this.firstName = employeeEntity.getFirstName();
		this.managerID = employeeEntity.getManagerId();
		this.classification = employeeEntity.getClassification();
		this.employeeID =
			EmployeeHelper.padEmployeeId(employeeEntity.getEmployeeId());

		this.setCreatedOn(employeeEntity.getCreatedOn());
	}
}
