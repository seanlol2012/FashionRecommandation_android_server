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
 * Servlet implementation class re_returnClothInfo
 */
@WebServlet("/re_returnClothInfo")
public class re_returnClothInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public re_returnClothInfo() {
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
		String pic_name = request.getParameter("recommend_pic_name");
		
		SomeFunction someFunction = new SomeFunction();
		String info_list = someFunction.findinfo(pic_name);
		
		PrintWriter out = response.getWriter();
		java.util.Date d=new java.util.Date();
		out.write(info_list);
		System.out.println(d.toString()+" successful send recommend cloth info\n");
		out.flush();
		out.close();
	}

}
