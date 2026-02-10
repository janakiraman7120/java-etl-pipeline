import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentETL {

    public static void main(String[] args) {

        String filePath = "students.csv.txt";

        String url = "jdbc:postgresql://localhost:5432/etl_project";
        String user = "postgres";
        String password = "root"; // change this

        try (
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            Connection conn = DriverManager.getConnection(url, user, password)
        ) {

            String line;
            boolean isHeader = true;

            String sql = "INSERT INTO students_clean (id, name, marks) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            while ((line = br.readLine()) != null) {

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if(data.length<3)
                    continue;

                String idStr = data[0];
                String name = data[1];
                String marksStr = data[2];

                // TRANSFORM
                if (name.isEmpty() || marksStr.isEmpty())
                    continue;

                int marks = Integer.parseInt(marksStr);
                int id = Integer.parseInt(idStr);

                if (marks < 0 || marks > 100)
                    continue;

                // LOAD
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, marks);

                ps.executeUpdate();
            }

            System.out.println("ETL Pipeline Completed Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
