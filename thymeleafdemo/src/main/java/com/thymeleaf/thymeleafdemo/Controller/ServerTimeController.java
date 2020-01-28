package com.thymeleaf.thymeleafdemo.Controller;

import com.thymeleaf.thymeleafdemo.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@Controller
@RequestMapping("/")
public class ServerTimeController {

    @Autowired
    Employee employee;

    @PostMapping("/employeesubmit")
    public String getEmployeedetails(@ModelAttribute("employee") Employee employee) {

        System.out.println("-----------------------");
        System.out.println(employee);
        System.out.println("-----------------------");
        //employee.setAdmin(true);

        return "layouts/employee";
    }

    @GetMapping("/serverTime")
    public String showServerTime() {
        return "layouts/serverTime";
    }

    @GetMapping("/currentTime")
    @ResponseBody
    public String currentTime() {
        return LocalDateTime.now().toString();
    }

    @GetMapping("/loader")
    public String register(Employee employee) {
        return "layouts/loader";
    }
}
