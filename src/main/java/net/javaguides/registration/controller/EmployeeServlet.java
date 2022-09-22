package net.javaguides.registration.controller;

import java.io.FileWriter;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;




import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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
				System.out.println(data);
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
	        // Creating a workbook instances
	        Workbook wb = new HSSFWorkbook();
	 
	        // Creating output file
	        OutputStream os
	            = new FileOutputStream("Geeks.xlsx");
	 
	        // Creating a sheet using predefined class
	        // provided by Apache POI
	        Sheet sheet = wb.createSheet("Company Preparation");
	 
	        // Creating a row at specific position
	        // using predefined class provided by Apache POI
	 
	        // Specific row number
	        Row row = sheet.createRow(1);
	 
	        // Specific cell number
	        Cell cell = row.createCell(1);
	 
	        // putting value at specific position
	        cell.setCellValue("Geeks");
	 
	        // Finding index value of row and column of give
	        // cell
	        int rowIndex = cell.getRowIndex();
	        int columnIndex = cell.getColumnIndex();
	 
	        // Writing the content to Workbook
	        wb.write(os);
	 
	        // Printing the row and column index of cell created
	        System.out.println("Given cell is created at "
	                           + "(" + rowIndex + ","
	                           + columnIndex + ")");

//			worksheet.getCells().importArray(array2D, 0, 0);
//			workbook.save("C:\\Users\\wchen\\eclipse\\jee-2022-06\\eclipse\\excelOutput.xlsx");

			
		}
		catch (Exception E)
		{
			System.out.println("exception occured with the excel seet");
		}
	}

}
