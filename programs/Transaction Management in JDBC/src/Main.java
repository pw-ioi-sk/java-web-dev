import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bank_db";
        String username = "root";
        String password = "12345678";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);

            System.out.println("Transaction started");

            String sql1 = "UPDATE account SET balance = balance - 1000 WHERE id = 1";
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.executeUpdate();
            System.out.println("Alice: 1000 deducted");

            String wrongSql = "UPDATE account SET balaance = balance + 1000 WHERE id = 2";
            PreparedStatement ps2 = connection.prepareStatement(wrongSql);

            ps2.executeUpdate();

            System.out.println("Bob: 1000 added");

//            throw new SQLException("Something went wrong!");

//            connection.commit();

//            System.out.println("Transaction committed");

        } catch (SQLException e) {
            System.out.println("SQL ERROR OCCURRED!");
            System.out.println(e.getMessage());
            try {
                assert connection != null;
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            System.out.println("Rollback completed");

//            try {
//                if (connection != null) {
//                    // Undo Alice's deduction
//                    connection.rollback();
//                    System.out.println("ROLLBACK DONE");
//                }
//            } catch (SQLException rollbackException) {
//                rollbackException.printStackTrace();
//            }

        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                    connection.close();
                    System.out.println("Connection closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}