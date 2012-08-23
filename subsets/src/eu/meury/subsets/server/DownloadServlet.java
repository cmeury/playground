package eu.meury.subsets.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Very simple servlet that takes a GET parameter and serves it as a text file.
 *
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String list = req.getParameter("list");
		
		resp.setContentType("text/*");
		PrintWriter out = resp.getWriter();
		out.println(list);
	}
}
