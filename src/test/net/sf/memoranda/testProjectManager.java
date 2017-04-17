package test.net.sf.memoranda;

import static org.junit.Assert.*;

import org.junit.Test;

import net.sf.memoranda.Project;
import net.sf.memoranda.ProjectManager;
import net.sf.memoranda.date.CalendarDate;

public class testProjectManager {
	CalendarDate cdate1 = new CalendarDate(2,3,2013);
	CalendarDate cdate2 = new CalendarDate(3,4,2013);

	
	@Test
	public void testCreateProject() {
		assertNotNull(ProjectManager.createProject("1","Test Title", cdate1, cdate2));
		assertTrue(ProjectManager.getActiveProjectsNumber() > 0);
	}

	@Test
	public void testRemoveProject() {
		int totalProj = ProjectManager.getAllProjectsNumber();
		ProjectManager.createProject("2","test title", cdate1, cdate2);
		ProjectManager.removeProject("This should not work");
		assertNotNull(ProjectManager.getActiveProjects());
		
		ProjectManager.removeProject("2");
		totalProj = ProjectManager.getAllProjectsNumber();
		assertEquals(1, totalProj);
		
	}

}
