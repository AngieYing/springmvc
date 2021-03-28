package turotial.services.impl;

import org.springframework.stereotype.Component;
import turotial.models.TeacherModel;
import turotial.services.TeacherService;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultTeacherService implements TeacherService {

    private static final List<TeacherModel> allTeachers = new ArrayList<TeacherModel>();

    static {
        allTeachers.add(new TeacherModel("hana"));
        allTeachers.add(new TeacherModel("hana1"));
        allTeachers.add(new TeacherModel("hana2"));
    }

    @Override
    public boolean isValidTeacher(String teacherName) {
        return allTeachers
                .stream()
                .anyMatch(teacher -> teacher.getName().equals(teacherName));
    }
}
