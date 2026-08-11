import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
//        HikariConfig config = new HikariConfig();
//
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/product_db");
//        config.setUsername("root");
//        config.setPassword("12345678");
//
//        config.setMaximumPoolSize(3);
//        HikariDataSource dataSource = new HikariDataSource(config);
//
//        for (int i = 1; i <= 5; i++) {
//            int user = i;
//            Thread thread = new Thread(() -> {
//                String sql = "SELECT * FROM product";
//                try (Connection connection = dataSource.getConnection();
//                     PreparedStatement statement = connection.prepareStatement(sql);
//                     ResultSet resultSet = statement.executeQuery()
//                ) {
//                    System.out.println("User " + user + " got connection");
//                    while (resultSet.next()) {
//                        System.out.println("User " + user + " → " + resultSet.getString("name"));
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            });
//
//            thread.start();
//        }

//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/product_db");
//        config.setUsername("root");
//        config.setPassword("12345678");
//
//        // Maximum 3 physical database connections
//        config.setMaximumPoolSize(3);
//        HikariDataSource dataSource = new HikariDataSource(config);
//        System.out.println("Pool created");
//
//        try {
//            Connection connection = dataSource.getConnection();
//            System.out.println("Got connection");
//            connection.close();
//            System.out.println("Connection returned");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        dataSource.close();
//
//
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:mysql://localhost:3306/product_db");
        config.setUsername("root");
        config.setPassword("12345678");
//
//        // Pool configuration
        config.setMaximumPoolSize(3);
        config.setConnectionTimeout(300000);

        HikariDataSource dataSource = new HikariDataSource(config);

        for (int i = 1; i <= 5; i++) {
            int user = i;
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("User " + user + " requesting connection");
                    try (Connection connection = dataSource.getConnection()) {
                        System.out.println("User " + user + " GOT connection");

                        // Simulate database work
                        Thread.sleep(5000);
                        System.out.println("User " + user + " finished work");
                    }

                    // Connection automatically
                    // returned to pool

                    System.out.println("User " + user + " RETURNED connection");

                } catch (Exception e) {
                    System.out.println("User " + user + " failed: " + e.getMessage());
                }
            });

            thread.start();
        }
    }
}