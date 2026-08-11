package blob;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

public class MyBlob {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/product_db";
        String username = "root";
        String password = "12345678";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

//            String sql = "INSERT INTO product_image(name, image) VALUES (?, ?)";
//            PreparedStatement ps = connection.prepareStatement(sql);
//
//            ps.setString(1, "madara.jpg");
//            FileInputStream fis = new FileInputStream("src/blob/madara.jpg");
//            ps.setBinaryStream(2, fis);
//            ps.executeUpdate();
//            fis.close();
//            ps.setInt(1, 1);
//            System.out.println("Image stored successfully!");



            String sql = "SELECT image FROM product_image WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 5);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                InputStream input = rs.getBinaryStream("image");
                FileOutputStream output = new FileOutputStream("downloaded-new.jpg");
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }

                input.close();
                output.close();

                System.out.println("Image retrieved successfully!");
            }


//            String sql = "INSERT INTO product_image(name, image) VALUES (?, ?)";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, "madara.jpg");
//            java.sql.Blob blob = connection.createBlob();
//            FileInputStream fis = new FileInputStream("src/blob/madara.jpg");
//            OutputStream output = blob.setBinaryStream(1);
//
//            byte[] buffer = new byte[4096];
//            int bytesRead;
//            while ((bytesRead = fis.read(buffer)) != -1) {
//                output.write(buffer, 0, bytesRead);
//            }
//
//            fis.close();
//            output.close();
//
//            ps.setBlob(2, blob);
//            ps.executeUpdate();
//            System.out.println("Image inserted successfully!");


//            String sql = "SELECT image FROM product_image WHERE id = ?";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, 4);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                java.sql.Blob blob = rs.getBlob("image");
//                InputStream input = blob.getBinaryStream();
//                FileOutputStream output = new FileOutputStream("downloaded.jpg");
//
//                byte[] buffer = new byte[4096];
//                int bytesRead;
//                while ((bytesRead = input.read(buffer)) != -1) {
//                    output.write(buffer, 0, bytesRead);
//                }
//
//                input.close();
//                output.close();
//
//                System.out.println("Image retrieved successfully!");
//            }

        }  catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}