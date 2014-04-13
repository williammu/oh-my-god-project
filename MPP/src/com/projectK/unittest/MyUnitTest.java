package com.projectK.unittest;
//
//package com.aliyun.mpp.unittest;
//
//import java.io.IOException;
//import java.util.Set;
//
//import junit.framework.TestCase;
//
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import junit.framework.TestCase;
//
//import org.apache.commons.lang.ArrayUtils;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
//import org.springframework.beans.BeanUtils;
//
//import com.aliyun.mpp.bean.CaseBean;
//import com.aliyun.mpp.bean.UserBean;
//import com.aliyun.mpp.entity.AuxiliaryDevEnvEntity;
//import com.aliyun.mpp.entity.CaseCompatibilityEntity;
//import com.aliyun.mpp.entity.CaseEditHistoryEntryEntity;
//import com.aliyun.mpp.entity.CaseEntity;
//import com.aliyun.mpp.entity.CaseGroupEntity;
//import com.aliyun.mpp.entity.DeviceEntity;
//import com.aliyun.mpp.entity.HistoryCaseIDMapEntryEntity;
//import com.aliyun.mpp.entity.HistoryCompInfoEntity;
//import com.aliyun.mpp.entity.HistoryModuleInfoEntity;
//import com.aliyun.mpp.entity.HistoryModulePlotEntity;
//import com.aliyun.mpp.entity.HostEntity;
//import com.aliyun.mpp.entity.PerfIndexFieldEntity;
//import com.aliyun.mpp.entity.PerfModuleEntity;
//import com.aliyun.mpp.entity.PerfModuleIndexEntity;
//import com.aliyun.mpp.entity.PerfModulePlotEntity;
//import com.aliyun.mpp.entity.PerfProjectEntity;
//import com.aliyun.mpp.entity.PerfResAuxiliaryInfoEntity;
//import com.aliyun.mpp.entity.PerfResMetaEntryEntity;
//import com.aliyun.mpp.entity.PerfResultEntryEntity;
//import com.aliyun.mpp.entity.ProjectCompPlotEntryEntity;
//import com.aliyun.mpp.entity.UserEntity;
//import com.aliyun.mpp.entity.ViewEntity;
//import com.aliyun.mpp.utils.HudsonConfigUtils;
//import com.aliyun.mpp.utils.MPPHttpUtils;
//import com.aliyun.mpp.utils.search.MPPContainsPredicate;
//import com.aliyun.mpp.utils.search.MPPPredicate;
//import com.aliyun.mpp.utils.search.MPPSearchUtils;
////
//public class MyUnitTest extends TestCase {
//
//	private static SessionFactory sessionFactory;
//	
//	
//	public Set<Object> getHolderCases() {
//		return null;
//	}
//	public void setHolderCases(Set<Object> s) {
//	}
//	
//	@Override
//	protected void setUp() {
//		
////		boolean b = false;
////		try {
////			b = ReflectUtils.methodReturnSet(this.getClass().getMethod("getHolderCases", null));
////		} catch (SecurityException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (NoSuchMethodException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		System.out.print(b);
////		System.out.print("setup\n");
////
//		AnnotationConfiguration cfg = new AnnotationConfiguration();
//
//		cfg.setProperty("hibernate.connection.driver_class",
//				"com.mysql.jdbc.Driver");
//		cfg
//				.setProperty("hibernate.connection.url",
//						"jdbc:mysql://localhost:3306/MPPDB?useUnicode=true&characterEncoding=utf8");
//		cfg.setProperty("hibernate.connection.username", "root");
//		cfg.setProperty("hibernate.connection.password", "123456");
//		cfg.setProperty("hibernate.dialect",
//				"org.hibernate.dialect.MySQLDialect");
//		cfg.setProperty("hibernate.hbm2ddl.auto", "update");
//		cfg.setProperty("hibernate.current_session_context_class",
//				"org.hibernate.context.ThreadLocalSessionContext");
//		cfg.addAnnotatedClass(CaseEntity.class);
//		cfg.addAnnotatedClass(CaseCompatibilityEntity.class);
//		cfg.addAnnotatedClass(CaseGroupEntity.class);
//		cfg.addAnnotatedClass(PerfProjectEntity.class);
//		cfg.addAnnotatedClass(CaseEditHistoryEntryEntity.class);
//		cfg.addAnnotatedClass(PerfModuleEntity.class);
//		cfg.addAnnotatedClass(PerfModuleIndexEntity.class);
//		cfg.addAnnotatedClass(PerfModulePlotEntity.class);
//		cfg.addAnnotatedClass(PerfResAuxiliaryInfoEntity.class);
//		cfg.addAnnotatedClass(PerfResultEntryEntity.class);
//		cfg.addAnnotatedClass(PerfIndexFieldEntity.class);
//		cfg.addAnnotatedClass(ProjectCompPlotEntryEntity.class);
//		cfg.addAnnotatedClass(PerfResMetaEntryEntity.class);
//		cfg.addAnnotatedClass(AuxiliaryDevEnvEntity.class);
//		cfg.addAnnotatedClass(DeviceEntity.class);
//		cfg.addAnnotatedClass(HostEntity.class);
//		cfg.addAnnotatedClass(HistoryCaseIDMapEntryEntity.class);
//		cfg.addAnnotatedClass(HistoryCompInfoEntity.class);
//		cfg.addAnnotatedClass(HistoryModuleInfoEntity.class);
//		cfg.addAnnotatedClass(HistoryModulePlotEntity.class);
//		cfg.addAnnotatedClass(UserEntity.class);
//		cfg.addAnnotatedClass(ViewEntity.class);
//		try {
//			sessionFactory = cfg.buildSessionFactory();
//		} catch (Exception ex) {
//			ex.getMessage();
//		}
//		System.out.print("setup end\n");
//	}
//
//	@Override
//	protected void tearDown() {
////		System.out.print("teardown\n");
////		sessionFactory.close();
//	}
//	
//	private void change(int[] ary)
//	{
//		ary[0] = 1;
//	}
//
//	/** 级联保存 */
//	public void testCase1() {
//		Session session = sessionFactory.getCurrentSession();
//		
//		session.beginTransaction();
//		
//		CaseEntity c = new CaseEntity();
//		ViewEntity v = (ViewEntity) session.createQuery("from ViewEntity v where v.id = 1").list().get(0);
//		
//		c.setName("test2");
//		Set<CaseEntity> s = new HashSet<CaseEntity>();
//		s.add(c);
//		v.setViewCases(s);
//		session.save(v);
//		session.getTransaction().commit();
//	
//		
////		String url = "http://10.125.0.60:8080/hudson/job/2.0.1-R-20130820.0548_DOOV-C1_000822455f32/111/api/json";
////		try {
////			MPPHttpUtils.sendPostRequest(url, "");
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		System.out.println("!");
//		
////		Session session = sessionFactory.getCurrentSession();
////		session.beginTransaction();
////		String hql = "from HostEntity h where h.hostMac = '" + "6C-88-14-63-81-B4" + "'";
////		try{
////			List lst = session.createQuery(hql).list();
////			HostEntity host = (HostEntity) lst.get(0);
////			session.getTransaction().commit();
////		}catch(Exception ex)
////		{
////			ex.getMessage();
////		}
//		
////
////		PerfModuleIndexEntity index = new PerfModuleIndexEntity();
////		PerfModuleEntity module = new PerfModuleEntity();
////		module.setModuleCases(new HashSet<CaseEntity>());
////		module.setModuleDesc("testModuleDesc");
////		module.setModuleName("testModuleName");
////		module.setPlotEntries(new HashSet<PerfModulePlotEntity>());
////
////		index.setDesc("testIndexDesc");
////		index.setName("testIndexName");
////		index.setType(0);
////		index.setPerfModuleEntity(module);
////
////		HashSet<PerfModuleIndexEntity> indices = new HashSet<PerfModuleIndexEntity>();
////
////		indices.add(index);
////
////		module.setModuleIndices(indices);
////
////		PerfIndexFieldEntity field = new PerfIndexFieldEntity();
////		field.setFieldName("testFieldName");
////		field.setFieldDesc("testFieldDesc");
////		field.setPerfModuleIndex(index);
////
////		HashSet<PerfIndexFieldEntity> indexDescriptors = new HashSet<PerfIndexFieldEntity>();
////		indexDescriptors.add(field);
////		index.setIndexDescriptors(indexDescriptors);
////
////		try {
////			Session s = sessionFactory.getCurrentSession();
////			s.beginTransaction();
////
////			s.save(module);
////			s.getTransaction().commit();
////		} catch (Exception ex) {
////			ex.getMessage();
////		}
//	}
////
////	public void testCase2() {
////		PerfProjectEntity srcProject = new PerfProjectEntity();
////		srcProject.setProjectCases(new HashSet<CaseEntity>());
////		srcProject.setProjectDesc("srcProjectDesc");
////		srcProject.setPrototype("srcProjectPrototype");
////		srcProject.setRunRecord(new HashSet<PerfResMetaEntryEntity>());
////		srcProject.setSysVer("srcProjectSysver");
////		srcProject.setCompPlotEntries(new HashSet<ProjectCompPlotEntryEntity>());
////		
////		PerfProjectEntity dstProject = new PerfProjectEntity();
////		dstProject.setProjectCases(new HashSet<CaseEntity>());
////		dstProject.setProjectDesc("dstProjectDesc");
////		dstProject.setPrototype("dstProjectPrototype");
////		dstProject.setRunRecord(new HashSet<PerfResMetaEntryEntity>());
////		dstProject.setSysVer("dstProjectSysver");
////		dstProject.setCompPlotEntries(new HashSet<ProjectCompPlotEntryEntity>());
////
////		try {
////			Session s = sessionFactory.getCurrentSession();
////			s.beginTransaction();
////
////			s.save(srcProject);
////			s.save(dstProject);
////			s.getTransaction().commit();
////		} catch (Exception ex) {
////			ex.getMessage();
////		}
////	}
////	
////	public void testcase3()
////	{
////		Session s = sessionFactory.getCurrentSession();
////		try{
////		s.beginTransaction();
////		Query query = s.createQuery("from PerfProjectEntity");
////		List<PerfProjectEntity> l = query.list();
////		PerfProjectEntity src = l.get(0);
////		PerfProjectEntity dst = l.get(1);
////		ProjectCompPlotEntryEntity plot = new ProjectCompPlotEntryEntity();
////		plot.setSrcProject(src);
////		plot.setDstProject(dst);
////		plot.setRunSeq(0);
////		s.save(plot);
////		s.getTransaction().commit();
////		
////		}catch(Exception ex)
////		{
////			ex.getMessage();
////		}
////
////	}
////
////	public void testcase4()
////	{
////		Session s = sessionFactory.getCurrentSession();
////		s.beginTransaction();
////		Query query = s.createQuery("from ProjectCompPlotEntryEntity");
////		List<ProjectCompPlotEntryEntity> l = query.list();
////		ProjectCompPlotEntryEntity p = l.get(0);
////		PerfProjectEntity pro = p.getDstProject();
////		pro.getPrototype();
////		String prototype = pro.getPrototype();
////		String sysver = pro.getSysVer();
////	}
////	
////	public void testcase5()
////	{
////		Session s = sessionFactory.getCurrentSession();
////		s.beginTransaction();
////		
////		ProjectCompPlotEntryEntity p1 = new ProjectCompPlotEntryEntity();
////		ProjectCompPlotEntryEntity p2 = new ProjectCompPlotEntryEntity();
////		
////		List<PerfProjectEntity> lst = s.createQuery("from PerfProjectEntity").list();
////		
////		PerfProjectEntity pro1 = lst.get(0);
////		PerfProjectEntity pro2 = lst.get(1);
////		PerfProjectEntity pro3 = lst.get(2);
////		
////		Set<ProjectCompPlotEntryEntity> myset = pro1.getCompPlotEntries();
////		for(ProjectCompPlotEntryEntity p : myset)
////		{
////			p.toString();
////		}
////		
//////		p1.setSrcProject(pro1);
//////		p1.setDstProject(pro2);
//////		p1.setRunSeq(0);
//////		
//////		p2.setSrcProject(pro1);
//////		p2.setDstProject(pro2);
//////		p2.setRunSeq(1);
//////		
//////		try{
//////			s.save(p1);
//////			s.save(p2);
//////		}catch(Exception ex)
//////		{
//////			ex.getCause();
//////		}
//////		
////		
////		s.getTransaction().commit();
////		
////	}
////	
////	public void testcase6()
////	{
////		Session s = sessionFactory.getCurrentSession();
////		s.beginTransaction();
////		
////		String hql = "from ";
////		
////		
////		s.getTransaction().commit();
////	}
////	
////	public void testcase7()
////	{
////		Session s = sessionFactory.getCurrentSession();
////		
////		s.beginTransaction();
////		
////		List lst = null;
////		try{
////		lst = s.createQuery("from PerfModuleEntity").list();
////		}
////		catch(Exception ex)
////		{
////			ex.getMessage();
////		}
////		PerfModuleEntity module = (PerfModuleEntity) lst.get(0);
////		
////		Set<PerfModuleIndexEntity> indices = module.getModuleIndices();
////		
////		List lst2 = s.createQuery("from PerfModuleIndexEntity p where p.id = '2'").list();
////		
////		PerfModuleIndexEntity index = (PerfModuleIndexEntity) lst2.get(0);
////		
////		s.delete(module);
////		
////		s.getTransaction().commit();
////	}
////	
////	public void testcase8()
////	{
////		Session s = sessionFactory.getCurrentSession();
////		
////		s.beginTransaction();
////		CaseGroupEntity c = new CaseGroupEntity();
////		//c.mkMirror(0);
////		s.getTransaction().commit();
////	}
////	
////
////	
////	public void testcase9()
////	{
////		Session s = sessionFactory.getCurrentSession();
////		
////		s.beginTransaction();
////		
////		
////		CaseEntity c = new CaseEntity();
////		c.setName("case123");
////		
////		PerfModuleEntity module = new PerfModuleEntity();
////		module.setModuleName("module123");
////		
////		c.setPerfModuleEntity(module);
////		
////		s.save(c);
////		s.getTransaction().commit();
////	}
////	
////	public void testcase10()
////	{
////		Session s = sessionFactory.getCurrentSession();
////		
////		s.beginTransaction();
////		
////		PerfModuleEntity module = (PerfModuleEntity)s.createQuery("from PerfModuleEntity p where p.id = '2'").list().get(0);
////		module.setModuleName("module123");
////		
////		PerfModuleEntity unknown = (PerfModuleEntity)s.createQuery("from PerfModuleEntity p where p.id = '3'").list().get(0);
////		for(CaseEntity c : module.getModuleCases())
////			c.setPerfModuleEntity(unknown);
////		s.delete(module);
////		try{
////			s.getTransaction().commit();
////		}catch(Exception ex)
////		{
////			ex.getMessage();
////		}
////	}
//}
