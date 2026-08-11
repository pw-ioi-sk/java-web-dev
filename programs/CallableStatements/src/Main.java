import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/product_db";
        String username = "root";
        String password = "12345678";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

//            CallableStatement callableStatement = connection.prepareCall("{call getByName(?)}");
//            callableStatement.setString(1, "Smartphone");
//            ResultSet rs = callableStatement.executeQuery();
//            while (rs.next()) {
//                System.out.println(
//                        rs.getInt("id") + " " +
//                                rs.getString("name") + " " +
//                                rs.getDouble("price")
//                );
//            }
//            rs.close();
//            callableStatement.close();
//            connection.close();


//            CallableStatement cs = connection.prepareCall("{call getPrice(?, ?)}");
//            cs.setInt(1, 1);
//            cs.registerOutParameter(2, Types.DECIMAL);
//            cs.execute();
//            double price = cs.getDouble(2);
//
//            System.out.println("Price = " + price);
//
//            cs.close();
//            connection.close();


//            CallableStatement cs = connection.prepareCall("{call increaseValue(?)}");
//            cs.setDouble(1, 100.00);
//            cs.registerOutParameter(1, Types.DECIMAL);
//            cs.execute();
//            double result = cs.getDouble(1);
//
//            System.out.println("Result = " + result);
//
//            cs.close();
//            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}