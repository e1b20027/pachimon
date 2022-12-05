package oit.is.pachimon.kaizi.pachimon.controller;

import java.util.ArrayList;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.pachimon.kaizi.pachimon.model.Room;

@Controller
@RequestMapping("/pachimon")
public class PachimonController {
  @Autowired
  private Room room;

  @GetMapping("step1")
  public String sample31() {
    return "home.html";
  }

  @GetMapping("step2")
  public String sample32(ModelMap model, Principal prin) {
    String loginUser = prin.getName(); // ログインユーザ情報
    model.addAttribute("login_user", loginUser);
    return "home.html";
  }

  @GetMapping("step8")
  public String sample38(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    int usersNum = this.room.getUsersNum();
    model.addAttribute("room", this.room);
    model.addAttribute("usersNum", usersNum);// usersNum変数をhtmlで使えるようにモデルに登録
    return "home.html";
  }

  @GetMapping("step9")
  public String sample39(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("login_user", loginUser);
    ArrayList<String> u = room.getUsers();
    model.addAttribute("login_users", u);
    return "battle.html";
  }

}
