package edu.uark.registerapp.models.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import edu.uark.registerapp.commands.employees.helpers.EmployeeHelper;
import edu.uark.registerapp.models.api.Employee;

@Entity
@Table(name="employee")
public class EmployeeEntity {
    @Id
    @Column(name="id", updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private final UUID id;

	public UUID getId() {
		return this.id;
	}
<<<<<<< HEAD

	@Column(name = "employeeid", insertable = false, updatable = false)
	@Generated(GenerationTime.INSERT)
	private int employeeId;

	public int getEmployeeId() {
		return this.employeeId;
	}

	@Column(name = "firstname")
=======
    // First Name
    @Column(name = "firstname")
>>>>>>> master
	private String firstName;

	public String getFirstName() {
		return this.firstName;
	}

	public EmployeeEntity setFirstName(final String firstName) {
		this.firstName = firstName;
		return this;
<<<<<<< HEAD
	}

	@Column(name = "lastname")
=======
    }
    //Last name
    @Column(name = "lastname")
>>>>>>> master
	private String lastName;

	public String getLastName() {
		return this.lastName;
	}

	public EmployeeEntity setLastName(final String lastName) {
		this.lastName = lastName;
		return this;
	}
<<<<<<< HEAD

	@Column(name = "password")
	private byte[] password;

	public byte[] getPassword() {
		return this.password;
	}

	public EmployeeEntity setPassword(final byte[] password) {
		this.password = password;
		return this;
	}

	@Column(name = "active")
=======
    // Employee id
    @Column(name = "employeeid", insertable = false, updatable = false)
	@Generated(GenerationTime.INSERT)
	private int employeeId;

	public int getEmployeeId() {
		return this.employeeId;
	}
    //Active
    @Column(name = "active")
>>>>>>> master
	private boolean isActive;

	public boolean getIsActive() {
		return this.isActive;
	}

	public EmployeeEntity setIsActive(final boolean isActive) {
		this.isActive = isActive;
		return this;
	}
<<<<<<< HEAD

	@Column(name = "classification")
=======
    //Clasification
    @Column(name = "classification")
>>>>>>> master
	private int classification;

	public int getClassification() {
		return this.classification;
	}

	public EmployeeEntity setClassification(final int classification) {
		this.classification = classification;
		return this;
	}
<<<<<<< HEAD

	@Column(name = "managerid")
=======
    //Manager
    @Column(name = "managerid")
>>>>>>> master
	private UUID managerId;

	public UUID getManagerId() {
		return this.managerId;
	}

	public EmployeeEntity setManagerId(final UUID managerId) {
		this.managerId = managerId;
		return this;
	}
<<<<<<< HEAD

=======
    //password
    @Column(name = "password")
	private byte[] password;

	public byte[] getPassword() {
		return this.password;
	}

	public EmployeeEntity setPassword(final byte[] password) {
		this.password = password;
		return this;
	}
    //Created on
>>>>>>> master
	@Column(name = "createdon", insertable = false, updatable = false)
	@Generated(GenerationTime.INSERT)
	private LocalDateTime createdOn;

	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}

	public Employee synchronize(final Employee apiEmployee) {
<<<<<<< HEAD
		this.setIsActive(apiEmployee.getIsActive());
		this.setLastName(apiEmployee.getLastName());
		this.setFirstName(apiEmployee.getFirstName());
		this.setClassification(apiEmployee.getClassification());
		if (apiEmployee.getManagerId() != null) {
=======
        this.setFirstName(apiEmployee.getFirstName());
        this.setLastName(apiEmployee.getLastName());
        this.setClassification(apiEmployee.getClassification());
		this.setIsActive(apiEmployee.getIsActive());
		/*if (apiEmployee.getManagerId() != null) {
>>>>>>> master
			this.setManagerId(apiEmployee.getManagerId());
		}
		if (!StringUtils.isBlank(apiEmployee.getPassword())) {
			this.setPassword(
				EmployeeHelper.hashPassword(
					apiEmployee.getPassword()));
<<<<<<< HEAD
		}

=======
		}*/
>>>>>>> master
		apiEmployee.setId(this.getId());
		apiEmployee.setCreatedOn(this.getCreatedOn());
		apiEmployee.setEmployeeId(this.getEmployeeId());

		return apiEmployee;
	}

	public EmployeeEntity() {
		this.employeeId = -1;
		this.isActive = false;
		this.id = new UUID(0, 0);
		this.classification = -1;
		this.password = new byte[0];
		this.managerId = new UUID(0, 0);
		this.lastName = StringUtils.EMPTY;
		this.firstName = StringUtils.EMPTY;
	}

	public EmployeeEntity(final Employee apiEmployee) {
    	this.id = new UUID(0, 0);
		this.isActive = apiEmployee.getIsActive();
		this.lastName = apiEmployee.getLastName();
		this.firstName = apiEmployee.getFirstName();
		this.classification = apiEmployee.getClassification();
<<<<<<< HEAD
		this.password = EmployeeHelper.hashPassword(apiEmployee.getPassword());
		this.managerId = (
			(apiEmployee.getManagerId() != null)
				? apiEmployee.getManagerId()
				: new UUID(0, 0));
	}
}
=======
		//this.password = EmployeeHelper.hashPassword(apiEmployee.getPassword());
			if(apiEmployee.getManagerId() == null){
				this.managerId=(new UUID(0, 0));
			}else{
				this.managerId=apiEmployee.getManagerId();
			}
	}
}
>>>>>>> master
