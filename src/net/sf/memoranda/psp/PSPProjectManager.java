/**
 * 
 */
package net.sf.memoranda.psp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import net.sf.memoranda.psp.PSPProject.PSPType;

/**
 * @author Terry Turner
 *
 */

public class PSPProjectManager {

	static String fileName = "PSPProjects.ser";
	static int count = 0;
	public static List<PSPProject> Projects = new ArrayList<>();

	// Map<String, PSPProject> pspProjectMap = null;

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PSPProjectManager() {
		// pspProjectMap = new HashMap<String, PSPProject>();
		File file = new File(fileName);
		ObjectInputStream in = null;

		try {
			if (file.createNewFile())
				System.out.println("file created");
			if (file.exists()) {
				System.out.println("Reading from file " + fileName + "...");
				System.out.println(file.getAbsolutePath());
				in = new ObjectInputStream(new FileInputStream(file));
				Projects = (List<PSPProject>) in.readObject();
				PSPProject.setCounter(Projects.size());
			}
		} catch (Exception e) {
			//System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		}
	}

	/**
	 * @return
	 */
	public boolean newProject(String ProjectName, String Description, PSPType Type) {
		PSPProject Project = new PSPProject();
		Project.setDescription(Description);
		Project.setPSP(Type);
		Project.setProjectName(ProjectName);
		Project.setPhase(PSPPhase.PLANNING);
		try {
			Projects.add(Project);
		} catch (Exception exc) {
			return false;
		}
		return true;

	}

	/**
	 * @return
	 */
	public boolean updateProject() {
		return true;
	}

	/**
	 * @return
	 */
	public boolean deleteProject(int ID) {
		// PSPProject Project = pspProjectMap.get(ID + "");

		// if (Project == null) {
		// return false;
		// } else {
		//// pspProjectMap.remove(ID + "");
		// }
		return true;
	}

	/**
	 * @return
	 */
	public PSPProject getProject(int ID) {
		PSPProject Project = null;
		for (PSPProject P : Projects) {
			if (ID == P.getID())
				Project = P;
		}
		if (Project == null) {
			throw new IllegalArgumentException("There is no such project");
		}
			return Project;
	}

	/**
	 * @return
	 */
	public List<PSPProject> getAllProjects() {

		return Projects;
	}
 
	/**
	 * Save Projects to File
	 */
	public void saveProjects() throws IOException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(Projects);
		} catch (Exception e) {
			//e.printStackTrace();
			throw new IOException("Could not write file:" + fileName);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		}
	}

	/**
	 * @return
	 */
	public boolean addDefectLog(int ID, DefectEntry entry) {
		Projects.get(ID).DefectLog.addEntry(entry);
		try {
			saveProjects();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean addRequirementLog(int ID, Requirements entry) {
		Projects.get(ID).Requirements.addRequirements(entry);
		try {
			saveProjects();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
