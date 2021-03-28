package turotial.services;

import turotial.dtos.ClassDTO;
import turotial.models.ClassModel;

import java.util.*;

public interface ClassService {

    ClassModel AddClass(ClassDTO classDTO);

    ClassModel getClassById(String classId);

    String closeClass(String classId);

    boolean isValidClass(String classId);

    String DeleteClassById(String classId);

    enum ClassStatus {
        READY,IN_PROCESS, CLOSED
    }
}
