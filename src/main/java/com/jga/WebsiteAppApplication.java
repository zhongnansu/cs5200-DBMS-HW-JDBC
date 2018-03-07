package com.jga;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jga.dao.DeveloperDao;
import com.jga.dao.PageDao;
import com.jga.dao.RoleDao;
import com.jga.dao.WebsiteDao;
import com.jga.dao.WidgetDao;
import com.jga.model.Developer;
import com.jga.model.HeadingWidget;
import com.jga.model.HtmlWidget;
import com.jga.model.ImageWidget;
import com.jga.model.Page;
import com.jga.model.Role;
import com.jga.model.Website;
import com.jga.model.Widget;
import com.jga.model.YouTubeWidget;

@SpringBootApplication
public class WebsiteAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsiteAppApplication.class, args);
		
		//get time now
		Date date=new Date(new java.util.Date().getTime());
	
		
		// create developers
		DeveloperDao developerDao =  DeveloperDao.getInstance();
		developerDao.createDeveloper(new Developer("Alice","Wonder", "alice", "alice", "alice@wonder.com", 12,"4321rewq"));
		developerDao.createDeveloper(new Developer("Bob","Marley", "bob", "bob", "bob@marley.com", 23,"5432trew"));
		developerDao.createDeveloper(new Developer("Charles","Garcia", "charlie", "charlie", "chuch@garcia.com", 34,"6543ytre"));
		developerDao.createDeveloper(new Developer("Dan","Martin", "dan", "dan", "alice@wonder.com", 45,"7654fda"));
		developerDao.createDeveloper(new Developer("Ed","Karaz", "ed", "ed", "alice@wonder.com", 56,"5678dfgh"));
	
		
//		Collection<Developer> d = developerDao.findAllDevelopers();
//		System.out.println(d);
		
		//Create Websites for Developers and create roles 
		
		WebsiteDao websiteDao =  WebsiteDao.getInstance();
		RoleDao roleDao = RoleDao.getInstance();
		
		
		Website facebook = new Website("Facebook", "an online social media and social networking service",date, date, 1234234, 123);
		Website twitter = new Website("Twitter", "an online news and social networking service",date, date, 4321543, 234);
		Website wikipedia = new Website("Wikipedia", "a free online encyclopedia",date, date, 3456654, 345);
		Website cnn = new Website("CNN", "an American basic cable and satellite television news channel",date, date, 1234234, 456);
		Website cnet = new Website("CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics",date, date, 1234234, 567);
		Website gizmodo = new Website("Gizmodo", "a design, technology, science and science fiction website that also writes articles on politics",date, date, 1234234, 678);

	
