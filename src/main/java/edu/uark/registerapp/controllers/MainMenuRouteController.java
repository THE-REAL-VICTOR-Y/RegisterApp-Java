package edu.uark.registerapp.controllers;

import java.util.Map;
<<<<<<< HEAD
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
=======
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> master
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

<<<<<<< HEAD
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.entities.ActiveUserEntity;

@Controller
@RequestMapping(value = "/mainMenu")
public class MainMenuRouteController extends BaseRouteController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(
		@RequestParam final Map<String, String> queryParameters,
		final HttpServletRequest request
	) {

		final Optional<ActiveUserEntity> activeUserEntity =
			this.getCurrentUser(request);
		if (!activeUserEntity.isPresent()) {
			return this.buildInvalidSessionResponse();
		}
		
		ModelAndView modelAndView =
			this.setErrorMessageFromQueryString(
				new ModelAndView(ViewNames.MAIN_MENU.getViewName()),
				queryParameters);

		// TODO: Examine the ActiveUser classification if you want this information
		modelAndView.addObject(
			ViewModelNames.IS_ELEVATED_USER.getValue(),
			true);
		
		return modelAndView;
	}
}
=======
import edu.uark.registerapp.commands.products.ProductQuery;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.Product;

@Controller
@RequestMapping(value = "/mainMenu")
public class MainMenuRouteController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(@RequestParam Map<String, String> queryParameters, HttpServletRequest request) {
        Optional<ActiveUserEntity> activeUserEntity = this.getCurrentUser(request);
        if(!activeUserEntity.isPresent()){
            return this.buildInvalidSessionResponse();
        }


		// return (new ModelAndView(ViewNames.PRODUCT_DETAIL.getViewName()))
		// 	.addObject(
		// 		ViewModelNames.PRODUCT.getValue(),
		// 		(new Product()).setLookupCode(StringUtils.EMPTY).setCount(0));
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public ModelAndView startWithProduct(@PathVariable final UUID productId) {
		final ModelAndView modelAndView =
			new ModelAndView(ViewNames.PRODUCT_DETAIL.getViewName());

		try {
			modelAndView.addObject(
				ViewModelNames.PRODUCT.getValue(),
				this.productQuery.setProductId(productId).execute());
		} catch (final Exception e) {
			modelAndView.addObject(
				ViewModelNames.ERROR_MESSAGE.getValue(),
				e.getMessage());
			modelAndView.addObject(
				ViewModelNames.PRODUCT.getValue(),
				(new Product())
					.setCount(0)
					.setLookupCode(StringUtils.EMPTY));
		}

		return modelAndView;
	}

	// Properties
	@Autowired
	private ProductQuery productQuery;
}
>>>>>>> master
