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
 * Servlet implementation class recommendPic
 */
@WebServlet("/recommendPic")
public class recommendPic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recommendPic() {
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
		String username = request.getParameter("username");
		String index_str = request.getParameter("index");
		int index = Integer.parseInt(index_str);
		int index_max;
		if(index < 0) {
			index = 0;
		}
		if(index >= 20) {
			index = 19;
		}
		
		SomeFunction someFunction = new SomeFunction();
		List<String> pic_list = someFunction.findpic(username);
		index_max = pic_list.size();
		
		//判断是否越界，以及List是否为空，为空则附加一张图进去
		if(index >= index_max) {
			index = index_max - 1;
		}
		if(index_max <= 0) {
			pic_list.add("/home/gzx/2017-retrieval-image/test9.jpg");
			index = 0;
		}
		
		FileInputStream hFile = new FileInputStream(pic_list.get(index));
		
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
