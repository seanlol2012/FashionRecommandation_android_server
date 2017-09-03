package fashion_server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    			int pure_int, grid_int, dot_int, floral_int, cross_stripe_int, vertical_stripe_int, number_letter_int, repeat_int, favor_int;
    			if(rs.next()) {
    				pure = rs.getString("pure");
    				pure_int = Integer.parseInt(pure);
    				grid = rs.getString("grid");
    				grid_int = Integer.parseInt(grid);
    				dot = rs.getString("dot");
    				dot_int = Integer.parseInt(dot);
    				floral = rs.getString("floral");
    				floral_int = Integer.parseInt(floral);
    				cross_stripe = rs.getString("cross_stripe");
    				cross_stripe_int = Integer.parseInt(cross_stripe);
    				vertical_stripe = rs.getString("vertical_stripe");
    				vertical_stripe_int = Integer.parseInt(vertical_stripe);
    				number_letter = rs.getString("number_letter");
    				number_letter_int = Integer.parseInt(number_letter);
    				repeat = rs.getString("repeat");
    				repeat_int = Integer.parseInt(repeat);
    				
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
    			int sleeve_sleeveless_int, sleeve_short_int, sleeve_long_int, favor_sleeve_int;
    			if(rs.next()) {
    				sleeve_sleeveless = rs.getString("sleeveless");
    				sleeve_sleeveless_int = Integer.parseInt(sleeve_sleeveless);
    				sleeve_short = rs.getString("short");
    				sleeve_short_int = Integer.parseInt(sleeve_short);
    				sleeve_long = rs.getString("long");
    				sleeve_long_int = Integer.parseInt(sleeve_long);
    				
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
    			int tight_int, straight_int, loose_int, favor_model_int;
    			if(rs.next()) {
    				tight = rs.getString("tight");
    				tight_int = Integer.parseInt(tight);
    				straight = rs.getString("straight");
    				straight_int = Integer.parseInt(straight);
    				loose = rs.getString("loose");
    				loose_int = Integer.parseInt(loose);
    				
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
    			int cloth_short_int, cloth_mid_int, cloth_long_int, favor_length_int;
    			if(rs.next()) {
    				cloth_short = rs.getString("short");
    				cloth_short_int = Integer.parseInt(cloth_short);
    				cloth_mid = rs.getString("mid");
    				cloth_mid_int = Integer.parseInt(cloth_mid);
    				cloth_long = rs.getString("long");
    				cloth_long_int = Integer.parseInt(cloth_long);
    				
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
    			int stand_int, Vshape_int, bateau_int, round_int, lapel_int, high_int, hoodie_int, favor_collar_shape_int;
    			if(rs.next()) {
    				stand = rs.getString("stand");
    				stand_int = Integer.parseInt(stand);
    				Vshape = rs.getString("Vshape");
    				Vshape_int = Integer.parseInt(Vshape);
    				bateau = rs.getString("bateau");
    				bateau_int = Integer.parseInt(bateau);
    				round = rs.getString("round");
    				round_int = Integer.parseInt(round);
    				lapel = rs.getString("lapel");
    				lapel_int = Integer.parseInt(lapel);
    				high = rs.getString("high");
    				high_int = Integer.parseInt(high);
    				hoodie = rs.getString("hoodie");
    				hoodie_int = Integer.parseInt(hoodie);
    				
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
    			query_str = query_str + favor_pattern + "=1 AND " + favor_sleeve + "=1 AND " + favor_model + "=1 AND " + favor_length + "=1 AND " + favor_collar_shape + "=1 LIMIT 20";
    			ps = conn.prepareStatement(query_str);
    			//ps.setString(1, favor_pattern);
    			//ps.setString(2, favor_sleeve);
    			//ps.setString(3, favor_model);
    			//ps.setString(4, favor_length);
    			//ps.setString(5, favor_collar_shape);
    			rs = ps.executeQuery();
    			
    			String pic_name;
    			pic_name = "none";
    			while(rs.next()) {
    				pic_name = rs.getString("pic_name");
    				System.out.println(pic_name);
    				list.add(pic_name);
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
    
    public boolean register(String username, String password, String sexName)
    {
    	boolean result = false;
    	int rs = 0;
    	
    	DataBase getConn = new DataBase();
    	Connection conn = getConn.getConnection();
    	
    	try {
    		PreparedStatement ps = conn.prepareStatement("INSERT INTO user_table(name,password,sex) VALUES(?,?,?)");
    		ps.setString(1, username);
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
    
    public boolean checkusername(String username)
    {
    	boolean result = false;
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
