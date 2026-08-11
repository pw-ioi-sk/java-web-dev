import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/product_db";
        String username = "root";
        String password = "12345678";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

//            int r1 = statement.executeUpdate("INSERT INTO product (name, price) VALUES ('EV0', 2300.00)");
//            int r2 = statement.executeUpdate("INSERT INTO product (name, price) VALUES ('EV1', 2300.00)");
//            int r3 = statement.executeUpdate("INSERT INTO product (name, price) VALUES ('EV2', 2300.00)");
//            System.out.println(r1 + " affected");
//            System.out.println(r2 + " affected");
//            System.out.println(r3 + " affected");

//            statement.addBatch("INSERT INTO product (name, price) VALUES ('EV0', 2300.00)");
//            statement.addBatch("INSERT INTO product (name, price) VALUES ('EV1', 2300.00)");
//            statement.addBatch("INSERT INTO product (name, price) VALUES ('EV2', 2300.00)");
//            int[] rows = statement.executeBatch();
//            for (int row : rows) {
//                System.out.println(row + " Affected");
//            }

//            String sql = "INSERT INTO product (name, price) VALUES (?, ?)";
//            PreparedStatement ps = connection.prepareStatement(sql);
//
//            ps.setString(1, "EV0");
//            ps.setDouble(2, 2300.00);
//            int r1 = ps.executeUpdate();
//
//            ps.setString(1, "EV1");
//            ps.setDouble(2, 2300.00);
//            int r2 = ps.executeUpdate();
//
//            ps.setString(1, "EV2");
//            ps.setDouble(2, 2300.00);
//            int r3 = ps.executeUpdate();
//
//            System.out.println(r1 + " Affected");
//            System.out.println(r2 + " Affected");
//            System.out.println(r3 + " Affected");

            String sql = "INSERT INTO product (name, price) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, "EV0");
            ps.setDouble(2, 2300.00);
            ps.addBatch();

            ps.setString(1, "EV1");
            ps.setDouble(2, 2300.00);
            ps.addBatch();

            ps.setString(1, "EV2");
            ps.setDouble(2, 2300.00);
            ps.addBatch();

            int[] rows = ps.executeBatch();
            for (int row : rows) {
                System.out.println(row + " Affected");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}