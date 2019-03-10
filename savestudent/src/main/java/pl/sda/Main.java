package pl.sda;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.studentmodel.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 =new Student ("Marek","Markiweicz",1234);
        Student student2 =new Student ("Jarek","Jarkiweicz",4567);
        Student student3 =new Student ("Darek","Darkiweicz",7987);
        Student student4 =new Student ("Stefan","Stefanowicz",4321);
        Student student5 =new Student ("Antek","Atoniewicz",2344);

        List<Student> studentList =new ArrayList<> ();
        studentList.add (student1);
        studentList.add (student2);
        studentList.add (student3);
        studentList.add (student4);
        studentList.add (student5);

        ObjectMapper mapper = new ObjectMapper ();
        try {
            String studentStr = mapper.writeValueAsString (studentList);

            Files.write (Paths.get ("student.json"), studentStr.getBytes ());

        } catch (IOException e) {
            e.printStackTrace ();
        }

    }
}
