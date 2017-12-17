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
 * Servlet implementation class returnClothInfo2
 */
@WebServlet("/returnClothInfo2")
public class returnClothInfo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public returnClothInfo2() {
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
		String length_value = request.getParameter("length_value");
		String sleeve_value = request.getParameter("sleeve_value");
		String collar_value = request.getParameter("collar_value");
		String model_value = request.getParameter("model_value");
		String pattern_value = request.getParameter("pattern_value");
		
		SomeFunction someFunction = new SomeFunction();
		List<String> pic_list = someFunction.findpicFromValue(length_value, sleeve_value, collar_value, model_value, pattern_value);
		
		String pic_name = pic_list.get(0);
		String info_list = someFunction.findinfo(pic_name);
		
		PrintWriter out = response.getWriter();
		java.util.Date d=new java.util.Date();
		out.write(info_list);
		System.out.println(d.toString()+" successful send cloth info\n");
		out.flush();
		out.close();
	}

}
