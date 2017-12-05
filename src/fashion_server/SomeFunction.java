package fashion_server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SomeFunction {
    public boolean login(String username, String password)
    {
    	boolean result = false;
    	ResultSet rs = null;
    	
    	DataBase getConn = new DataBase();
    	Connection conn = getConn.getConnection();
    	
    	try {
    		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_table WHERE name=? and password=?");
    		ps.setString(1, username);
    		ps.setString(2, password);
    		rs = ps.executeQuery();
    		if(rs.next()) {
    			result = true;
    		} else {
    			result = false;
    		}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	getConn.closeConnection(conn);
    	
    	return result;
    }
    
    //根据用户反馈更新数据库
    @SuppressWarnings("resource")
	public boolean updateDB(String username, String picname, String feedbackLevel)
    {
    	boolean result = false;
    	String user_ID;
    	HashMap<String, String> listClothInfo;
    	ResultSet rs = null;
    	
    	DataBase getConn = new DataBase();
    	Connection conn = getConn.getConnection();
    	
    	try {
    		PreparedStatement ps = conn.prepareStatement("SELECT user_ID FROM user_table WHERE name=?");
    		ps.setString(1, username);
    		rs = ps.executeQuery();
    		if(rs.next()) {
    			//获取用户ID
    			user_ID = rs.getString("user_ID");
    			
    			//获取图像的属性特征
    			listClothInfo = findinfo_hashmap(picname);
    			
    			//修改数据库
    			String pure, grid, dot, floral, cross_stripe, vertical_stripe, number_letter, repeat, favor_pattern;
    			float pure_int, grid_int, dot_int, floral_int, cross_stripe_int, vertical_stripe_int, number_letter_int, repeat_int, favor_int;
    			String sleeve_sleeveless, sleeve_short, sleeve_long, favor_sleeve;
    			float sleeve_sleeveless_int, sleeve_short_int, sleeve_long_int, favor_sleeve_int;
    			String tight, straight, loose, favor_model;
    			float tight_int, straight_int, loose_int, favor_model_int;
    			
    			//乘积比例
    			float temp_num;
    			//附加比例
    			float temp_num2;
    			if((feedbackLevel.equals("level1"))||(feedbackLevel.equals("level2"))) {
    				if(feedbackLevel.equals("level1")) {
    					temp_num = 0.975f;
    					temp_num2 = 0.025f;
    				} else {
    					temp_num = 0.9875f;
    					temp_num2 = 0.0125f;
    				}
    				//修改pattern
    				//pure
        			ps = conn.prepareStatement("SELECT pure FROM user_pre_pattern WHERE user_ID=?");
            		ps.setString(1, user_ID);
            		rs = ps.executeQuery();
            		if(rs.next()) {
            			pure = rs.getString("pure");
            			pure_int = Float.parseFloat(pure);
            			pure_int = pure_int * temp_num;
            			pure = pure_int + "";
            			ps = conn.prepareStatement("UPDATE user_pre_pattern SET pure=? WHERE user_ID=?");
                		ps.setString(1, pure);
                		ps.setString(2, user_ID);
                		ps.executeUpdate();
            		}
            		//grid
        			ps = conn.prepareStatement("SELECT grid FROM user_pre_pattern WHERE user_ID=?");
            		ps.setString(1, user_ID);
            		rs = ps.executeQuery();
            		if(rs.next()) {
            			grid = rs.getString("grid");
            			grid_int = Float.parseFloat(grid);
            			grid_int = grid_int * temp_num;
            			grid = grid_int + "";
            			ps = conn.prepareStatement("UPDATE user_pre_pattern SET grid=? WHERE user_ID=?");
                		ps.setString(1, grid);
                		ps.setString(2, user_ID);
                		ps.executeUpdate();
            		}
            		//dot
        			ps = conn.prepareStatement("SELECT dot FROM user_pre_pattern WHERE user_ID=?");
            		ps.setString(1, user_ID);
            		rs = ps.executeQuery();
            		if(rs.next()) {
            			dot = rs.getString("dot");
            			dot_int = Float.parseFloat(dot);
            			dot_int = dot_int * temp_num;
            			dot = dot_int + "";
            			ps = conn.prepareStatement("UPDATE user_pre_pattern SET dot=? WHERE user_ID=?");
                		ps.setString(1, dot);
                		ps.setString(2, user_ID);
                		ps.executeUpdate();
            		}
            		//floral
        			ps = conn.prepareStatement("SELECT floral FROM user_pre_pattern WHERE user_ID=?");
            		ps.setString(1, user_ID);
            		rs = ps.executeQuery();
            		if(rs.next()) {
            			floral = rs.getString("floral");
            			floral_int = Float.parseFloat(floral);
            			floral_int = floral_int * temp_num;
            			floral = floral_int + "";
            			ps = conn.prepareStatement("UPDATE user_pre_pattern SET floral=? WHERE user_ID=?");
                		ps.setString(1, floral);
                		ps.setString(2, user_ID);
                		ps.executeUpdate();
            		}
            		//cross_stripe
        			ps = conn.prepareStatement("SELECT cross_stripe FROM user_pre_pattern WHERE user_ID=?");
            		ps.setString(1, user_ID);
            		rs = ps.executeQuery();
            		if(rs.next()) {
            			cross_stripe = rs.getString("cross_stripe");
            			cross_stripe_int = Float.parseFloat(cross_stripe);
            			cross_stripe_int = cross_stripe_int * temp_num;
            			cross_stripe = cross_stripe_int + "";
            			ps = conn.prepareStatement("UPDATE user_pre_pattern SET cross_stripe=? WHERE user_ID=?");
                		ps.setString(1, cross_stripe);
                		ps.setString(2, user_ID);
                		ps.executeUpdate();
            		}
            		//vertical_stripe
        			ps = conn.prepareStatement("SELECT vertical_stripe FROM user_pre_pattern WHERE user_ID=?");
            		ps.setString(1, user_ID);
            		rs = ps.executeQuery();
            		if(rs.next()) {
            			vertical_stripe = rs.getString("vertical_stripe");
            			vertical_stripe_int = Float.parseFloat(vertical_stripe);
            			vertical_stripe_int = vertical_stripe_int * temp_num;
            			vertical_stripe = vertical_stripe_int + "";
            			ps = conn.prepareStatement("UPDATE user_pre_pattern SET vertical_stripe=? WHERE user_ID=?");
                		ps.setString(1, vertical_stripe);
                		ps.setString(2, user_ID);
                		ps.executeUpdate();
            		}
            		//number_letter
        			ps = conn.prepareStatement("SELECT number_letter FROM user_pre_pattern WHERE user_ID=?");
            		ps.setString(1, user_ID);
            		rs = ps.executeQuery();
            		if(rs.next()) {
            			number_letter = rs.getString("number_letter");
            			number_letter_int = Float.parseFloat(number_letter);
            			number_letter_int = number_letter_int * temp_num;
            			number_letter = number_letter_int + "";
            			ps = conn.prepareStatement("UPDATE user_pre_pattern SET number_letter=? WHERE user_ID=?");
                		ps.setString(1, number_letter);
                		ps.setString(2, user_ID);
                		ps.executeUpdate();
            		}
            		//repeat
        			ps = conn.prepareStatement("SELECT repeat FROM user_pre_pattern WHERE user_ID=?");
            		ps.setString(1, user_ID);
            		rs = ps.executeQuery();
            		if(rs.next()) {
            			repeat = rs.getString("repeat");
            			repeat_int = Float.parseFloat(repeat);
            			repeat_int = repeat_int * temp_num;
            			repeat = repeat_int + "";
            			ps = conn.prepareStatement("UPDATE user_pre_pattern SET repeat=? WHERE user_ID=?");
                		ps.setString(1, repeat);
                		ps.setString(2, user_ID);
                		ps.executeUpdate();
            		}
            		if(listClothInfo.get("pattern_pure").equals("1")) {
            			ps = conn.prepareStatement("SELECT pure FROM user_pre_pattern WHERE user_ID=?");
                		ps.setString(1, user_ID);
                		rs = ps.executeQuery();
                		if(rs.next()) {
                			pure = rs.getString("pure");
                			pure_int = Float.parseFloat(pure);
                			pure_int = pure_int + temp_num2;
                			pure = pure_int + "";
                			ps = conn.prepareStatement("UPDATE user_pre_pattern SET pure=? WHERE user_ID=?");
                    		ps.setString(1, pure);
                    		ps.setString(2, user_ID);
                    		ps.executeUpdate();
                		}
            		} else if(listClothInfo.get("pattern_grid").equals("1")) {
            			ps = conn.prepareStatement("SELECT grid FROM user_pre_pattern WHERE user_ID=?");
                		ps.setString(1, user_ID);
                		rs = ps.executeQuery();
                		if(rs.next()) {
                			grid = rs.getString("grid");
                			grid_int = Float.parseFloat(grid);
                			grid_int = grid_int + temp_num2;
                			grid = grid_int + "";
                			ps = conn.prepareStatement("UPDATE user_pre_pattern SET grid=? WHERE user_ID=?");
                    		ps.setString(1, grid);
                    		ps.setString(2, user_ID);
                    		ps.executeUpdate();
                		}
            		} else if(listClothInfo.get("pattern_dot").equals("1")) {
            			ps = conn.prepareStatement("SELECT dot FROM user_pre_pattern WHERE user_ID=?");
                		ps.setString(1, user_ID);
                		rs = ps.executeQuery();
                		if(rs.next()) {
                			dot = rs.getString("dot");
                			dot_int = Float.parseFloat(dot);
                			dot_int = dot_int + temp_num2;
                			dot = dot_int + "";
                			ps = conn.prepareStatement("UPDATE user_pre_pattern SET dot=? WHERE user_ID=?");
                    		ps.setString(1, dot);
                    		ps.setString(2, user_ID);
                    		ps.executeUpdate();
                		}
            		} else if(listClothInfo.get("pattern_floral").equals("1")) {
            			ps = conn.prepareStatement("SELECT floral FROM user_pre_pattern WHERE user_ID=?");
                		ps.setString(1, user_ID);
                		rs = ps.executeQuery();
                		if(rs.next()) {
                			floral = rs.getString("floral");
                			floral_int = Float.parseFloat(floral);
                			floral_int = floral_int + temp_num2;
                			floral = floral_int + "";
                			ps = conn.prepareStatement("UPDATE user_pre_pattern SET floral=? WHERE user_ID=?");
                    		ps.setString(1, floral);
                    		ps.setString(2, user_ID);
                    		ps.executeUpdate();
                		}
            		} else if(listClothInfo.get("pattern_cross-stripe").equals("1")) {
            			ps = conn.prepareStatement("SELECT cross_stripe FROM user_pre_pattern WHERE user_ID=?");
                		ps.setString(1, user_ID);
                		rs = ps.executeQuery();
                		if(rs.next()) {
                			cross_stripe = rs.getString("cross_stripe");
                			cross_stripe_int = Float.parseFloat(cross_stripe);
                			cross_stripe_int = cross_stripe_int + temp_num2;
                			cross_stripe = cross_stripe_int + "";
                			ps = conn.prepareStatement("UPDATE user_pre_pattern SET cross_stripe=? WHERE user_ID=?");
                    		ps.setString(1, cross_stripe);
                    		ps.setString(2, user_ID);
                    		ps.executeUpdate();
                		}
            		} else if(listClothInfo.get("pattern_vertical-stripe").equals("1")) {
            			ps = conn.prepareStatement("SELECT vertical_stripe FROM user_pre_pattern WHERE user_ID=?");
                		ps.setString(1, user_ID);
                		rs = ps.executeQuery();
                		if(rs.next()) {
                			vertical_stripe = rs.getString("vertical_stripe");
                			vertical_stripe_int = Float.parseFloat(vertical_stripe);
                			vertical_stripe_int = vertical_stripe_int + temp_num2;
                			vertical_stripe = vertical_stripe_int + "";
                			ps = conn.prepareStatement("UPDATE user_pre_pattern SET vertical_stripe=? WHERE user_ID=?");
                    		ps.setString(1, vertical_stripe);
                    		ps.setString(2, user_ID);
                    		ps.executeUpdate();
                		}
            		} else if(listClothInfo.get("pattern_number&letter").equals("1")) {
            			ps = conn.prepareStatement("SELECT number_letter FROM user_pre_pattern WHERE user_ID=?");
                		ps.setString(1, user_ID);
                		rs = ps.executeQuery();
                		if(rs.next()) {
                			number_letter = rs.getString("number_letter");
                			number_letter_int = Float.parseFloat(number_letter);
                			number_letter_int = number_letter_int + temp_num2;
                			number_letter = number_letter_int + "";
                			ps = conn.prepareStatement("UPDATE user_pre_pattern SET number_letter=? WHERE user_ID=?");
                    		ps.setString(1, number_letter);
                    		ps.setString(2, user_ID);
                    		ps.executeUpdate();
                		}
            		} else if(listClothInfo.get("pattern_repeat").equals("1")) {
            			ps = conn.prepareStatement("SELECT repeat FROM user_pre_pattern WHERE user_ID=?");
                		ps.setString(1, user_ID);
                		rs = ps.executeQuery();
                		if(rs.next()) {
                			repeat = rs.getString("repeat");
                			repeat_int = Float.parseFloat(repeat);
                			repeat_int = repeat_int + temp_num2;
                			repeat = repeat_int + "";
                			ps = conn.prepareStatement("UPDATE user_pre_pattern SET repeat=? WHERE user_ID=?");
                    		ps.setString(1, repeat);
                    		ps.setString(2, user_ID);
                    		ps.executeUpdate();
                		}
            		}
            		//修改sleeve_length
    				//sleeveless
        			ps = conn.prepareStatement("SELECT sleeveless FROM user_pre_sleeve_length WHERE user_ID=?");
            		ps.setString(1, user_ID);
            		rs = ps.executeQuery();
            		if(rs.next()) {
            			sleeve_sleeveless = rs.getString("sleeveless");
            			sleeve_sleeveless_int = Float.parseFloat(sleeve_sleeveless);
            			sleeve_sleeveless_int = sleeve_sleeveless_int * temp_num;
            			sleeve_sleeveless = sleeve_sleeveless_int + "";
            			ps = conn.prepareStatement("UPDATE user_pre_sleeve_length SET sleeveless=? WHERE user_ID=?");
                		ps.setString(1, sleeve_sleeveless);
                		ps.setString(2, user_ID);
                		ps.executeUpdate();
            		}
            		//short
        			ps = conn.prepareStatement("SELECT short FROM user_pre_sleeve_length WHERE user_ID=?");
            		ps.setString(1, user_ID);
            		rs = ps.executeQuery();
            		if(rs.next()) {
            			sleeve_short = rs.getString("short");
            			sleeve_short_int = Float.parseFloat(sleeve_short);
            			sleeve_short_int = sleeve_short_int * temp_num;
            			sleeve_short = sleeve_short_int + "";
            			ps = conn.prepareStatement("UPDATE user_pre_sleeve_length SET short=? WHERE user_ID=?");
                		ps.setString(1, sleeve_short);
                		ps.setString(2, user_ID);
                		ps.executeUpdate();
            		}
            		//long
        			ps = conn.prepareStatement("SELECT long FROM user_pre_sleeve_length WHERE user_ID=?");
            		ps.setString(1, user_ID);
            		rs = ps.executeQuery();
            		if(rs.next()) {
            			sleeve_long = rs.getString("long");
            			sleeve_long_int = Float.parseFloat(sleeve_long);
            			sleeve_long_int = sleeve_long_int * temp_num;
            			sleeve_long = sleeve_long_int + "";
            			ps = conn.prepareStatement("UPDATE user_pre_sleeve_length SET long=? WHERE user_ID=?");
                		ps.setString(1, sleeve_long);
                		ps.setString(2, user_ID);
                		ps.executeUpdate();
            		}
            		if(listClothInfo.get("sleeve_length_sleeveless").equals("1")) {
            			ps = conn.prepareStatement("SELECT sleeveless FROM user_pre_sleeve_length WHERE user_ID=?");
                		ps.setString(1, user_ID);
                		rs = ps.executeQuery();
                		if(rs.next()) {
                			sleeve_sleeveless = rs.getString("sleeveless");
                			sleeve_sleeveless_int = Float.parseFloat(sleeve_sleeveless);
                			sleeve_sleeveless_int = sleeve_sleeveless_int + temp_num2;
                			sleeve_sleeveless = sleeve_sleeveless_int + "";
                			ps = conn.prepareStatement("UPDATE user_pre_sleeve_length SET sleeveless=? WHERE user_ID=?");
                    		ps.setString(1, sleeve_sleeveless);
                    		ps.setString(2, user_ID);
                    		ps.executeUpdate();
                		}
            		} else if(listClothInfo.get("sleeve_length_short").equals("1")) {
            			ps = conn.prepareStatement("SELECT short FROM user_pre_sleeve_length WHERE user_ID=?");
                		ps.setString(1, user_ID);
                		rs = ps.executeQuery();
                		if(rs.next()) {
                			sleeve_short = rs.getString("short");
                			sleeve_short_int = Float.parseFloat(sleeve_short);
                			sleeve_short_int = sleeve_short_int + temp_num2;
                			sleeve_short = sleeve_short_int + "";
                			ps = conn.prepareStatement("UPDATE user_pre_sleeve_length SET short=? WHERE user_ID=?");
                    		ps.setString(1, sleeve_short);
                    		ps.setString(2, user_ID);
                    		ps.executeUpdate();
                		}
            		} else if(listClothInfo.get("sleeve_length_long").equals("1")) {
            			ps = conn.prepareStatement("SELECT long FROM user_pre_sleeve_length WHERE user_ID=?");
                		ps.setString(1, user_ID);
                		rs = ps.executeQuery();
                		if(rs.next()) {
                			sleeve_long = rs.getString("long");
                			sleeve_long_int = Float.parseFloat(sleeve_long);
                			sleeve_long_int = sleeve_long_int + temp_num2;
                			sleeve_long = sleeve_long_int + "";
                			ps = conn.prepareStatement("UPDATE user_pre_sleeve_length SET long=? WHERE user_ID=?");
                    		ps.setString(1, sleeve_long);
                    		ps.setString(2, user_ID);
                    		ps.executeUpdate();
                		}
            		}
            		//修改model
    				//tight
        			ps = conn.prepareStatement("SELECT tight FROM user_pre_model WHERE user_ID=?");
            		ps.setString(1, user_ID);
            		rs = ps.executeQuery();
            		if(rs.next()) {
            			tight = rs.getString("tight");
            			tight_int = Float.parseFloat(tight);
            			tight_int = tight_int * temp_num;
            			tight = tight_int + "";
            			ps = conn.prepareStatement("UPDATE user_pre_model SET tight=? WHERE user_ID=?");
                		ps.setString(1, tight);
                		ps.setString(2, user_ID);
                		ps.executeUpdate();
            		}
            		//straight
        			ps = conn.prepareStatement("SELECT straight FROM user_pre_model WHERE user_ID=?");
            		ps.setString(1, user_ID);
            		rs = ps.executeQuery();
            		if(rs.next()) {
            			straight = rs.getString("straight");
            			straight_int = Float.parseFloat(straight);
            			straight_int = straight_int * temp_num;
            			straight = straight_int + "";
            			ps = conn.prepareStatement("UPDATE user_pre_model SET straight=? WHERE user_ID=?");
                		ps.setString(1, straight);
                		ps.setString(2, user_ID);
                		ps.executeUpdate();
            		}
            		//loose
        			ps = conn.prepareStatement("SELECT loose FROM user_pre_model WHERE user_ID=?");
            		ps.setString(1, user_ID);
            		rs = ps.executeQuery();
            		if(rs.next()) {
            			loose = rs.getString("loose");
            			loose_int = Float.parseFloat(loose);
            			loose_int = loose_int * temp_num;
            			loose = loose_int + "";
            			ps = conn.prepareStatement("UPDATE user_pre_model SET loose=? WHERE user_ID=?");
                		ps.setString(1, loose);
                		ps.setString(2, user_ID);
                		ps.executeUpdate();
            		}
            		if(listClothInfo.get("model_loose").equals("1")) {
            			ps = conn.prepareStatement("SELECT loose FROM user_pre_model WHERE user_ID=?");
                		ps.setString(1, user_ID);
                		rs = ps.executeQuery();
                		if(rs.next()) {
                			loose = rs.getString("loose");
                			loose_int = Float.parseFloat(loose);
                			loose_int = loose_int + temp_num2;
                			loose = loose_int + "";
                			ps = conn.prepareStatement("UPDATE user_pre_model SET loose=? WHERE user_ID=?");
                    		ps.setString(1, loose);
                    		ps.setString(2, user_ID);
                    		ps.executeUpdate();
                		}
            		} else if(listClothInfo.get("model_tight").equals("1")) {
            			ps = conn.prepareStatement("SELECT tight FROM user_pre_model WHERE user_ID=?");
                		ps.setString(1, user_ID);
                		rs = ps.executeQuery();
                		if(rs.next()) {
                			tight = rs.getString("tight");
                			tight_int = Float.parseFloat(tight);
                			tight_int = tight_int + temp_num2;
                			tight = tight_int + "";
                			ps = conn.prepareStatement("UPDATE user_pre_model SET tight=? WHERE user_ID=?");
                    		ps.setString(1, tight);
                    		ps.setString(2, user_ID);
                    		ps.executeUpdate();
                		}
            		} else if(listClothInfo.get("model_straight").equals("1")) {
            			ps = conn.prepareStatement("SELECT straight FROM user_pre_model WHERE user_ID=?");
                		ps.setString(1, user_ID);
                		rs = ps.executeQuery();
                		if(rs.next()) {
                			straight = rs.getString("straight");
                			straight_int = Float.parseFloat(straight);
                			straight_int = straight_int + temp_num2;
                			straight = straight_int + "";
                			ps = conn.prepareStatement("UPDATE user_pre_model SET straight=? WHERE user_ID=?");
                    		ps.setString(1, straight);
                    		ps.setString(2, user_ID);
                    		ps.executeUpdate();
                		}
            		}
    			} else if(feedbackLevel.equals("level4")) {
    				temp_num = 0.0125f;
    			}
    		}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return result;
    }
    
    //根据服装属性推荐相似的服装图像
    public List<String> fromInfoFindPic(HashMap<String, String> listClothInfo)
    {
    	//定义一个list用于接受数据库查询到的pic_name的内容
    	List<String> list = new ArrayList<String>();
    	
    	//String result = "none";
    	ResultSet rs = null;
    	
    	DataBase getConn = new DataBase();
    	Connection conn = getConn.getConnection();
    	
    	//处理服装长度
    	String favor_length;
    	if(listClothInfo.get("length_long").equals("1")) {
    		favor_length = "length_long";
    	} else if(listClothInfo.get("length_short").equals("1")) {
    		favor_length = "length_short";
    	} else {
    		favor_length = "length_mid";
    	}
    	//处理袖长
    	String favor_sleeve_length;
    	if(listClothInfo.get("sleeve_length_sleeveless").equals("1")) {
    		favor_sleeve_length = "sleeve_length_sleeveless";
    	} else if(listClothInfo.get("sleeve_length_short").equals("1")) {
    		favor_sleeve_length = "sleeve_length_short";
    	} else {
    		favor_sleeve_length = "sleeve_length_long";
    	}
    	//处理领型
    	String favor_collar_shape;
    	if(listClothInfo.get("collar_shape_high").equals("1")) {
    		favor_collar_shape = "collar_shape_high";
    	} else if(listClothInfo.get("collar_shape_lapel").equals("1")) {
    		favor_collar_shape = "collar_shape_lapel";
    	} else if(listClothInfo.get("collar_shape_round").equals("1")) {
    		favor_collar_shape = "collar_shape_round";
    	} else if(listClothInfo.get("collar_shape_bateau").equals("1")) {
    		favor_collar_shape = "collar_shape_bateau";
    	} else if(listClothInfo.get("collar_shape_hoodie").equals("1")) {
    		favor_collar_shape = "collar_shape_hoodie";
    	} else if(listClothInfo.get("collar_shape_V").equals("1")) {
    		favor_collar_shape = "collar_shape_V";
    	} else {
    		favor_collar_shape = "collar_shape_stand";
    	}
    	//处理版型
    	String favor_model;
    	if(listClothInfo.get("model_loose").equals("1")) {
    		favor_model = "model_loose";
    	} else if(listClothInfo.get("model_tight").equals("1")) {
    		favor_model = "model_tight";
    	} else {
    		favor_model = "model_straight";
    	}
    	//处理印花
    	String favor_pattern;
    	if(listClothInfo.get("pattern_grid").equals("1")) {
    		favor_pattern = "pattern_grid";
    	} else if(listClothInfo.get("pattern_floral").equals("1")) {
    		favor_pattern = "pattern_floral";
    	} else if(listClothInfo.get("pattern_number&letter").equals("1")) {
    		favor_pattern = "pattern_number&letter";
    	} else if(listClothInfo.get("pattern_dot").equals("1")) {
    		favor_pattern = "pattern_dot";
    	} else if(listClothInfo.get("pattern_grid").equals("1")) {
    		favor_pattern = "pattern_grid";
    	} else if(listClothInfo.get("pattern_cross-stripe").equals("1")) {
    		favor_pattern = "pattern_cross-stripe";
    	} else if(listClothInfo.get("pattern_vertical-stripe").equals("1")) {
    		favor_pattern = "pattern_vertical-stripe";
    	} else {
    		favor_pattern = "pattern_repeat";
    	}
    	
    	//获取符合要求的图像
		String query_str;
		query_str = "SELECT pic_name FROM clothing_attrs WHERE ";
		query_str = query_str + favor_pattern + "=1 AND " + favor_sleeve_length + "=1 AND " + favor_model + "=1 AND " + favor_length + "=1 AND " + favor_collar_shape + "=1 LIMIT 10";
		try {
			PreparedStatement ps = conn.prepareStatement(query_str);
			rs = ps.executeQuery();
			
			String pic_name;
			pic_name = "none";
			while((rs.next())&&(list.size()<=10)) {
				pic_name = rs.getString("pic_name");
				System.out.println(pic_name);
				list.add(pic_name);
			}
			
			//再次获取符合要求的图像
			if(list.size()<=10) {
				query_str = "SELECT pic_name FROM clothing_attrs WHERE ";
    			query_str = query_str + favor_pattern + "=1 AND " + favor_sleeve_length + "=1 AND "  + favor_length + "=1 LIMIT 10";
    			ps = conn.prepareStatement(query_str);
    			rs = ps.executeQuery();
    			
    			pic_name = "none";
    			while((rs.next())&&(list.size()<10)) {
    				pic_name = rs.getString("pic_name");
    				System.out.println(pic_name);
    				list.add(pic_name);
    			}
			}
			
			//再次获取符合要求的图像
			if(list.size()<10) {
				query_str = "SELECT pic_name FROM clothing_attrs WHERE ";
    			query_str = query_str + favor_pattern + "=1 LIMIT 10";
    			ps = conn.prepareStatement(query_str);
    			rs = ps.executeQuery();
    			
    			pic_name = "none";
    			while((rs.next())&&(list.size()<=10)) {
    				pic_name = rs.getString("pic_name");
    				System.out.println(pic_name);
    				list.add(pic_name);
    			}
			}
			
		} catch(SQLException e) {
    		e.printStackTrace();
    	} catch(NumberFormatException e) {
    		e.printStackTrace();
    	}
    	getConn.closeConnection(conn);
    	
    	return list;
    }
    
    //寻找对应用户ID喜欢的服装图像
    public List<String> findpic(String username)
    {
    	//定义一个list用于接受数据库查询到的pic_name的内容
    	List<String> list = new ArrayList<String>();
    	
    	String result = "none";
    	ResultSet rs = null;
    	
    	DataBase getConn = new DataBase();
    	Connection conn = getConn.getConnection();
    	
    	try {
    		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_table WHERE name=?");
    		ps.setString(1, username);
    		rs = ps.executeQuery();
    		if(rs.next()) {
    			//获取用户ID
    			result = rs.getString("user_ID");
    			
    			//获取用户最喜欢的样式
    			ps = conn.prepareStatement("SELECT * FROM user_pre_pattern WHERE user_ID=?");
    			ps.setString(1, result);
    			rs = ps.executeQuery();
    			
    			String pure, grid, dot, floral, cross_stripe, vertical_stripe, number_letter, repeat, favor_pattern;
    			favor_pattern = "pattern_pure";
    			float pure_int, grid_int, dot_int, floral_int, cross_stripe_int, vertical_stripe_int, number_letter_int, repeat_int, favor_int;
    			if(rs.next()) {
    				pure = rs.getString("pure");
    				pure_int = Float.parseFloat(pure);
    				grid = rs.getString("grid");
    				grid_int = Float.parseFloat(grid);
    				dot = rs.getString("dot");
    				dot_int = Float.parseFloat(dot);
    				floral = rs.getString("floral");
    				floral_int = Float.parseFloat(floral);
    				cross_stripe = rs.getString("cross_stripe");
    				cross_stripe_int = Float.parseFloat(cross_stripe);
    				vertical_stripe = rs.getString("vertical_stripe");
    				vertical_stripe_int = Float.parseFloat(vertical_stripe);
    				number_letter = rs.getString("number_letter");
    				number_letter_int = Float.parseFloat(number_letter);
    				repeat = rs.getString("repeat");
    				repeat_int = Float.parseFloat(repeat);
    				
    				favor_int = pure_int;
    				if(grid_int > favor_int) {
    					favor_pattern = "pattern_grid";
    					favor_int = grid_int;
    				}
    				if(dot_int > favor_int) {
    					favor_pattern = "pattern_dot";
    					favor_int = dot_int;
    				}
    				if(floral_int > favor_int) {
    					favor_pattern = "pattern_floral";
    					favor_int = floral_int;
    				}
    				if(cross_stripe_int > favor_int) {
    					favor_pattern = "pattern_cross-stripe";
    					favor_int = cross_stripe_int;
    				}
    				if(vertical_stripe_int > favor_int) {
    					favor_pattern = "pattern_vertical-stripe";
    					favor_int = vertical_stripe_int;
    				}
    				if(number_letter_int > favor_int) {
    					favor_pattern = "pattern_number&letter";
    					favor_int = number_letter_int;
    				}
    				if(repeat_int > favor_int) {
    					favor_pattern = "pattern_repeat";
    					favor_int = repeat_int;
    				}
    			}
    			
    			//获取用户最喜欢的袖子长短
    			ps = conn.prepareStatement("SELECT * FROM user_pre_sleeve_length WHERE user_ID=?");
    			ps.setString(1, result);
    			rs = ps.executeQuery();
    			
    			String sleeve_sleeveless, sleeve_short, sleeve_long, favor_sleeve;
    			favor_sleeve = "sleeve_length_sleeveless";
    			float sleeve_sleeveless_int, sleeve_short_int, sleeve_long_int, favor_sleeve_int;
    			if(rs.next()) {
    				sleeve_sleeveless = rs.getString("sleeveless");
    				sleeve_sleeveless_int = Float.parseFloat(sleeve_sleeveless);
    				sleeve_short = rs.getString("short");
    				sleeve_short_int = Float.parseFloat(sleeve_short);
    				sleeve_long = rs.getString("long");
    				sleeve_long_int = Float.parseFloat(sleeve_long);
    				
    				favor_sleeve_int = sleeve_sleeveless_int;
    				if(sleeve_short_int > favor_sleeve_int) {
    					favor_sleeve = "sleeve_length_short";
    					favor_sleeve_int = sleeve_short_int;
    				}
    				if(sleeve_long_int > favor_sleeve_int) {
    					favor_sleeve = "sleeve_length_long";
    					favor_sleeve_int = sleeve_long_int;
    				}
    			}
    			
    			//获取用户最喜欢的松紧程度
    			ps = conn.prepareStatement("SELECT * FROM user_pre_model WHERE user_ID=?");
    			ps.setString(1, result);
    			rs = ps.executeQuery();
    			
    			String tight, straight, loose, favor_model;
    			favor_model = "model_tight";
    			float tight_int, straight_int, loose_int, favor_model_int;
    			if(rs.next()) {
    				tight = rs.getString("tight");
    				tight_int = Float.parseFloat(tight);
    				straight = rs.getString("straight");
    				straight_int = Float.parseFloat(straight);
    				loose = rs.getString("loose");
    				loose_int = Float.parseFloat(loose);
    				
    				favor_model_int = tight_int;
    				if(straight_int > favor_model_int) {
    					favor_model = "model_straight";
    					favor_model_int = straight_int;
    				}
    				if(loose_int > favor_model_int) {
    					favor_model = "model_loose";
    					favor_model_int = loose_int;
    				}
    			}
    			
    			//获取用户最喜欢的服装长度
    			ps = conn.prepareStatement("SELECT * FROM user_pre_length WHERE user_ID=?");
    			ps.setString(1, result);
    			rs = ps.executeQuery();
    			
    			String cloth_short, cloth_mid, cloth_long, favor_length;
    			favor_length = "length_short";
    			float cloth_short_int, cloth_mid_int, cloth_long_int, favor_length_int;
    			if(rs.next()) {
    				cloth_short = rs.getString("short");
    				cloth_short_int = Float.parseFloat(cloth_short);
    				cloth_mid = rs.getString("mid");
    				cloth_mid_int = Float.parseFloat(cloth_mid);
    				cloth_long = rs.getString("long");
    				cloth_long_int = Float.parseFloat(cloth_long);
    				
    				favor_length_int = cloth_short_int;
    				if(cloth_mid_int > favor_length_int) {
    					favor_length = "length_mid";
    					favor_length_int = cloth_mid_int;
    				}
    				if(cloth_long_int > favor_length_int) {
    					favor_length = "length_long";
    					favor_length_int = cloth_long_int;
    				}
    			}
    			
    			//获取用户最喜欢的领口形状
    			ps = conn.prepareStatement("SELECT * FROM user_pre_collar_shape WHERE user_ID=?");
    			ps.setString(1, result);
    			rs = ps.executeQuery();
    			
    			String stand, Vshape, bateau, round, lapel, high, hoodie, favor_collar_shape;
    			favor_collar_shape = "collar_shape_stand";
    			float stand_int, Vshape_int, bateau_int, round_int, lapel_int, high_int, hoodie_int, favor_collar_shape_int;
    			if(rs.next()) {
    				stand = rs.getString("stand");
    				stand_int = Float.parseFloat(stand);
    				Vshape = rs.getString("Vshape");
    				Vshape_int = Float.parseFloat(Vshape);
    				bateau = rs.getString("bateau");
    				bateau_int = Float.parseFloat(bateau);
    				round = rs.getString("round");
    				round_int = Float.parseFloat(round);
    				lapel = rs.getString("lapel");
    				lapel_int = Float.parseFloat(lapel);
    				high = rs.getString("high");
    				high_int = Float.parseFloat(high);
    				hoodie = rs.getString("hoodie");
    				hoodie_int = Float.parseFloat(hoodie);
    				
    				favor_collar_shape_int = stand_int;
    				if(Vshape_int > favor_collar_shape_int) {
    					favor_collar_shape = "collar_shape_V";
    					favor_collar_shape_int = Vshape_int;
    				}
    				if(bateau_int > favor_collar_shape_int) {
    					favor_collar_shape = "collar_shape_bateau";
    					favor_collar_shape_int = bateau_int;
    				}
    				if(round_int > favor_collar_shape_int) {
    					favor_collar_shape = "collar_shape_round";
    					favor_collar_shape_int = round_int;
    				}
    				if(lapel_int > favor_collar_shape_int) {
    					favor_collar_shape = "collar_shape_lapel";
    					favor_collar_shape_int = lapel_int;
    				}
    				if(high_int > favor_collar_shape_int) {
    					favor_collar_shape = "collar_shape_high";
    					favor_collar_shape_int = high_int;
    				}
    				if(hoodie_int > favor_collar_shape_int) {
    					favor_collar_shape = "collar_shape_hoodie";
    					favor_collar_shape_int = hoodie_int;
    				}
    			}
    			
    			//获取符合要求的图像
    			String query_str;
    			query_str = "SELECT pic_name FROM clothing_attrs WHERE ";
    			query_str = query_str + favor_pattern + "=1 AND " + favor_sleeve + "=1 AND " + favor_model + "=1 AND " + favor_length + "=1 AND " + favor_collar_shape + "=1 LIMIT 10";
    			ps = conn.prepareStatement(query_str);
    			rs = ps.executeQuery();
    			
    			String pic_name;
    			pic_name = "none";
    			while((rs.next())&&(list.size()<=10)) {
    				pic_name = rs.getString("pic_name");
    				System.out.println(pic_name);
    				list.add(pic_name);
    			}
    			
    			//再次获取符合要求的图像
    			if(list.size()<=10) {
    				query_str = "SELECT pic_name FROM clothing_attrs WHERE ";
        			query_str = query_str + favor_pattern + "=1 AND " + favor_sleeve + "=1 AND "  + favor_length + "=1 LIMIT 10";
        			ps = conn.prepareStatement(query_str);
        			rs = ps.executeQuery();
        			
        			pic_name = "none";
        			while((rs.next())&&(list.size()<10)) {
        				pic_name = rs.getString("pic_name");
        				System.out.println(pic_name);
        				list.add(pic_name);
        			}
    			}
    			
    			//再次获取符合要求的图像
    			if(list.size()<10) {
    				query_str = "SELECT pic_name FROM clothing_attrs WHERE ";
        			query_str = query_str + favor_pattern + "=1 LIMIT 10";
        			ps = conn.prepareStatement(query_str);
        			rs = ps.executeQuery();
        			
        			pic_name = "none";
        			while((rs.next())&&(list.size()<=10)) {
        				pic_name = rs.getString("pic_name");
        				System.out.println(pic_name);
        				list.add(pic_name);
        			}
    			}
    		} else {
    			result = "none";
    		}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	} catch(NumberFormatException e) {
    		e.printStackTrace();
    	}
    	getConn.closeConnection(conn);
    	
    	return list;
    }
    
    //根据服装图像路径返回相应的服装属性信息
    public String findinfo(String pic_name) {
    	//定义一个String用于接受数据库查询到的对应服装的内容
    	String outputlist = "";
    	
    	String result = "none";
    	ResultSet rs = null;
    	
    	DataBase getConn = new DataBase();
    	Connection conn = getConn.getConnection();
    	
    	try {
    		PreparedStatement ps = conn.prepareStatement("SELECT * FROM clothing_attrs WHERE pic_name=?");
    		ps.setString(1, pic_name);
    		rs = ps.executeQuery();
    		if(rs.next()) {
    			//获取服装信息,length_short
    			result = rs.getString("length_short");
    			//System.out.println(" length_short: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,length_mid
				result = rs.getString("length_mid");
    			//System.out.println(" length_mid: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,length_long
				result = rs.getString("length_long");
    			//System.out.println(" length_long: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,sleeve_length_sleeveless
				result = rs.getString("sleeve_length_sleeveless");
    			//System.out.println(" sleeve_length_sleeveless: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,sleeve_length_short
				result = rs.getString("sleeve_length_short");
    			//System.out.println(" sleeve_length_short: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,sleeve_length_long
				result = rs.getString("sleeve_length_long");
    			//System.out.println(" sleeve_length_long: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,collar_shape_stand
				result = rs.getString("collar_shape_stand");
    			//System.out.println(" collar_shape_stand: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,collar_shape_V
				result = rs.getString("collar_shape_V");
    			//System.out.println(" collar_shape_V: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,collar_shape_bateau
				result = rs.getString("collar_shape_bateau");
    			//System.out.println(" collar_shape_bateau: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,collar_shape_stand
				result = rs.getString("collar_shape_round");
    			//System.out.println(" collar_shape_round: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,collar_shape_lapel
				result = rs.getString("collar_shape_lapel");
    			//System.out.println(" collar_shape_lapel: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,collar_shape_high
				result = rs.getString("collar_shape_high");
    			//System.out.println(" collar_shape_high: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,collar_shape_hoodie
				result = rs.getString("collar_shape_hoodie");
    			//System.out.println(" collar_shape_hoodie: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,model_tight
				result = rs.getString("model_tight");
    			//System.out.println(" model_tight: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,model_straight
				result = rs.getString("model_straight");
    			//System.out.println(" model_straight: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,model_loose
				result = rs.getString("model_loose");
    			//System.out.println(" model_loose: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pattern_pure
				result = rs.getString("pattern_pure");
    			//System.out.println(" pattern_pure: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pattern_grid
				result = rs.getString("pattern_grid");
    			//System.out.println(" pattern_grid: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pattern_dot
				result = rs.getString("pattern_dot");
    			//System.out.println(" pattern_dot: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pattern_floral
				result = rs.getString("pattern_floral");
    			//System.out.println(" pattern_floral: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pattern_cross-stripe
				result = rs.getString("pattern_cross-stripe");
    			//System.out.println(" pattern_cross-stripe: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pattern_vertical-stripe
				result = rs.getString("pattern_vertical-stripe");
    			//System.out.println(" pattern_vertical-stripe: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pattern_number&letter
				result = rs.getString("pattern_number&letter");
    			//System.out.println(" pattern_number&letter: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pattern_repeat
				result = rs.getString("pattern_repeat");
    			//System.out.println(" pattern_repeat: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pants_length_short
				result = rs.getString("pants_length_short");
    			//System.out.println(" pants_length_short: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pants_length_mid
				result = rs.getString("pants_length_mid");
    			//System.out.println(" pants_length_mid: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pants_length_long
				result = rs.getString("pants_length_long");
    			//System.out.println(" pants_length_long: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pants_pattern_pure
				result = rs.getString("pants_pattern_pure");
    			//System.out.println(" pants_pattern_pure: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pants_pattern_grid
				result = rs.getString("pants_pattern_grid");
    			//System.out.println(" pants_pattern_grid: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pants_pattern_dot
				result = rs.getString("pants_pattern_dot");
    			//System.out.println(" pants_pattern_dot: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pants_pattern_floral
				result = rs.getString("pants_pattern_floral");
    			//System.out.println(" pants_pattern_floral: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pants_pattern_cross-stripe
				result = rs.getString("pants_pattern_cross-stripe");
    			//System.out.println(" pants_pattern_cross-stripe: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pants_pattern_vertical-stripe
				result = rs.getString("pants_pattern_vertical-stripe");
    			//System.out.println(" pants_pattern_vertical-stripe: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pants_pattern_number&letter
				result = rs.getString("pants_pattern_number&letter");
    			//System.out.println(" pants_pattern_number&letter: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pants_pattern_repeat
				result = rs.getString("pants_pattern_repeat");
    			//System.out.println(" pants_pattern_repeat: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pants_model_straight
				result = rs.getString("pants_model_straight");
    			//System.out.println(" pants_model_straight: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pants_model_tight
				result = rs.getString("pants_model_tight");
    			//System.out.println(" pants_model_tight: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,pants_model_loose
				result = rs.getString("pants_model_loose");
    			//System.out.println(" pants_model_loose: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,skirt_length_short
				result = rs.getString("skirt_length_short");
    			//System.out.println(" skirt_length_short: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,skirt_length_mid
				result = rs.getString("skirt_length_mid");
    			//System.out.println(" skirt_length_mid: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,skirt_length_long
				result = rs.getString("skirt_length_long");
    			//System.out.println(" skirt_length_long: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,skirt_model_package-hip
				result = rs.getString("skirt_model_package-hip");
    			//System.out.println(" skirt_model_package-hip: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,skirt_model_A-shape
				result = rs.getString("skirt_model_A-sharp");
    			//System.out.println(" skirt_model_A-shape: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,skirt_pattern_pure
				result = rs.getString("skirt_pattern_pure");
    			//System.out.println(" skirt_pattern_pure: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,skirt_pattern_grid
				result = rs.getString("skirt_pattern_grid");
    			//System.out.println(" skirt_pattern_grid: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,skirt_pattern_dot
				result = rs.getString("skirt_pattern_dot");
    			//System.out.println(" skirt_pattern_dot: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,skirt_pattern_floral
				result = rs.getString("skirt_pattern_floral");
    			//System.out.println(" skirt_pattern_floral: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,skirt_pattern_cross-stripe
				result = rs.getString("skirt_pattern_cross-stripe");
    			//System.out.println(" skirt_pattern_cross-stripe: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,skirt_pattern_vertical-stripe
				result = rs.getString("skirt_pattern_vertical-stripe");
    			//System.out.println(" skirt_pattern_vertical-stripe: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,skirt_pattern_number&letter
				result = rs.getString("skirt_pattern_number&letter");
    			//System.out.println(" skirt_pattern_number&letter: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,skirt_pattern_repeat
				result = rs.getString("skirt_pattern_repeat");
    			//System.out.println(" skirt_pattern_repeat: ");
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,season
				result = rs.getString("season");
    			System.out.println("season: "+result);
    			//System.out.println(result);
    			outputlist = outputlist + result + ",";
				//获取服装信息,brand
				result = rs.getString("brand");
    			System.out.println("brand: "+result);
    			//System.out.println(result);
    			outputlist = outputlist + result;
    		} else {
    			result = "none";
    		}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	} catch(NumberFormatException e) {
    		e.printStackTrace();
    	}
    	getConn.closeConnection(conn);
    	
    	return outputlist;
    }
    
    //根据服装图像路径返回相应的服装属性信息，以HashMap<String, String>的形式返回
    @SuppressWarnings("null")
	public HashMap<String, String> findinfo_hashmap(String pic_name) {
    	HashMap<String, String> listClothInfo = null;
    	
    	String result = "none";
    	ResultSet rs = null;
    	
    	DataBase getConn = new DataBase();
    	Connection conn = getConn.getConnection();
    	
    	try {
    		PreparedStatement ps = conn.prepareStatement("SELECT * FROM clothing_attrs WHERE pic_name=?");
    		ps.setString(1, pic_name);
    		rs = ps.executeQuery();
    		if(rs.next()) {
    			//获取服装信息,length_short
    			result = rs.getString("length_short");
    			listClothInfo.put("length_short",result);
				//获取服装信息,length_mid
				result = rs.getString("length_mid");
				listClothInfo.put("length_mid",result);
				//获取服装信息,length_long
				result = rs.getString("length_long");
				listClothInfo.put("length_long",result);
				//获取服装信息,sleeve_length_sleeveless
				result = rs.getString("sleeve_length_sleeveless");
				listClothInfo.put("sleeve_length_sleeveless",result);
				//获取服装信息,sleeve_length_short
				result = rs.getString("sleeve_length_short");
				listClothInfo.put("sleeve_length_short",result);
				//获取服装信息,sleeve_length_long
				result = rs.getString("sleeve_length_long");
				listClothInfo.put("sleeve_length_long",result);
				//获取服装信息,collar_shape_stand
				result = rs.getString("collar_shape_stand");
				listClothInfo.put("collar_shape_stand",result);
				//获取服装信息,collar_shape_V
				result = rs.getString("collar_shape_V");
				listClothInfo.put("collar_shape_V",result);
				//获取服装信息,collar_shape_bateau
				result = rs.getString("collar_shape_bateau");
				listClothInfo.put("collar_shape_bateau",result);
				//获取服装信息,collar_shape_stand
				result = rs.getString("collar_shape_round");
				listClothInfo.put("collar_shape_round",result);
				//获取服装信息,collar_shape_lapel
				result = rs.getString("collar_shape_lapel");
				listClothInfo.put("collar_shape_lapel",result);
				//获取服装信息,collar_shape_high
				result = rs.getString("collar_shape_high");
				listClothInfo.put("collar_shape_high",result);
				//获取服装信息,collar_shape_hoodie
				result = rs.getString("collar_shape_hoodie");
				listClothInfo.put("collar_shape_hoodie",result);
				//获取服装信息,model_tight
				result = rs.getString("model_tight");
				listClothInfo.put("model_tight",result);
				//获取服装信息,model_straight
				result = rs.getString("model_straight");
				listClothInfo.put("model_straight",result);
				//获取服装信息,model_loose
				result = rs.getString("model_loose");
				listClothInfo.put("model_loose",result);
				//获取服装信息,pattern_pure
				result = rs.getString("pattern_pure");
				listClothInfo.put("pattern_pure",result);
				//获取服装信息,pattern_grid
				result = rs.getString("pattern_grid");
				listClothInfo.put("pattern_grid",result);
				//获取服装信息,pattern_dot
				result = rs.getString("pattern_dot");
				listClothInfo.put("pattern_dot",result);
				//获取服装信息,pattern_floral
				result = rs.getString("pattern_floral");
				listClothInfo.put("pattern_floral",result);
				//获取服装信息,pattern_cross-stripe
				result = rs.getString("pattern_cross-stripe");
				listClothInfo.put("pattern_cross-stripe",result);
				//获取服装信息,pattern_vertical-stripe
				result = rs.getString("pattern_vertical-stripe");
				listClothInfo.put("pattern_vertical-stripe",result);
				//获取服装信息,pattern_number&letter
				result = rs.getString("pattern_number&letter");
				listClothInfo.put("pattern_number&letter",result);
				//获取服装信息,pattern_repeat
				result = rs.getString("pattern_repeat");
				listClothInfo.put("pattern_repeat",result);
				//获取服装信息,pants_length_short
				result = rs.getString("pants_length_short");
				listClothInfo.put("pants_length_short",result);
				//获取服装信息,pants_length_mid
				result = rs.getString("pants_length_mid");
				listClothInfo.put("pants_length_mid",result);
				//获取服装信息,pants_length_long
				result = rs.getString("pants_length_long");
				listClothInfo.put("pants_length_long",result);
				//获取服装信息,pants_pattern_pure
				result = rs.getString("pants_pattern_pure");
				listClothInfo.put("pants_pattern_pure",result);
				//获取服装信息,pants_pattern_grid
				result = rs.getString("pants_pattern_grid");
				listClothInfo.put("pants_pattern_grid",result);
				//获取服装信息,pants_pattern_dot
				result = rs.getString("pants_pattern_dot");
				listClothInfo.put("pants_pattern_dot",result);
				//获取服装信息,pants_pattern_floral
				result = rs.getString("pants_pattern_floral");
				listClothInfo.put("pants_pattern_floral",result);
				//获取服装信息,pants_pattern_cross-stripe
				result = rs.getString("pants_pattern_cross-stripe");
				listClothInfo.put("pants_pattern_cross-stripe",result);
				//获取服装信息,pants_pattern_vertical-stripe
				result = rs.getString("pants_pattern_vertical-stripe");
				listClothInfo.put("pants_pattern_vertical-stripe",result);
				//获取服装信息,pants_pattern_number&letter
				result = rs.getString("pants_pattern_number&letter");
				listClothInfo.put("pants_pattern_number&letter",result);
				//获取服装信息,pants_pattern_repeat
				result = rs.getString("pants_pattern_repeat");
				listClothInfo.put("pants_pattern_repeat",result);
				//获取服装信息,pants_model_straight
				result = rs.getString("pants_model_straight");
				listClothInfo.put("pants_model_straight",result);
				//获取服装信息,pants_model_tight
				result = rs.getString("pants_model_tight");
				listClothInfo.put("pants_model_tight",result);
				//获取服装信息,pants_model_loose
				result = rs.getString("pants_model_loose");
				listClothInfo.put("pants_model_loose",result);
				//获取服装信息,skirt_length_short
				result = rs.getString("skirt_length_short");
				listClothInfo.put("skirt_length_short",result);
				//获取服装信息,skirt_length_mid
				result = rs.getString("skirt_length_mid");
				listClothInfo.put("skirt_length_mid",result);
				//获取服装信息,skirt_length_long
				result = rs.getString("skirt_length_long");
				listClothInfo.put("skirt_length_long",result);
				//获取服装信息,skirt_model_package-hip
				result = rs.getString("skirt_model_package-hip");
				listClothInfo.put("skirt_model_package-hip",result);
				//获取服装信息,skirt_model_A-shape
				result = rs.getString("skirt_model_A-sharp");
				listClothInfo.put("skirt_model_A-sharp",result);
				//获取服装信息,skirt_pattern_pure
				result = rs.getString("skirt_pattern_pure");
				listClothInfo.put("skirt_pattern_pure",result);
				//获取服装信息,skirt_pattern_grid
				result = rs.getString("skirt_pattern_grid");
				listClothInfo.put("skirt_pattern_grid",result);
				//获取服装信息,skirt_pattern_dot
				result = rs.getString("skirt_pattern_dot");
				listClothInfo.put("skirt_pattern_dot",result);
				//获取服装信息,skirt_pattern_floral
				result = rs.getString("skirt_pattern_floral");
				listClothInfo.put("skirt_pattern_floral",result);
				//获取服装信息,skirt_pattern_cross-stripe
				result = rs.getString("skirt_pattern_cross-stripe");
				listClothInfo.put("skirt_pattern_cross-stripe",result);
				//获取服装信息,skirt_pattern_vertical-stripe
				result = rs.getString("skirt_pattern_vertical-stripe");
				listClothInfo.put("skirt_pattern_vertical-stripe",result);
				//获取服装信息,skirt_pattern_number&letter
				result = rs.getString("skirt_pattern_number&letter");
				listClothInfo.put("skirt_pattern_number&letter",result);
				//获取服装信息,skirt_pattern_repeat
				result = rs.getString("skirt_pattern_repeat");
				listClothInfo.put("skirt_pattern_repeat",result);
				//获取服装信息,season
				result = rs.getString("season");
				listClothInfo.put("season",result);
				//获取服装信息,brand
				result = rs.getString("brand");
				listClothInfo.put("brand",result);
    		} else {
    			result = "none";
    		}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	} catch(NumberFormatException e) {
    		e.printStackTrace();
    	}
    	getConn.closeConnection(conn);
    	
    	return listClothInfo;
    }
    
    public boolean register(String username, String password, String sexName)
    {
    	boolean result = false;
    	int rs = 0;
    	
    	DataBase getConn = new DataBase();
    	Connection conn = getConn.getConnection();
    	
    	try {
    		PreparedStatement ps = conn.prepareStatement("INSERT INTO user_table(name,password,sex) VALUES(?,?,?)");
    		ps.setString(1, username);
    		ps.setString(2, password);
    		ps.setString(3, sexName);
    		rs = ps.executeUpdate();
    		if(rs == 1) {
    			result = true;
    		} else {
    			result = false;
    		}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	getConn.closeConnection(conn);
    	return result;
    }
    
    public boolean checkname(String username)
    {
    	boolean result = false;
    	ResultSet rs = null;
    	
    	DataBase getConn = new DataBase();
    	Connection conn = getConn.getConnection();
    	
    	try {
    		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_table WHERE name=?");
    		ps.setString(1, username);
    		rs = ps.executeQuery();
    		if(rs.next()) {
    			result = true;
    		} else {
    			result = false;
    		}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	getConn.closeConnection(conn);
    	return result;
    }
}
