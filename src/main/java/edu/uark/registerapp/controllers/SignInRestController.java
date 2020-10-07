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

@RestController
@RequestMapping(value = "/api")
public class SignInRestController {
	@RequestMapping(value = "/signOut", method = RequestMethod.DELETE)
	public @ResponseBody ApiResponse deleteUser(
		@RequestBody final Product product
    ) 
    {
        
			.setApiProduct(product)
            .execute();
            
        return ()

	}


	}


	// Properties
	@Autowired
	private UserDeleteCommand UserDeleteCommand;
	
	;
}
