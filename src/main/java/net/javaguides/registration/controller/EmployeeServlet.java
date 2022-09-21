package net.javaguides.registration.controller;

import java.io.FileWriter;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;



import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.registration.model.Employee;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	private EmployeeDao employeeDao = new EmployeeDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
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

		try {

				PrintWriter out = response.getWriter();
				out.println("You have successfully registered"); 
				
				System.out.println("this is working");

				String name = request.getParameter("username");
				String text = request.getParameter("password");

				// this calls the function and writes to filename.txt the username and password
				writeFile(name, text);
				
				// this closes opens filename.txt and prints to the screen.
				readFile("C:\\Users\\wchen\\eclipse\\jee-2022-06\\eclipse\\filenameNew.txt");
				
				//this exports the data as an excel 2 d array 
				
				
				
		} catch (Exception e) {
			System.out.println("there is an error in the doPost method possibly");
			e.printStackTrace();
		}

	}

	// this function writes to filNameNew
	// the username and the password of the form received.
	private static void writeFile(String username, String password) throws IOException {
		try {
			FileWriter myWriter = new FileWriter("filenameNew.txt", true);
			myWriter.write("am i writing anything please\n");
			myWriter.write(username + "\n");
			myWriter.write(password + "\n");
			myWriter.close();
		} catch (Exception e) {
			System.out.println("exception occurred");
		}
	}

	// this function reads from file "filename.txt"
	// this prints to the system after reading everything from
	// filename.txt
	private static void readFile(String inputFileName) throws IOException {
		try {
			int count = 0;
			File myObj = new File(inputFileName);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
			//	System.out.println(data);
				count++;
			}
			myReader.close();
			
			exportFile ("C:\\Users\\wchen\\eclipse\\jee-2022-06\\eclipse\\filenameNew.txt", count);
		} catch (NullPointerException e) {
			System.out.println("File not found here");
		} catch (Exception e) {
			System.out.println("exception occured");
		}

	}
	
	private static void exportFile ( String inputFileName, int size )
	{
		try {
			//System.out.println("the export file works up to this point I guess");
			Workbook workbook = new Workbook("C:\\Users\\wchen\\eclipse\\jee-2022-06\\eclipse\\excelOutput.xlsx");
			Worksheet worksheet = workbook.getWorksheets().get(0);
			int [][] array2D = new int [size/2][2];
			int count = 0; 
			File myObj = new File(inputFileName);
			Scanner myReader = new Scanner(myObj);
			System.out.println("the export file works up to this point I guess");
	
			for ( int i =0; i < size/2; i ++ ) 
			{
				for ( int j = 0; j < 2; j ++ ) 
				{
				String data = myReader.nextLine();
				
				if ( count % 2 == 0 )
				{
					array2D[i][j] = count;
					System.out.println(array2D[i][j]);
				}
				else {
					array2D[i][j] = count;
					System.out.println(array2D[i][j]);
				}
				count++;
				}
			}
			myReader.close();
			String[] names = new String[] { "Laurence Chen", "Roman Korchagin", "Kyle Huang" };
			worksheet.getCells().importArray(names, 0, 0, true);

//			worksheet.getCells().importArray(array2D, 0, 0);
//			workbook.save("C:\\Users\\wchen\\eclipse\\jee-2022-06\\eclipse\\excelOutput.xlsx");
			workbook.save("C:\\Files\\output.xlsx");
			
			
		}
		catch (Exception E)
		{
			System.out.println("exception occured with the excel seet");
		}
	}

}
