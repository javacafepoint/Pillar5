package org.pillar.main;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.pillar.entity.Area;
import org.pillar.entity.RegisterBean;
import org.pillar.entity.States;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
	
	@RequestMapping("dbtest")
	public String dbTest(){
		
		Session s = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		s.beginTransaction();
		
		States s1 = new States("Tamil Nadu");
		
		Area a1 = new Area("Chennai",s1);
		Area a2 = new Area("Madurai",s1);
		
		Set<Area> as = new HashSet<Area>();
		as.add(a1);
		as.add(a2);
		
		
		s1.setAreas(as);
		s.save(a1);
		s.save(a2);
		s.save(s1);
		
		s.getTransaction().commit();
		s.close();
		
		return "TestPage";
	}
	
	@RequestMapping(value = "register",method=RequestMethod.GET)
	public ModelAndView rrr(){
		
		return new ModelAndView("Register", "reg", new RegisterBean());
	}

	@RequestMapping(value = "register",method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("reg") @Valid RegisterBean reg, HttpServletRequest request, BindingResult result, ModelMap model) {
		Session s = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		s.beginTransaction();
		try{
		reg.setFirstName(request.getParameter("firstname"));
		reg.setLastName(request.getParameter("lastname"));
		reg.setMobile(request.getParameter("mobile"));
		reg.setEmail(request.getParameter("email"));
		reg.setGender(request.getParameter("gender"));
		reg.setState(request.getParameter("state"));
		reg.setCity(request.getParameter("city"));
		s.saveOrUpdate(reg);
		s.getTransaction().commit();
		Validator valid = Validation.buildDefaultValidatorFactory().getValidator();
		valid.validate(reg);
		model.addAttribute("reg", new RegisterBean());
		}
		catch(Exception e){
			e.printStackTrace();
			
		}finally{
		s.close();
		}
		if(result.hasErrors()){
			return new ModelAndView("Register");
		}else{
			return new ModelAndView("success");
		}
	}
}
