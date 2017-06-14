package multimedia;

import java.io.IOException;

@SuppressWarnings("serial")
public class MultimediaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
