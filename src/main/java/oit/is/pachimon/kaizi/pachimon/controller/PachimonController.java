package oit.is.pachimon.kaizi.pachimon.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import oit.is.inudaisuki.springboot_samples.model.Room;

@Controller
@RequestMapping("/pachimon")
public class PachimonController {

  @GetMapping("step1")
  public String sample31() {
    return "home.html";
  }
}
