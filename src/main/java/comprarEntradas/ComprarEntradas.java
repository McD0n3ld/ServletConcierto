package comprarEntradas;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import compras.entradas;

/**
 * Servlet implementation class ComprarEntradas
 */
public class ComprarEntradas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ComprarEntradas() {

		// llenar la clase
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session == null) {
			res.sendRedirect("http://localhost:8080/error.html");
		}
		Vector buylist = (Vector) session.getValue("compras.shoppingcart");
		String action = req.getParameter("action");
		if (action.equals("ADD")) {
			boolean match = false;
			entradas e = getEntradas(req);
			if (buylist == null) {
				buylist = new Vector();
				buylist.addElement(e);
			} else {
				for (int i = 0; i < buylist.size(); i++) {
					entradas en = (entradas) buylist.elementAt(i);
					en.setCantidad(en.getCantidad() + e.getCantidad());
					buylist.setElementAt(en, i);
					match = true;
				}
				if (!match)
					buylist.addElement(e);
			}
		}
		session.putValue("compras.shoppingcart", buylist);
		String url = "/comprar.jsp";
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(req, res);
	}

	private entradas getEntradas(HttpServletRequest req) {
		String myEntrada = req.getParameter("ENTRADA");
		String qty = req.getParameter("cantidad");
		StringTokenizer t = new StringTokenizer(myEntrada, "|");
		entradas e = new entradas();
		e.setEstado(false);
		e.setId_entrada(-1);
		e.setNombre_concierto(t.nextToken());
		e.setTipo(t.nextToken());
		e.setCantidad(qty);
		return e;
	}

}
