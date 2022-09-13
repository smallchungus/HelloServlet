
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/register")
public class HelloServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h2>Hello WORld again 2</h2>");
		out.print("</body></html>");
		System.out.println("this is working");
		String name = request.getParameter("username");
		String text = request.getParameter("password");
		out.print(name);

		FileWriter myWriter = new FileWriter("filenameNew.txt");
		myWriter.write("am i writing anything please\n");
		myWriter.write("Username " + name + "\n");
		myWriter.write("Password " + text + "\n");
		myWriter.close();
		
		readFile("C:\\Users\\wchen\\eclipse-workspace\\HelloServlet\\filename.txt");
		
		
//		File myObj = new File("C:\\Users\\wchen\\eclipse-workspace\\HelloServlet\\filename.txt");
//		Scanner myReader = new Scanner(myObj);
//		while (myReader.hasNextLine()) {
//			String data = myReader.nextLine();
//			System.out.println(data);
//		}
//		myReader.close();

		// doGet(request, response);
	}
	
	private static void writeFile ()
	throws IOException
	{
		
	}

	private static void readFile(String inputFileName)
	throws IOException
	{
		try {
        Scanner myReader = new Scanner(inputFileName);
        while ( myReader.hasNextLine())
        {
        	String data = myReader.nextLine();
        	System.out.println(data);
        }
        myReader.close();
		}
		catch (FileNotFoundException e )
		{
			System.out.println("File not found here");
		}
		catch (Exception e){
			System.out.println("exception occured");
		}
		
	}

}
