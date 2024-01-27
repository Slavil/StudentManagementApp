package net.javaguides.sms.controller;

import net.javaguides.sms.entity.StudentsClass;
import net.javaguides.sms.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClassController {

    @Autowired
    private ClassService classService;
    public ClassController(ClassService classService) {
        super();
        this.classService = classService;
    }


    @GetMapping("/classes")
    public String listClasses(Model model) {
        List<StudentsClass> classes = classService.getAllClasses();
        model.addAttribute("classes", classes);
        return "classes";
    }

    @GetMapping("/classes/new")
    public String createClassForm(Model model) {
        StudentsClass studentsClass = new StudentsClass();
        model.addAttribute("studentsClass", studentsClass);
        return "addClass";
    }

    @PostMapping("/classes")
    public String saveClass(@ModelAttribute("studentsClass") StudentsClass studentsClass) {
        classService.saveClass(studentsClass);
        return "redirect:/classes";
    }

    @GetMapping("/classes/delete/{id}")
    public String deleteClass(@PathVariable Long id) {
        classService.deleteClassById(id);
        return "redirect:/classes";
    }
}
