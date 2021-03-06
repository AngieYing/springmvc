package turotial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import turotial.dtos.ClassDTO;
import turotial.models.ClassModel;
import turotial.services.ClassRoomService;
import turotial.services.ClassService;
import turotial.services.StudentService;
import turotial.services.TeacherService;

import javax.validation.Valid;
import java.util.*;


//@Controller + @ResponseBody

@RestController
@RequestMapping("/class")  // HandlerMapping
public class ClassController {

    private ClassRoomService classRoomService;

    private StudentService studentService;

    private TeacherService teacherService;

    private ClassService classService;

    /*
     * Request
     *
     * Header - url
     * 1. path variable: /class/{name}
     * 2. request parameter /class?name=
     * Body -> @RequestBody
     */
    // /class/{name}  // path variable
    // /class?name=XXX  //request parameter


    @RequestMapping(value = "/{name}", method = RequestMethod.POST)   // HandlerAdaptor
    public ResponseEntity<Long> startClass(@RequestBody @Valid final ClassDTO classData, final BindingResult bindingResult) {
        if (bindingResult.hasErrors() || !checkClassDataValidation(classData)) {
            return ResponseEntity.badRequest().build(); //400 at response header
        }
        
        final ClassModel classRecord = classService.AddClass(classData);
        return ResponseEntity.ok().body(classRecord.getClassId());
    }

     //RESTFUL API
    @RequestMapping(value = "/{classId}", method = RequestMethod.GET)
    public ResponseEntity<ClassModel> getClassStatus(@PathVariable(name = "classId") final String classId) {
        //TODO: implement

        return ResponseEntity.ok().body(classService.getClassById(classId));
    }

    @RequestMapping(value = "/{classId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteClass(@PathVariable(name = "classId") final String classId) {
        //TODO: implement
        return ResponseEntity.ok().body(classService.DeleteClassById(classId));
    }


    private boolean checkClassDataValidation(final ClassDTO classDTO) {
        if (!classRoomService.isValidClassRoomService(classDTO.getClassRoomNo())) {
            return false;
        }
        if (!teacherService.isValidTeacher(classDTO.getTeacherName())) {
            return false;
        }
        for (String studentName : classDTO.getStudentNames()) {
            if (!studentService.isValidStudent(studentName)) {
                return false;
            }
        }
        return true;
    }


    @Autowired
    public void setClassRoomService(@Qualifier("defaultClassRoomService") ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Autowired
    public void setClassService(ClassService classService) {
        this.classService = classService;
    }
}
