package edu.uark.registerapp.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.commands.employees.ActiveEmployeeExistsQuery;
import edu.uark.registerapp.controllers.enums.QueryParameterNames;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.EmployeeSignIn;

@Controller
@RequestMapping(value = "/")
public class SignInRouteController extends BaseRouteController {
	// TODO: Route for initial page load
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewSignIn(@RequestParam final Map< String, String> queryParameters)
	{
		
	try 
	{
		this.activeEmployeeExistsQuery.execute();
	} 
	catch (Exception e) 
	{
		//TODO: handle exception
		return new ModelAndView(REDIRECT_PREPEND.concat(ViewNames.EMPLOYEE_DETAIL.getRoute()));
	}

	ModelAndView mav = this.setErrorMessageFromQueryString(new ModelAndView(ViewNames.SIGN_IN.getViewName()), queryParameters);

	if(queryParameters.containsKey(QueryParameterNames.EMPLOYEE_ID.getValue()))
	{
		mav.addObject(ViewModelNames.EMPLOYEE_ID.getValue(), queryParameters.get(QueryParameterNames.EMPLOYEE_ID.getValue()));
	}

		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView performSignIn( EmployeeSignIn eSignIn,
		// TODO: Define an object that will represent the sign in request and add it as a parameter here
		HttpServletRequest request
	) {

		// TODO: Use the credentials provided in the request body
		//  and the "id" property of the (HttpServletRequest)request.getSession() variable
		//  to sign in the user
		try 
		{
			((Object) this.employeeSignInCommand.setSessionId(request.getSession().getId()))
				.setEmployeeSignIn(eSignIn).execute();
		}
		 catch (Exception e) 
		{
			ModelAndView mav = new ModelAndView(ViewNames.SIGN_IN.getViewName());

			mav.addObject (ViewModelNames.ERROR_MESSAGE.getValue(), e.getMessage());
			mav.addObject (ViewModelNames.EMPLOYEE_ID.getValue(), eSignIn.getEmployeeId());
			return mav;
		}

		return new ModelAndView(REDIRECT_PREPEND.concat(ViewNames.MAIN_MENU.getRoute()));
	}

	@Autowired private EmployeeSignIn employeeSignInCommand;
	@Autowired private ActiveEmployeeExistsQuery activeEmployeeExistsQuery;

}
