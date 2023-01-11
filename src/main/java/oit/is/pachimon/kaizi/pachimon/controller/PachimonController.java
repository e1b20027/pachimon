package oit.is.pachimon.kaizi.pachimon.controller;

import java.util.ArrayList;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.pachimon.kaizi.pachimon.model.Room;
import oit.is.pachimon.kaizi.pachimon.model.ResultMapper;
import oit.is.pachimon.kaizi.pachimon.model.Result;

@Controller
@RequestMapping("/pachimon")
public class PachimonController {
  @Autowired
  private Room room;

  @Autowired
  ResultMapper resultMapper;

  @GetMapping("goHome")
  public String gohome() {
    return "home.html";
  }

  @GetMapping("goTitle")
  public String gotitle(Principal prin) {
    this.room.resetCount();
    this.room.resetHand();
    this.room.resetResult();
    this.room.resetlogout();
    return "home.html";
  }

  @GetMapping("title")
  public String title(Principal prin,ModelMap model) {
    this.room.setlogout();
    model.addAttribute("logoutflag", this.room.getlogout());
    return "battle.html";
  }

  @GetMapping("UserNum")
  public String usernum(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);
    model.addAttribute("usersNum", this.room.getUsersNum());// usersの要素数をhtmlで使えるように登録
    return "home.html";
  }

  @GetMapping("start")
  public String start(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.resetCount();
    this.room.firstSetHand();
    this.room.resetResult();
    int cnt = this.room.checkGetUser(loginUser);
    model.addAttribute("logoutflag", this.room.getlogout());
    model.addAttribute("hand", this.room.getHand(cnt));
    model.addAttribute("login_user", loginUser);
    model.addAttribute("login_users", room.getUsers());
    model.addAttribute("count", this.room.getCount());
    model.addAttribute("result_count", this.room.getResult());
    return "battle.html";
  }

  @GetMapping("restart")
  public String restart(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.resetCount();
    this.room.resetHand();
    this.room.resetResult();
    int cnt = this.room.checkGetUser(loginUser);
    model.addAttribute("logoutflag", this.room.getlogout());
    model.addAttribute("hand", this.room.getHand(cnt));
    model.addAttribute("login_user", loginUser);
    model.addAttribute("login_users", room.getUsers());
    model.addAttribute("count", this.room.getCount());
    model.addAttribute("result_count", this.room.getResult());
    return "battle.html";
  }

  @GetMapping("startAdmin")
  public String startadmin(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.adminUser(loginUser);
    this.room.adminUser(loginUser);
    this.room.resetCount();
    this.room.firstSetHand();
    this.room.resetResult();
    int cnt = this.room.checkGetUser(loginUser);
    model.addAttribute("logoutflag", this.room.getlogout());
    model.addAttribute("hand", this.room.getHand(cnt));
    this.room.setHand("ほのお", 1);
    model.addAttribute("login_user", loginUser);
    model.addAttribute("login_users", room.getUsers());
    model.addAttribute("count", this.room.getCount());
    model.addAttribute("result_count", this.room.getResult());
    return "battle.html";
  }

  @GetMapping("restartAdmin")
  public String restartadmin(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.adminUser(loginUser);
    this.room.adminUser(loginUser);
    this.room.resetCount();
    this.room.resetHand();
    this.room.resetResult();
    int cnt = this.room.checkGetUser(loginUser);
    model.addAttribute("logoutflag", this.room.getlogout());
    model.addAttribute("hand", this.room.getHand(cnt));
    this.room.setHand("ほのお", 1);
    model.addAttribute("login_user", loginUser);
    model.addAttribute("login_users", room.getUsers());
    model.addAttribute("count", this.room.getCount());
    model.addAttribute("result_count", this.room.getResult());
    return "battle.html";
  }

  @GetMapping("honou")
  public String honou(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    int cnt = this.room.checkGetUser(loginUser);
    this.room.resetResult();
    model.addAttribute("logoutflag", this.room.getlogout());
    model.addAttribute("login_user", loginUser);
    model.addAttribute("login_users", this.room.getUsers());
    this.room.setHand("ほのお", cnt);
    model.addAttribute("hand", this.room.getHand(cnt));
    model.addAttribute("count", this.room.getCount());
    model.addAttribute("result_count", this.room.getResult());
    return "battle.html";
  }

  @GetMapping("mizu")
  public String mizu(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    int cnt = this.room.checkGetUser(loginUser);
    this.room.resetResult();
    model.addAttribute("logoutflag", this.room.getlogout());
    model.addAttribute("login_user", loginUser);
    model.addAttribute("login_users", this.room.getUsers());
    this.room.setHand("みず", cnt);
    model.addAttribute("hand", this.room.getHand(cnt));
    model.addAttribute("count", this.room.getCount());
    model.addAttribute("result_count", this.room.getResult());
    return "battle.html";
  }

  @GetMapping("kusa")
  public String kusa(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    int cnt = this.room.checkGetUser(loginUser);
    this.room.resetResult();
    model.addAttribute("logoutflag", this.room.getlogout());
    model.addAttribute("login_user", loginUser);
    model.addAttribute("login_users", this.room.getUsers());
    this.room.setHand("くさ", cnt);
    model.addAttribute("hand", this.room.getHand(cnt));
    model.addAttribute("count", this.room.getCount());
    model.addAttribute("result_count", this.room.getResult());
    return "battle.html";
  }

  @GetMapping("result")
  public String result(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    int cnt = this.room.checkGetUser(loginUser);//添え字
    this.room.setResult(cnt);
    model.addAttribute("login_user", loginUser);
    model.addAttribute("login_users", this.room.getUsers());
    model.addAttribute("hand", this.room.getHand(cnt));
    model.addAttribute("count", this.room.getCount());
    model.addAttribute("result_count", this.room.getResult());
    model.addAttribute("logoutflag", this.room.getlogout());
    if (cnt == 0) {
      String result2 = resultMapper.selectp1(this.room.getHand(0), this.room.getHand(1));
      model.addAttribute("result2", result2);
    } else if (cnt == 1) {
      String result2 = resultMapper.selectp2(this.room.getHand(0), this.room.getHand(1));
      model.addAttribute("result2", result2);
    }
    return "battle.html";
  }

  @GetMapping("logout2")
  public String logout(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    int cnt = this.room.checkGetUser(loginUser);// 添え字
    this.room.removeUser(cnt);
    return "logout.html";
  }
}
