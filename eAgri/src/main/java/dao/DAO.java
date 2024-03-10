package dao;
import crop.Crop;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import oracle.jdbc.OraclePreparedStatement;
import News.*;
import javax.servlet.http.Part;

import News.NewsItem;
import admin.CropPrice; 
public class DAO 
{
	 Connection con;
	public DAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver is loaded");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Agri","agri");
			System.out.println("Connected..");
		}catch(ClassNotFoundException ex)
		{
			System.out.println("Not loaded................");
			System.out.println(ex);
		}
		catch(SQLException ex)
		{
			System.out.println("Not Connected................");
			System.err.println(ex);
		}
	}
	
	public boolean doRegister(String name,String phone,String password,String city,String state,String pincode)
	{
		boolean flag=false;
		try {
				PreparedStatement pstmt= con.prepareStatement("insert into Farmers values(?,?,?,?,?,?)");
				pstmt.setString(1, name);
				pstmt.setString(2,phone); 
				pstmt.setString(3,city);
				pstmt.setString(4,state);
				pstmt.setString(5, pincode);
				pstmt.setString(6,password);
				int r=pstmt.executeUpdate();
				if(r>0)
				{
					flag=true;
				}
		}catch(SQLException ex)
		{
			System.out.println("Not Connected................");
			System.err.println(ex);
		}
		return flag;
	}
	public boolean doExporterRegister(String name,String password,String email)
	{      
		boolean flag=false; 
		try {
				PreparedStatement pstmt= con.prepareStatement("insert into Exporters values(?,?,?)");
				pstmt.setString(1,name); 
				pstmt.setString(2,email);
				pstmt.setString(3,password);
				int r=pstmt.executeUpdate();
				if(r>0)
				{
					flag=true;
				}
		}catch(SQLException ex)
		{
			System.out.println("Not Connected................");
			System.err.println(ex);
		}
		return flag;
	}
	public boolean doUpload(String phone,String cropName,String quantity,String pincode ,String state)
	{
		boolean flag=false;
		try {
				PreparedStatement pstmt= con.prepareStatement("insert into Stock values(?,?,?,?,?)");
				pstmt.setString(1, phone); 
				pstmt.setString(2,cropName); 
				pstmt.setString(3,quantity);
				pstmt.setString(4, pincode);
				pstmt.setString(5, state);
				int r=pstmt.executeUpdate();
				if(r>0)
				{
					flag=true;
				}
		}catch(SQLException ex)
		{
			System.out.println("Not Connected................");
			System.err.println(ex);
		}
		return flag;
	}
	

	public String loginCheck(String phone,String pwd)
	{
				String name=null;
				try {
				PreparedStatement pstmt=con.prepareStatement("select name from Farmers where phone=? and password=?");
				pstmt.setString(1,phone);
				pstmt.setString(2,pwd);
				ResultSet rs= pstmt.executeQuery();
				if(rs.next())
				{
					name=rs.getString("name");
				}
				
				}catch(SQLException ex)
				{	System.err.println("Error while checking userid/pwd");
					System.out.println(ex);
				}
				return name;
	}
	public String ExporterloginCheck(String mail,String pwd)
	{
				String name=null;
				try {
				PreparedStatement pstmt=con.prepareStatement("select name from exporters where email=? and password=?");
				pstmt.setString(1,mail);
				pstmt.setString(2,pwd);
				ResultSet rs= pstmt.executeQuery();
				if(rs.next())
				{
					name=rs.getString("name");
				}
				
				}catch(SQLException ex)
				{	System.err.println("Error while checking userid/pwd");
					System.out.println(ex);
				}
				return name;
	}
	public List<Crop> getAllCrops(String selectedCrop, String pincode) throws SQLException {
	    List<Crop> crops = new ArrayList<>();
	    
	    // Initialize the SQL query with a base SELECT statement
	    String sql = "SELECT PHONE, CROPNAME, QUANTITY, pincode, state FROM stock WHERE 1=1";
	    
	    // Check if selectedCrop filter is provided
	    if (selectedCrop != null && !selectedCrop.isEmpty()) {
	        sql += " AND CROPNAME = ?";
	    }
	     
	    if (pincode != null && !pincode.isEmpty()) {
	        sql += " AND pincode = ?";
	    }
	    
	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        int parameterIndex = 1;
	        
	        // Set filter parameters
	        if (selectedCrop != null && !selectedCrop.isEmpty()) {
	            pstmt.setString(parameterIndex++, selectedCrop);
	        }
	        
	        if (pincode != null && !pincode.isEmpty()) {
	            pstmt.setString(parameterIndex, pincode);
	        }
	        
	        ResultSet resultSet = pstmt.executeQuery();
	        
	        while (resultSet.next()) {
	            String phone = resultSet.getString("PHONE");
	            String cropName = resultSet.getString("CROPNAME");
	            String quantity = resultSet.getString("QUANTITY");
	            String pincodeResult = resultSet.getString("pincode");
	            String state = resultSet.getString("state");
	            Crop crop = new Crop(phone, cropName, quantity, pincodeResult, state);
	            crops.add(crop);
	        }
	    }
	    
	    return crops;
	}

		public List<NewsItem> retrieveNews() {
	    List<NewsItem> newsList = new ArrayList<>();

	    try {
	        String sql = "SELECT * FROM news";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        ResultSet resultSet = pstmt.executeQuery();

	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String title = resultSet.getString("title");
	            String content = resultSet.getString("content");
	            String author = resultSet.getString("author");
	            String datePublished = resultSet.getString("date_published");
	            String category = resultSet.getString("category");
	            Blob imageBlob = resultSet.getBlob("image");
	            String sourceUrl = resultSet.getString("source_url");

	            // Convert the imageBlob to a byte array
	            byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());

	            // Encode the byte array as a base64 string
	            String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);

	            NewsItem newsItem = new NewsItem(id, title, content, author, datePublished, category, imageBase64, sourceUrl);
	            newsList.add(newsItem);
	        }

	        resultSet.close();
	        pstmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return newsList;
	}
	public String validateAdmin(String username, String password) {
		String name=null;
        try {
            // Create a SQL query to check admin credentials
            String sql = "SELECT * FROM admin_table WHERE username = ? AND password = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            
            // If a row is returned, the credentials are valid
            if (rs.next()) {
            	 name = rs.getString("username");
                 
            }

            rs.close();
            pstmt.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

        return name;
    }

	public boolean insertNews(String idStr,String title, String content, String author, String datePublished, String category, InputStream imageInputStream, String sourceUrl) {
	    // Database connection code goes here
	    // Make sure to set up a valid database connection
	    boolean flag = false;
	    String sql = "INSERT INTO news (title, content, author, date_published, category, image, source_url,id) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
	    
	    try (OraclePreparedStatement pstmt = (OraclePreparedStatement) con.prepareStatement(sql)) {
	        pstmt.setString(1, title);
	        pstmt.setString(2, content);
	        pstmt.setString(3, author);
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date datePublishedDate = null;
	        try {
	            datePublishedDate = dateFormat.parse(datePublished);
	        } catch (java.text.ParseException e) {
	            e.printStackTrace();
	        }

	        // Check if parsing was successful
	        if (datePublishedDate != null) {
	            // Convert java.util.Date to java.sql.Date using the constructor
	            java.sql.Date sqlDate = new java.sql.Date(datePublishedDate.getTime());
	            pstmt.setDate(4, sqlDate); // Set the date parameter
	        } else {
	            // Handle parsing error
	            System.out.println("Error parsing datePublished");
	        }
	        pstmt.setString(5, category);

	        // Set the BLOB using setBinaryStream method for Oracle
	        pstmt.setBinaryStream(6, imageInputStream, (int) imageInputStream.available());
	        
	        pstmt.setString(7, sourceUrl);
	        
	        int id=Integer.parseInt(idStr);
	        pstmt.setInt(8,id);

	        int rowsInserted = pstmt.executeUpdate();
	        if (rowsInserted > 0) {
	            flag = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return flag;
	}
	public boolean insertPrices(String name ,String price) {
		boolean flag=false;
		try {
				PreparedStatement pstmt= con.prepareStatement("insert into Crop_base_price values(?,? )");
				 
				pstmt.setString(1,name); 
				pstmt.setString(2,price);
				 
				int r=pstmt.executeUpdate();
				if(r>0)
				{
					flag=true;
				}
		}catch(SQLException ex)
		{
			System.out.println("Not Connected................");
			System.err.println(ex);
		}
		return flag;
	
	}
	public boolean updateCropPrice(CropPrice cropPrice) {
        String sql = "UPDATE crop_base_price SET base_price = ? WHERE crop_name = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setDouble(1, cropPrice.getBasePrice());
            pstmt.setString(2, cropPrice.getCropName());

            int rowsAffected = pstmt.executeUpdate();
            return (rowsAffected > 0) ;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public List<CropPrice> getAllCropPrices() {
	    List<CropPrice> cropPrices = new ArrayList<>();

	     
	        String sql = "SELECT * FROM crop_base_price";

	        try (PreparedStatement pstmt = con.prepareStatement(sql);
	             ResultSet resultSet = pstmt.executeQuery()) {

	            while (resultSet.next()) {
	                double basePrice = resultSet.getDouble("base_price");
	                String cropName = resultSet.getString("crop_name");
	                CropPrice cropPrice = new CropPrice(cropName, basePrice);
	                cropPrices.add(cropPrice);
	            }
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    

	    return cropPrices;
	}

	/*public List<Stock> retrieveStockData() {
        List<Stock> stocks = new ArrayList<>();
        try {
        String sql = "SELECT Cropname, quantity FROM Stock";

        PreparedStatement pstmt= con.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();

        while (resultSet.next()) {
            String cropName = resultSet.getString("Cropname");
            String quantitystr = resultSet.getString("quantity");
            double quantity=Double.parseDouble(quantitystr);
            // Create Stock objects and add them to the list
            Stock stock = new Stock();
            stock.setCropName(cropName);
            stock.setQuantity(quantity);

            stocks.add(stock);
        }
        }
     catch (SQLException e) {
        e.printStackTrace(); // Handle or log the exception
    } 

    return stocks;

	}
	*/
	
	public static void main(String args[])
	{
		new DAO();
	}
}




