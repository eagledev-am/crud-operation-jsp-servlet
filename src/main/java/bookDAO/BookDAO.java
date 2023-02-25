package bookDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Book;


public class BookDAO {

	private static String url = "jdbc:mysql://localhost/bookstore";
	private static String userName = "root";
	private static String password = "";

	public static Connection connect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, userName, password);
	}

	// insert Book
	public void insertBook(Book book) {

		try {
			
			Connection connection = connect();
			int Book_id = book.getBook_id();
			String author = book.getAuthor();
			String title = book.getTitle();
			float price = book.getPrice();
			String query = "insert into book values (? , ? , ? , ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, Book_id);
			statement.setString(2, title);
			statement.setString(3, author);
			statement.setFloat(4, price);
			statement.execute();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// select all Books
	public List<Book> getBooks() {
		List<Book> listOfBooks = null;
		try {
			
			Connection connection = connect();
			String query = "select * from book";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet set = statement.executeQuery();
			Book book = null;
			listOfBooks = new ArrayList<Book>();
			while (set.next()) {
				book = new Book();
				book.setBook_id(set.getInt(1));
				book.setTitle(set.getString(2));
				book.setAuthor(set.getString(3));
				book.setPrice(set.getFloat(4));
			    listOfBooks.add(book);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return listOfBooks;
	}

	// get book by id

	public Book getBook(int bookId) {
		Book book = null;
		try {
			Connection connection = connect();
			String query = "select * from book where book_id = " + bookId;
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet set = statement.executeQuery();
			book = new Book();
			while (set.next()) {
				int book_id = set.getInt(1);
				String title = set.getString(2);
				String author = set.getString(3);
				float price = set.getFloat(4);
				book.setBook_id(book_id);
				book.setAuthor(author);
				book.setTitle(title);
				book.setPrice(price);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	// update_book

	public boolean updateBook(Book book) {
		int rowUpdated = 0;
		try {
			Connection connection = connect();
			String query = "update book set book_id = ? , title= ? , author= ? , price = ? where book_id = " + book.getBook_id();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, book.getBook_id());
			statement.setString(2, book.getTitle());
			statement.setString(3, book.getAuthor());
			statement.setFloat(4, book.getPrice());
			rowUpdated = statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowUpdated > 0;
	}

	// delete Book

	public boolean deleteBook(int book_id) {
		boolean rowUpdated = false;
		try {
			Connection connection = connect();
			String query = "delete from book where book_id = " + book_id;
			PreparedStatement statement = connection.prepareStatement(query);
			rowUpdated = statement.executeUpdate() > 0;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowUpdated;
	}
}