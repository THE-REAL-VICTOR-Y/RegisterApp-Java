package edu.uark.registerapp.controllers;

<<<<<<< HEAD
import javax.servlet.http.HttpServletRequest;

=======
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> master
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.ApiResponse;
=======
import edu.uark.registerapp.models.api.ApiResponse;
import edu.uark.registerapp.models.api.Product;
import javax.servlet.http.HttpServletRequest;
import edu.uark.registerapp.commands.activeUsers.ActiveUserDeleteCommand;
import edu.uark.registerapp.controllers.enums.ViewNames;

>>>>>>> master

@RestController
@RequestMapping(value = "/api")
public class SignInRestController extends BaseRestController {
<<<<<<< HEAD
	@RequestMapping(value="/signOut", method = RequestMethod.DELETE)
	public @ResponseBody ApiResponse removeActiveUser(
		final HttpServletRequest request
	) {

		// TODO: Sign out the user associated with request.getSession().getId()

		return (new ApiResponse())
			.setRedirectUrl(ViewNames.SIGN_IN.getRoute());
	}
=======
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


	// Properties
	@Autowired
	private ActiveUserDeleteCommand activeUserDeleteCommand;
	
	;
>>>>>>> master
}
