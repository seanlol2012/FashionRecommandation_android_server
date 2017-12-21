package com.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fashion_server.SomeFunction;

/**
 * Servlet implementation class recommendPic2
 */
@WebServlet("/recommendPic2")
public class recommendPic2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recommendPic2() {
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
		
		FileInputStream hFile = new FileInputStream(pic_name);
		
		//得到数据大小
		int hFile_size = hFile.available();
		byte data[] = new byte[hFile_size];
		
		//读数据
		hFile.read(data);
		//得到向客户端输出二进制数据的对象并输出数据
		OutputStream toClient = response.getOutputStream();
		//输出数据
		toClient.write(data);
		toClient.flush();
		toClient.close();
		hFile.close();
	}

}
