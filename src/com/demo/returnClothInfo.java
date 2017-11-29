package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fashion_server.SomeFunction;

/**
 * Servlet implementation class returnClothInfo
 */
@WebServlet("/returnClothInfo")
public class returnClothInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public returnClothInfo() {
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
		String username = request.getParameter("username");
		String index_str = request.getParameter("index");
		int index = Integer.parseInt(index_str);
		
		SomeFunction someFunction = new SomeFunction();
		List<String> pic_list = someFunction.findpic(username);
		
		String pic_name = pic_list.get(index);
		String info_list = someFunction.findinfo(pic_name);
		
		PrintWriter out = response.getWriter();
		java.util.Date d=new java.util.Date();
		out.write(info_list);
		System.out.println(d.toString()+" successful send cloth info\n");
		out.flush();
		out.close();
	}
}
