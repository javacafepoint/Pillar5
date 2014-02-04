package org.pillar.main;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "register")
	public String register(ModelMap m) {
		Session s = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		s.beginTransaction();
		m.addAttribute("register", new RegisterBean());
		s.save(m);
		s.close();
		return "Register";
	}


}
