package turotial.services.impl;

import org.springframework.stereotype.Component;
import turotial.dtos.*;
import turotial.models.*;
import turotial.services.ClassService;

import java.util.*;

@Component
public class DefaultClassService implements ClassService {
    private final static Map<String,ClassModel> recordedClasses = new HashMap<>();
    // final:cannot be re-bound to reference another object

    @Override
    public ClassModel AddClass(ClassDTO classDTO) {
        ClassModel newClass = new ClassModel();
        newClass.setClassRoom(new ClassRoomModel(classDTO.getClassRoomNo()));
        newClass.setTeacher(new TeacherModel(classDTO.getTeacherName()));
        List<String> studentList = classDTO.getStudentNames();
        for(String studentName : studentList){
            StudentModel student = new StudentModel(studentName);
            newClass.getStudents().add(student);
        }
        return newClass;
    }

    @Override
    public ClassModel getClassById(String classId) {
        return recordedClasses.get(classId);
    }

    @Override
    public String closeClass(String classId) {
        ClassModel TargetClass = recordedClasses.get(classId);
        if(TargetClass == null){ return "Failed to close the class!";}
        else{
            TargetClass.setStatus(ClassStatus.CLOSED); // Do I need to update map ?
            return "Class closed successfully!";
        }

    }

    @Override
    public boolean isValidClass(String classId) {
        return recordedClasses.containsKey(classId);
    }

    @Override
    public String DeleteClassById(String classId) {
        return (recordedClasses.remove(classId)==null) ? "Class not found!" : "Class deleted!" ;
    }
}
