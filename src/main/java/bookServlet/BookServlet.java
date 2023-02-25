package bookServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bookDAO.BookDAO;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDAO bookDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		bookDAO = new BookDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/insert": {
			insertBook(request, response);
			break;
		}

		case "/edit": {
			showEditForm(request, response);
			break;
		}

		case "/delete": {
			deleteBook(request, response);
			break;
		}

		case "/update": {
			updateBook(request, response);
			break;
		}

		case "/add": {
			newBook(request, response);
			break;
		}
		default:
			showBooks(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	/*
	 *  used to fetch data from DB 
	 *  forwarding data to BookList.jsp to show the data in the table
	 *  
	 */
	protected void showBooks(HttpServletRequest req , HttpServletResponse resp) {
	  List<Book> list = bookDAO.getBooks();
	  req.setAttribute("Books", list);
	  RequestDispatcher dispatcher = req.getRequestDispatcher("/BookList.jsp");
	  try {
		dispatcher.forward(req, resp);
	} catch (ServletException | IOException e) {
		e.printStackTrace();
	}
	}
	
	/*
	 * used to show Form to insert new book
	 */
	protected void newBook(HttpServletRequest request , HttpServletResponse response) throws ServletException {
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Form.jsp");
			dispatcher.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * used to get book data from form 
	 * and inserting data into DB
	 */
	protected void insertBook(HttpServletRequest request , HttpServletResponse response) throws IOException {
		Book book = new Book();
		book.setBook_id(Integer.parseInt(request.getParameter("book-id")));
		book.setTitle(request.getParameter("title"));
		book.setPrice(Float.parseFloat(request.getParameter("price")));
		book.setAuthor(request.getParameter("author"));
		
		BookDAO dao = new BookDAO();
		dao.insertBook(book);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
	
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	
	/*
	 * used to show Form.jsp 
	 * to edit Book data by using parameter of edit button ( id )
	 */
	protected void showEditForm(HttpServletRequest request , HttpServletResponse response) throws ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		Book book = new BookDAO().getBook(id);
		request.setAttribute("Book", book);
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Form.jsp");
			dispatcher.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 /*
	  * used to update data of book
	  */
	protected void updateBook(HttpServletRequest request , HttpServletResponse response) throws IOException {
		Book book = new Book();
		book.setBook_id(Integer.parseInt(request.getParameter("book-id")));
		book.setTitle(request.getParameter("title"));
		book.setPrice(Float.parseFloat(request.getParameter("price")));
		book.setAuthor(request.getParameter("author"));
		
		BookDAO dao = new BookDAO();
		dao.updateBook(book);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
	
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	
	/*
	 * used to delete book
	 */
	protected void deleteBook(HttpServletRequest request , HttpServletResponse response) throws ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		BookDAO dao = new BookDAO();
		dao.deleteBook(id);
		try {
			response.sendRedirect("reload");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


}
