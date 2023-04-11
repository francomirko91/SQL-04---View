import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/mirkodb", "developer", "developer");
            Statement statement = connection.createStatement();

            ArrayList<Student> italianStudents = new ArrayList<>();
            ArrayList<Student> germanStudents = new ArrayList<>();


            ResultSet resultSet = statement.executeQuery("select first_name,last_name from italian_students");
            while (resultSet.next()) {
                String name = resultSet.getString("first_name");
                String surname = resultSet.getString("last_name");
                italianStudents.add(new Student(name, surname));

            }

            ResultSet resultSet2 = statement.executeQuery("select first_name,last_name from german_students");
            while (resultSet2.next()) {
                String name = resultSet2.getString("first_name");
                String surname = resultSet2.getString("last_name");
                germanStudents.add(new Student(name, surname));
            }

            for (Student student : italianStudents) {
                System.out.println(student.getName());
                System.out.println(student.getSurname());
            }
            for (Student student : germanStudents) {
                System.out.println(student.getName());
                System.out.println(student.getSurname());
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}