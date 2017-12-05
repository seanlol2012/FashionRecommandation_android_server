package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fashion_server.SomeFunction;

/**
 * Servlet implementation class getFeedbackLevel
 */
@WebServlet("/getFeedbackLevel")
public class getFeedbackLevel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getFeedbackLevel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String picname = request.getParameter("picname");
		String feedbackLevel = request.getParameter("feedbackLevel");
		
		PrintWriter out = response.getWriter();
		SomeFunction someFunction = new SomeFunction();
		boolean flag = someFunction.updateDB(username, picname, feedbackLevel);
		java.util.Date d=new java.util.Date();
		if(flag) {
			out.write("server: failed to updata database");
			System.out.println(d.toString()+" failed to update database\n");
		} else {
			out.write("server: update database successfully");
			System.out.println(d.toString()+" successful updated database\n");
		}
		out.flush();
		out.close();
	}

}
