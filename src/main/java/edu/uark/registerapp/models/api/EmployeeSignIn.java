package edu.uark.registerapp.models.api;

import org.apache.commons.lang3.StringUtils;

public class EmployeeSignIn
{
    private String ID;
    
    private String pass;

    public String getEmployeeId()
    {
        return this.ID;
    }

    public EmployeeSignIn setEmployeeId(final String ID)
    {
        this.ID = ID;
        return this;
    }

    public String getPassword()
    {
        return this.pass;
    }

    public EmployeeSignIn setPassword(final String pass)
    {
        this.pass = pass;
        return this;
    }

    public EmployeeSignIn()
    {
        this.pass = StringUtils.EMPTY;
        this.ID = StringUtils.EMPTY;
    }

	public Object setSessionId(String id2) {
		return null;
	}


}
