package net.javaguides.registration.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public search() {
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
			// if (request.getParameter("submit") != null) {

			PrintWriter out = response.getWriter();
			out.println("Welcome to Search HI");

			String toBeSearched = request.getParameter("search");
			out.println("To Be Searched: " + toBeSearched);
			searchFunction ( toBeSearched ); 
		} catch (Exception e) {
			System.out.println("there is an error in the doPost method <br>");
			e.printStackTrace();
		}

		doGet(request, response);
	}
	
	private void searchFunction ( String toBeSearched )
	{
		try {
			File myObj = new File("C:\\Users\\wchen\\eclipse\\jee-2022-06\\eclipse\\filenameNew.txt");
			Scanner myReader = new Scanner(myObj);
			
			int count = 0; 
			while (myReader.hasNextLine()) 
			{
				String data = myReader.nextLine().toLowerCase().toString();
				if ( data.contains(toBeSearched))
				{
				System.out.println(data);
				count++;
				}
			}
			
			System.out.println("Number of times your inquiry is in the file " + count);
			myReader.close();
		} catch (NullPointerException e) {
			System.out.println("File not found here");
		} catch (Exception e) {
			System.out.println("exception occured");
		}
	}

}
