package clob;

import java.io.*;
import java.sql.*;

public class MyClob {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "12345678";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

//            String sql = "INSERT INTO article(title, content) VALUES (?, ?)";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, "Introduction to JDBC");
//
//            FileReader reader = new FileReader("src/clob/article.txt");
//            ps.setCharacterStream(2, reader);
//            ps.executeUpdate();
//
//            System.out.println("Article inserted successfully!");


//            String sql = "SELECT content FROM article WHERE id = ?";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, 3);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                Reader reader = rs.getCharacterStream("content");
//                FileWriter writer = new FileWriter("downloaded_article.txt");
//                char[] buffer = new char[4096];
//                int charsRead;
//                while ((charsRead = reader.read(buffer)) != -1) {
//                    writer.write(buffer, 0, charsRead);
//                }
//
//                reader.close();
//                writer.close();
//
//                System.out.println("Article retrieved successfully!");
//            }


//            String sql = "INSERT INTO article(title, content) VALUES (?, ?)";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, "Introduction to JDBC");
//            Clob clob = connection.createClob();
//            FileReader reader = new FileReader("src/clob/article.txt");
//            Writer writer = clob.setCharacterStream(1);
//            char[] buffer = new char[4096];
//            int charsRead;
//            while ((charsRead = reader.read(buffer)) != -1) {
//                writer.write(buffer, 0, charsRead);
//            }
//
//            reader.close();
//            writer.close();
//            ps.setClob(2, clob);
//            ps.executeUpdate();
//            System.out.println("Article inserted successfully!");


//            String sql = "SELECT content FROM article WHERE id = ?";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, 4);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                Clob clob = rs.getClob("content");
//                Reader reader = clob.getCharacterStream();
//                FileWriter writer = new FileWriter("downloaded_article.txt");
//                char[] buffer = new char[4096];
//                int charsRead;
//                while ((charsRead = reader.read(buffer)) != -1) {
//                    writer.write(buffer, 0, charsRead);
//                }
//
//                reader.close();
//                writer.close();
//
//                System.out.println("Article retrieved successfully!");
//            }

        }  catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}