import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "12345678";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

//             yyyy-MM-dd
//            java.sql.Date date = java.sql.Date.valueOf("2026-08-09");
//            java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(LocalDateTime.now());
//            // HH:mm:ss
//            Time time = Time.valueOf(LocalTime.now());
//            System.out.println(date + " " + time + " " + timestamp + " " + LocalTime.now() + " " + LocalDate.now() + " " + LocalDateTime.now());


//            String sql = "SELECT * FROM employee WHERE joining_date > ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setDate(1, java.sql.Date.valueOf("2024-01-01"));
//            ResultSet resultSet = preparedStatement.executeQuery();
//            resultSet.next();

//            int id                          = resultSet.getInt("id");
//            String name                     = resultSet.getString("name");
//            java.sql.Date date              = resultSet.getDate(3);
//            java.sql.Time time              = resultSet.getTime(4);
//            java.sql.Timestamp timestamp    = resultSet.getTimestamp(5);
//            LocalDate localDate = date.toLocalDate();
//            LocalTime localTime = time.toLocalTime();
//            LocalDateTime localDateTime = timestamp.toLocalDateTime();
//            System.out.println( localDate.plusDays(30) + "\t" +
//            localTime.plusHours(2) + "\t" +
//            localDateTime.plusSeconds(21));
//
//            System.out.println("id\tname\tjoining_date\tjoining_time\tcreated_at");
//            System.out.println(id + "\t" + name + "\t" + date + "\t\t" + time + "\t\t" + timestamp);


//            String sql = "SELECT * FROM employee WHERE joining_date > ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setDate(1, java.sql.Date.valueOf("2024-01-01"));
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                System.out.println(
//                        resultSet.getInt(1) + "\t" +
//                                resultSet.getString("name") + "\t" +
//                                resultSet.getDate(3) + "\t" +
//                                resultSet.getTime(4) + "\t" +
//                                resultSet.getTimestamp(5));
//            }


//            String sql = """
//                            INSERT INTO employee
//                            (name, joining_date, joining_time, created_at, last_updated)
//                            VALUES (?, ?, ?, ?, ?)
//            """;

//            PreparedStatement ps = connection.prepareStatement(sql);
//
//            ps.setString(1, "Karan");
//            ps.setDate(2, java.sql.Date.valueOf("2026-08-09"));
//            ps.setTime(3, java.sql.Time.valueOf("10:30:00"));
//            ps.setTimestamp(4, java.sql.Timestamp.valueOf(LocalDateTime.now()));
//            ps.setTimestamp(5, java.sql.Timestamp.valueOf(LocalDateTime.now())
//            );
//
//            ps.executeUpdate();


//            Statement statement = connection.createStatement();
//            String sql = "SELECT * FROM employee";
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while (resultSet.next()) {
//                System.out.println(
//                        resultSet.getInt(1) + "\t" +
//                        resultSet.getString("name") + "\t" +
//                        resultSet.getDate(3) + "\t" +
//                        resultSet.getTime(4) + "\t" +
//                        resultSet.getTimestamp(5) + "\t" +
//                        resultSet.getTimestamp("last_updated"))
//                ;
//            }

//            String sql = "DELETE FROM employee WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, 9);
//            int row = preparedStatement.executeUpdate();
//            System.out.println(row + " Affected");

//            String sql = "SELECT name, joining_date FROM employee";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                System.out.println(
//                        rs.getString("name") + "\t" +
//                                rs.getDate("joining_date")
//                );
//            }


//            String sql = "SELECT name, joining_time FROM employee";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                System.out.println(
//                        rs.getString("name") + "\t" +
//                                rs.getTime("joining_time")
//                );
//            }


//            String sql = "SELECT name, created_at FROM employee";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                System.out.println(
//                        rs.getString("name") + "\t" +
//                                rs.getTimestamp("created_at")
//                );
//            }


//            String sql = "SELECT * FROM employee WHERE joining_date > ?";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setDate(1, java.sql.Date.valueOf("2024-01-01"));
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                System.out.println(
//                        rs.getInt("id") + "\t" +
//                                rs.getString("name") + "\t" +
//                                rs.getDate("joining_date")
//                );
//            }


//            String sql = """
//                            SELECT *
//                            FROM employee
//                            WHERE joining_date BETWEEN ? AND ?
//            """;
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setDate(1, java.sql.Date.valueOf("2024-01-01"));
//            ps.setDate(2, java.sql.Date.valueOf("2025-12-31"));
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                System.out.println(
//                        rs.getInt("id") + "\t" +
//                                rs.getString("name") + "\t" +
//                                rs.getDate("joining_date")
//                );
//            }


//            String sql = """
//        SELECT name,
//               joining_date,
//               DATE_ADD(joining_date, INTERVAL 30 DAY)
//                   AS after_30_days
//        FROM employee
//        """;
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                System.out.println(
//                        rs.getString("name") + "\t" +
//                                rs.getDate("joining_date") + "\t" +
//                                rs.getDate("after_30_days")
//                );
//            }


//            String sql = """
//        SELECT name,
//               joining_date,
//               DATE_SUB(joining_date, INTERVAL 30 DAY)
//                   AS before_30_days
//        FROM employee
//        """;
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                System.out.println(
//                        rs.getString("name") + "\t" +
//                                rs.getDate("joining_date") + "\t" +
//                                rs.getDate("before_30_days")
//                );
//            }


//            String sql = """
//                        SELECT name, joining_date,
//                        DATE_ADD(joining_date, INTERVAL ? DAY) AS after_days
//                        FROM employee
//            """;
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, 30);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                System.out.println(
//                        rs.getString("name") + "\t" +
//                                rs.getDate("joining_date") + "\t" +
//                                rs.getDate("after_days")
//                );
//            }

//            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"));
//            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

            System.out.println("Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}