//		
//		
//		
		websiteDao.createWebsiteForDeveloper(12, facebook);
		roleDao.assignWebsiteRole(23, 123, "editor");
		roleDao.assignWebsiteRole(34, 123, "admin");

	
		websiteDao.createWebsiteForDeveloper(23, twitter);
		roleDao.assignWebsiteRole(34, 234, "editor");
		roleDao.assignWebsiteRole(12, 234, "admin");
		
		websiteDao.createWebsiteForDeveloper(34, wikipedia);
		roleDao.assignWebsiteRole(12, 345, "editor");
		roleDao.assignWebsiteRole(23, 345, "admin");

	
		websiteDao.createWebsiteForDeveloper(12, cnn);
		roleDao.assignWebsiteRole(34, 456, "editor");
		roleDao.assignWebsiteRole(12, 456, "admin");
		
		
		websiteDao.createWebsiteForDeveloper(23, cnet);
		roleDao.assignWebsiteRole(23, 567, "editor");
		roleDao.assignWebsiteRole(12, 567, "admin");

		
		websiteDao.createWebsiteForDeveloper(34, gizmodo);
		roleDao.assignWebsiteRole(12, 678, "editor");
		roleDao.assignWebsiteRole(23, 678, "admin");

		
		//Create pages for websites
		PageDao pageDao = PageDao.getInstance();
		
		Page home = new Page("Home", "Landing Page", date, date, 123434, 123);
		Page about = new Page("About", "Website Description", date, date, 234545, 234);
		Page contact = new Page("Contact", "Address, Phones and contact info", date, date, 345656, 345);
		Page preference = new Page("Preferences", "Where users can configure their preferences", date, date, 456776, 456);
		Page profile = new Page("Profile", "Users can configure their personal information", date, date, 567878, 567);
		
		pageDao.createPageForWebsite(567, home);
		pageDao.createPageForWebsite(678, about);
		pageDao.createPageForWebsite(345, contact);
		pageDao.createPageForWebsite(456, preference);
		pageDao.createPageForWebsite(567, profile);
		
		roleDao.assignPageRole(12, 123, "editor");
		roleDao.assignPageRole(23, 123, "reviewer");
		roleDao.assignPageRole(34, 123, "writer");
		
		roleDao.assignPageRole(23, 234, "editor");
		roleDao.assignPageRole(34, 234, "reviewer");
		roleDao.assignPageRole(12, 234, "writer");
		
		roleDao.assignPageRole(34, 345, "editor");
		roleDao.assignPageRole(12, 345, "reviewer");
		roleDao.assignPageRole(23, 345, "writer");
		
		roleDao.assignPageRole(12, 456, "editor");
		roleDao.assignPageRole(23, 456, "reviewer");
		roleDao.assignPageRole(34, 456, "writer");
		
		roleDao.assignPageRole(23, 567, "editor");
		roleDao.assignPageRole(34, 567, "reviewer");
		roleDao.assignPageRole(12, 567, "writer");
		
		//Create Widgets for pages
		WidgetDao widgetDao = WidgetDao.getInstance();
		
		HeadingWidget h1 = new HeadingWidget("head123", null, null, null, null, "Welcome", 0);
		HtmlWidget p1 = new HtmlWidget("post234", null, null, null, null, "<p>Lorem</p>", 0);
		HeadingWidget h2 = new HeadingWidget("head345", null, null, null, null, "Hi", 1);
		HtmlWidget i1 = new HtmlWidget("intro456", null, null, null, null, "<h1>Hi</h1>", 2);
		ImageWidget img = new ImageWidget("image345", 50, 100, null, null, null, 3, "/img/567.png");
		YouTubeWidget y = new YouTubeWidget("video456", 400, 300, null, null, null, 0, "https://youtu.be/h67VX51QXiQ\n");
		
		widgetDao.createWidgetForPage(123, h1);
		widgetDao.createWidgetForPage(234, p1);
		widgetDao.createWidgetForPage(345, h2);
		widgetDao.createWidgetForPage(345, i1);
		widgetDao.createWidgetForPage(456, img);
		widgetDao.createWidgetForPage(567, y);
		
		
		//Implement Updates
		
		//Update Developer
		Developer res = developerDao.findDeveloperByUsername("charlie");
		res.setPhone("333-444-5555");
		int resId = res.getId();
		developerDao.updateDeveloper(resId, res);
	
		// Update Widget
		
		Collection<Widget> w = widgetDao.findAllWidgets();
		for (Widget i : w) {
			String name = i.getName();
			int order = i.getOrder();
			int id = i.getId();
			if (name == "head123") {
					i.setOrder(3);
					widgetDao.updateWidget(id, i);
					continue;
			}
			if (name != "head123" && (order == 2 || order == 3)) {
				i.setOrder(order - 1);
				widgetDao.updateWidget(id, i);
			}		
		}
	
		
		//update page
		Collection<Page> pageResult = pageDao.findPagesForWebsite(567);
		for (Page p : pageResult) {
			p.setTitle("CNET - " + p.getTitle());
			pageDao.updatePage(p.getId(), p);
		}
		
		
		// update roles
		Developer bob = developerDao.findDeveloperByUsername("bob");
		Developer charlie = developerDao.findDeveloperByUsername("charlie");
		int bobId = bob.getId();
		int charlieId = charlie.getId();
		Collection<Website> web = websiteDao.findAllWebsites();
		int webId = 0;
		int pageId = 0;
		for (Website q : web) {
			if (q.getName() == "CNET") {
				webId = q.getId();
			}
		}
		Collection<Page> page = pageDao.findPagesForWebsite(webId);
		for (Page p : page) {
			if (p.getTitle() == "Home") {
				pageId = p.getId();
			}
		}
		roleDao.deletePageRole(bobId, pageId, "reviewer");
		roleDao.deletePageRole(charlieId, pageId, "writer");
		roleDao.assignPageRole(bobId, pageId, "writer");
		roleDao.assignPageRole(charlieId, pageId, "reviewer");
		
		
		//Delete developer
		Developer alice = developerDao.findDeveloperByUsername("alice");
		alice.setAddress(null);
		developerDao.updateDeveloper(alice.getId(), alice);
		
		
		//delete widgets
		
		Collection<Page> pages = pageDao.findAllPages();
		for (Page p : pages) {
			if (p.getTitle() == "Contact") {
				pageId = p.getId();
			}
		}
		
		int widgetId = 0;
		int max = 0;
		Collection<Widget> widgets = widgetDao.findWidgetsForPage(pageId);
		for (Widget w1 : widgets) {
			if (w1.getOrder() > max) {
				max = w1.getOrder();
			}
		}
		for (Widget w1 : widgets) {
			if (w1.getOrder() == max) {
				widgetId = w1.getId();
			}
		}
		widgetDao.deleteWidget(widgetId);
		
		//delete page
		for (Website q : web) {
			if (q.getName() == "Wikipedia") {
				webId = q.getId();
			}
		}
		Collection<Page> page1 = pageDao.findPagesForWebsite(webId);
		Page result = new Page();
		result.setUpdated(date);
		
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd"); 
		for (Page p : page1) {
			String s = fmt.format(result.getUpdated());
			String cur = fmt.format(p.getUpdated());
			if (Date.valueOf(cur).after(Date.valueOf(s))) {
				result = p;
			}
		}
		pageDao.deletePage(result.getId());
		
		
		
		
		//delete websites
		for (Website q : web) {
			if (q.getName() == "CNET") {
				webId = q.getId();
			}
		}
		
		websiteDao.deleteWebsite(webId);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
