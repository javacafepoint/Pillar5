package org.pillar.hibertest;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.pillar.entity.Area;
import org.pillar.entity.States;

public class AreaState {

	public static void main(String[] args) {

		Session s = new AnnotationConfiguration().configure()
				.buildSessionFactory().openSession();

		s.beginTransaction();

		States s1 = new States("Tamil Nadu");

		Area a1 = new Area("CHennai", s1);

		s.save(a1);

		s.getTransaction().commit();

		s.close();
		

	}

}
