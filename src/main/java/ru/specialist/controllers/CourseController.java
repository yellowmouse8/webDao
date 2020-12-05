package ru.specialist.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.specialist.DAO.Course;
import ru.specialist.DAO.CourseService;

import java.util.List;


@Controller
@RequestMapping("/courses/")
public class CourseController {
    private final Logger logger = LoggerFactory.getLogger(CourseController.class);
    private CourseService courseService;
    private MessageSource messageSource;
    @Autowired
    public void setContactService(CourseService courseService){
        this.courseService = courseService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel){
        logger.info(" Listing course ");
        List<Course> courses = courseService.findAll();
        uiModel.addAttribute("courses", courses);
        logger.info("No. of courses: " + courses.size());
        return "courses/list";
    }


    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, Model uiModel) {
        if (courseService.findById(id) != null) {
            courseService.delete(id);
        }
        logger.info(" Delete course: " + id);
        return "redirect:/courses";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") int id, Model uiModel){
        uiModel.addAttribute("course", courseService.findById(id));
        return "courses/edit";
    }

    @RequestMapping(value = "update/0", method = RequestMethod.GET)
    public String newForm(Model uiModel){
        return "courses/edit";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(Course course, BindingResult bindingResult,
                         Model uiModel){
    if (bindingResult.hasErrors()){
        uiModel.addAttribute("course", course);
        return "courses/update";
    }
    courseService.save(course);
    return "redirect:/courses/";
    }
}
