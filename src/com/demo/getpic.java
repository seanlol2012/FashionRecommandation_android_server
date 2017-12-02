package com.demo;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fashion_server.SomeFunction;

/**
 * Servlet implementation class getpic
 */
@WebServlet("/getpic")
public class getpic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getpic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pic_name = "/home/gzx/UploadImg/";
		List<String> pic_list = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		pic_name = pic_name + sdf.format(date);
		pic_name = pic_name + ".jpg";
		
		HashMap<String, String> listClothInfo = new HashMap<String, String>();
		
		PrintWriter out = response.getWriter();
		System.out.println("begin to receive pic from client");
		
		try(ServletInputStream sis = request.getInputStream()) {
			OutputStream os = new FileOutputStream(pic_name);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			byte[] buf = new byte[1024];
			int length = 0;
			
			length = sis.readLine(buf, 0, buf.length);
			while(length != -1) {
				bos.write(buf, 0, length);
				length = sis.read(buf);
			}
			sis.close();
			bos.close();
			os.close();
			
			//每次仅放入一张图像，新图像上传后将重新刷新缓冲区
			String input_image_path = "/home/gzx/new_net/caffe-master/input_image.txt";
			File input_image_file = new File(input_image_path);
			BufferedWriter bw = new BufferedWriter(new FileWriter(input_image_file));
			bw.write(pic_name + "\n");
			bw.flush();
			bw.close();
			
			String shell_path = "/home/gzx/new_net/caffe-master/analyse_upload_pic.sh";
			try {
				Runtime.getRuntime().exec(shell_path).waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//读取上传图像对应的属性信息
			String output_info_path = "/home/gzx/new_net/caffe-master/out.txt";
			File output_info_file = new File(output_info_path);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(output_info_file));
			BufferedReader br = new BufferedReader(reader);
			String read_line = "";
			read_line = br.readLine();
			while(read_line != null) {
				System.out.println(read_line);
				
				String[] attr_value = read_line.split(" ");
				listClothInfo.put("length_short", attr_value[1]);
				listClothInfo.put("length_mid", attr_value[2]);
				listClothInfo.put("length_long", attr_value[3]);
				listClothInfo.put("sleeve_length_sleeveless", attr_value[4]);
				listClothInfo.put("sleeve_length_short", attr_value[5]);
				listClothInfo.put("sleeve_length_long", attr_value[6]);
				listClothInfo.put("collar_shape_stand", attr_value[7]);
				listClothInfo.put("collar_shape_V", attr_value[8]);
				listClothInfo.put("collar_shape_bateau", attr_value[9]);
				listClothInfo.put("collar_shape_round", attr_value[10]);
				listClothInfo.put("collar_shape_lapel", attr_value[11]);
				listClothInfo.put("collar_shape_high", attr_value[12]);
				listClothInfo.put("collar_shape_hoodie", attr_value[13]);
				listClothInfo.put("model_tight", attr_value[14]);
				listClothInfo.put("model_straight", attr_value[15]);
				listClothInfo.put("model_loose", attr_value[16]);
				listClothInfo.put("pattern_pure", attr_value[17]);
				listClothInfo.put("pattern_grid", attr_value[18]);
				listClothInfo.put("pattern_dot", attr_value[19]);
				listClothInfo.put("pattern_floral", attr_value[20]);
				listClothInfo.put("pattern_cross-stripe", attr_value[21]);
				listClothInfo.put("pattern_vertical-stripe", attr_value[22]);
				listClothInfo.put("pattern_number&letter", attr_value[23]);
				listClothInfo.put("pattern_repeat", attr_value[24]);
				listClothInfo.put("pants_length_short", attr_value[25]);
				listClothInfo.put("pants_length_mid", attr_value[26]);
				listClothInfo.put("pants_length_long", attr_value[27]);
				listClothInfo.put("pants_pattern_pure", attr_value[28]);
				listClothInfo.put("pants_pattern_grid", attr_value[29]);
				listClothInfo.put("pants_pattern_dot", attr_value[30]);
				listClothInfo.put("pants_pattern_floral", attr_value[31]);
				listClothInfo.put("pants_pattern_cross-stripe", attr_value[32]);
				listClothInfo.put("pants_pattern_vertical-stripe", attr_value[33]);
				listClothInfo.put("pants_pattern_number&letter", attr_value[34]);
				listClothInfo.put("pants_pattern_repeat", attr_value[35]);
				listClothInfo.put("pants_model_straight", attr_value[36]);
				listClothInfo.put("pants_model_tight", attr_value[37]);
				listClothInfo.put("pants_model_loose", attr_value[38]);
				listClothInfo.put("skirt_length_short", attr_value[39]);
				listClothInfo.put("skirt_length_mid", attr_value[40]);
				listClothInfo.put("skirt_length_long", attr_value[41]);
				listClothInfo.put("skirt_model_package-hip", attr_value[42]);
				listClothInfo.put("skirt_model_A-sharp", attr_value[43]);
				listClothInfo.put("skirt_pattern_pure", attr_value[44]);
				listClothInfo.put("skirt_pattern_grid", attr_value[45]);
				listClothInfo.put("skirt_pattern_dot", attr_value[46]);
				listClothInfo.put("skirt_pattern_floral", attr_value[47]);
				listClothInfo.put("skirt_pattern_cross-stripe", attr_value[48]);
				listClothInfo.put("skirt_pattern_vertical-stripe", attr_value[49]);
				listClothInfo.put("skirt_pattern_number&letter", attr_value[50]);
				listClothInfo.put("skirt_pattern_repeat", attr_value[51]);
				
				//返回根据上传图像分析检索十张相近图像路径的列表
				SomeFunction someFunction = new SomeFunction();
				pic_list = someFunction.fromInfoFindPic(listClothInfo);
				
				read_line = br.readLine();
			}
			br.close();
			
			System.out.println("successful received pic from client");
			System.out.println("getpic: return: " + pic_list.get(0));
			out.write(pic_list.get(0));
			
			out.flush();
			out.close();
		}
	}

}
