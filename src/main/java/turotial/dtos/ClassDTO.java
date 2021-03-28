package turotial.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ClassDTO {
    @NotNull
    private String teacherName;

    @NotEmpty
    private List<String> studentNames;

    @NotNull
    private String classRoomNo;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<String> getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(List<String> studentNames) {
        this.studentNames = studentNames;
    }

    public String getClassRoomNo() {
        return classRoomNo;
    }

    public void setClassRoomNo(String classRoomNo) {
        this.classRoomNo = classRoomNo;
    }
}
