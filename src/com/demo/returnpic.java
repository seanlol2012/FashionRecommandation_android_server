package com.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class returnpic
 */
@WebServlet("/returnpic")
public class returnpic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public returnpic() {
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
		FileInputStream hFile = new FileInputStream("/home/gzx/2017-retrieval-image/test9.jpg");
		
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
