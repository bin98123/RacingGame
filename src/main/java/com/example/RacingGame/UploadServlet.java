package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.ProfileDAO;
import dao.ProfileUser;
import dao.UserDetails;

/**
 * A Java servlet that handles file upload from client.
 *
 * @author www.codejava.net
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIRECTORY = "upload";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	/**
	 * handles file upload via HTTP POST method
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// checks if the request actually contains upload file
		String path = null;
		String UID = request.getParameter("User");
		String nameImg = null;
		ProfileUser profileUser = new ProfileUser();
		ProfileDAO dao = new ProfileDAO();
		UserDetails user = new UserDetails();
		user.setUserID(UID);
		user = new UserDetails(UID, null, null, null, null, 0, 0);
		profileUser.setId(UID);
		profileUser = new ProfileUser(UID, null);
		if (!ServletFileUpload.isMultipartContent(request)) {
			PrintWriter writer = response.getWriter();
			writer.println("Request does not contain upload data");
			writer.flush();
			return;
		}

		// configures upload settings
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);
		// constructs the directory path to store upload file:
		// "F:\CPU-Z\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\UploadServletApp\\upload"
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
//		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY + "\\"
//				+ profileUser.getId();
		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			// parses the request's content to extract file data
			List formItems = upload.parseRequest(request);
			Iterator iter = formItems.iterator();

			// iterates over form's fields
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				// processes only fields that are not form fields
				if (!item.isFormField()) {
					String fileName = new File(item.getName()).getName();
					String filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);
					nameImg = fileName;
					dao.removePic();
					dao.findPic();
					path = dao.findPic();
					item.write(storeFile);
				}
			}
			profileUser.setPhoto(nameImg);
			request.setAttribute("pic", path);
			request.setAttribute("namePic", nameImg);
			request.setAttribute("profileUser", profileUser);
		} catch (Exception ex) {
			request.setAttribute("message", "There was an error: " + ex.getMessage());
		}
		getServletContext().getRequestDispatcher("/ViewProfile.jsp").forward(request, response);
	}
}
