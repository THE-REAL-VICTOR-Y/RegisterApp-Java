package edu.uark.registerapp.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.registerapp.models.api.ApiResponse;
import edu.uark.registerapp.models.api.Product;
import javax.servlet.http.HttpServletRequest;
import edu.uark.registerapp.commands.activeUsers.ActiveUserDeleteCommand;
import edu.uark.registerapp.controllers.enums.ViewNames;


@RestController
@RequestMapping(value = "/api")
public class SignInRestController extends BaseRestController {
	@RequestMapping(value = "/signOut", method = RequestMethod.DELETE)
	public @ResponseBody ApiResponse removeActiveUser(
		final HttpServletRequest request
    ) 
    {
        this.activeUserDeleteCommand
			.setSessionKey(request.getSession().getId())
            .execute();
            
		return (new ApiResponse())
			.setRedirectUrl(ViewNames.SIGN_IN.getRoute());

	}


	}


	
	@Autowired
	private ActiveUserDeleteCommand activeUserDeleteCommand;
	
	;
}
