package turotial.models;

import turotial.services.*;
import javax.persistence.*;

import java.util.List;
import java.util.UUID;

public class ClassModel {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long classId;
    private TeacherModel teacher;
    private ClassRoomModel classRoom;
    private List<StudentModel> students;
    private ClassService.ClassStatus status = ClassService.ClassStatus.READY;


    public Long getClassId() {
        return classId;
    }

    public TeacherModel getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherModel teacher) {
        this.teacher = teacher;
    }

    public ClassRoomModel getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoomModel classRoom) {
        this.classRoom = classRoom;
    }

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }

    public ClassService.ClassStatus getStatus() {
        return status;
    }

    public void setStatus(ClassService.ClassStatus status) {
        this.status = status;
    }
}
