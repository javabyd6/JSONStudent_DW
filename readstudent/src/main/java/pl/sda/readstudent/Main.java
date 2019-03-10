package pl.sda.readstudent;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.studentmodel.Student;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        ObjectMapper mapper = new ObjectMapper ();
        try {

            Student[] studentRead = mapper.readValue (new File ("student.json"), Student[].class);
            List<Student> studentList = Arrays.asList (studentRead);
            System.out.println (studentList.toString ());
            List<Student> studentFilter = studentList.stream ().filter (s-> s.getName ().startsWith ("A"))
                    .collect(Collectors.toList());
            for (Student e :studentFilter) {
                System.out.println (e);
            }
           // System.out.println (studentFilter.toString ());
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }
}