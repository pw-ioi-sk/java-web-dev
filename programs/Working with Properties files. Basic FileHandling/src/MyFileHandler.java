import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MyFileHandler {
    public static void main(String[] args) {
//        File file = new File("test.txt");
//
//        if (file.exists()) {
//            System.out.println("File exists");
//        } else {
//            System.out.println("File does not exist");
//        }

        File file = new File("test.txt");
//
//        try {
//            if (file.createNewFile()) {
//                System.out.println("File created");
//            } else {
//                System.out.println("File already exists");
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        System.out.println(file.getName());
//        System.out.println(file.getPath());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.isFile());
//        System.out.println(file.isDirectory());
//        System.out.println(file.length());

//        try {
//            FileWriter writer = new FileWriter("test.txt", true);
//
//            writer.write("\nHello JDBC");
//
//            writer.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            FileReader reader = new FileReader("test.txt");
//            int ch;
//            while ((ch = reader.read()) != -1) {
//                System.out.print((char) ch);
//            }
//
//            reader.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

//        File file = new File("test.txt");
//        if (file.delete()) {
//            System.out.println("File deleted");
//        } else {
//            System.out.println("File not found");
//        }

//        File directory = new File("data");
//        directory.mkdir();

//        File directory = new File("data/products/images");
//
//        directory.mkdirs();

//        File directory = new File("data");
//
//        String[] files = directory.list();
//
//        for (String file : files) {
//            System.out.println(file);
//        }

//        Path path = Path.of("test.txt");
//        System.out.println(path);
//        System.out.println(Files.exists(path));
//        try {
//            Files.createFile(path);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            Files.delete(path);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            Files.writeString(path, "Hello Java");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            Files.writeString(path, "Hello JDBC", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            String data = Files.readString(path);
//            System.out.println(data);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
