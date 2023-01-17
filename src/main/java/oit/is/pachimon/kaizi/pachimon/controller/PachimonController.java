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
    this.room.resetscore();
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
    model.addAttribute("usersNum", this.room.getUsersNum());
    return "home.html";
  }

  @GetMapping("start")
  public String start(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.resetCount();
    this.room.firstSetHand();
    this.room.resetResult();
    this.room.reseth();
    this.room.resetm();
    this.room.resetm1();
    this.room.resetm2();
    this.room.resetk();
    this.room.resetscore();
    this.room.resetflag();
    int cnt = this.room.checkGetUser(loginUser);
    model.addAttribute("player1_score", this.room.getscore(0));
    model.addAttribute("player2_score", this.room.getscore(1));
    model.addAttribute("handm", this.room.getm(cnt));
    model.addAttribute("handm1", this.room.getm1(cnt));
    model.addAttribute("handm2", this.room.getm2(cnt));
    model.addAttribute("handk", this.room.getk(cnt));
    model.addAttribute("handh", this.room.geth(cnt));
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
    this.room.resetflag();
    int cnt = this.room.checkGetUser(loginUser);
    model.addAttribute("player1_score", this.room.getscore(0));
    model.addAttribute("player2_score", this.room.getscore(1));
    model.addAttribute("handm", this.room.getm(cnt));
    model.addAttribute("handm1", this.room.getm1(cnt));
    model.addAttribute("handm2", this.room.getm2(cnt));
    model.addAttribute("handk", this.room.getk(cnt));
    model.addAttribute("handh", this.room.geth(cnt));
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
    this.room.reseth();
    this.room.resetk();
    this.room.resetm();
    this.room.resetm1();
    this.room.resetm2();
    this.room.resetscore();
    this.room.resetflag();
    int cnt = this.room.checkGetUser(loginUser);
    model.addAttribute("player1_score", this.room.getscore(0));
    model.addAttribute("player2_score", this.room.getscore(1));
    model.addAttribute("handm", this.room.getm(cnt));
    model.addAttribute("handm1", this.room.getm1(cnt));
    model.addAttribute("handm2", this.room.getm2(cnt));
    model.addAttribute("handk", this.room.getk(cnt));
    model.addAttribute("handh", this.room.geth(cnt));
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
    this.room.resetflag();
    int cnt = this.room.checkGetUser(loginUser);
    model.addAttribute("player1_score", this.room.getscore(0));
    model.addAttribute("player2_score", this.room.getscore(1));
    model.addAttribute("handm", this.room.getm(cnt));
    model.addAttribute("handm1", this.room.getm1(cnt));
    model.addAttribute("handm2", this.room.getm2(cnt));
    model.addAttribute("handk", this.room.getk(cnt));
    model.addAttribute("handh", this.room.geth(cnt));
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
    this.room.seth(cnt);
    model.addAttribute("player1_score", this.room.getscore(0));
    model.addAttribute("player2_score", this.room.getscore(1));
    model.addAttribute("handh", this.room.geth(cnt));
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
    this.room.setm(cnt);
    model.addAttribute("player1_score", this.room.getscore(0));
    model.addAttribute("player2_score", this.room.getscore(1));
    model.addAttribute("handm", this.room.getm(cnt));
    model.addAttribute("logoutflag", this.room.getlogout());
    model.addAttribute("login_user", loginUser);
    model.addAttribute("login_users", this.room.getUsers());
    this.room.setHand("みず", cnt);
    model.addAttribute("hand", this.room.getHand(cnt));
    model.addAttribute("count", this.room.getCount());
    model.addAttribute("result_count", this.room.getResult());
    return "battle.html";
  }

  @GetMapping("mizu1")
  public String mizu1(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    int cnt = this.room.checkGetUser(loginUser);
    this.room.resetResult();
    this.room.setm1(cnt);
    model.addAttribute("player1_score", this.room.getscore(0));
    model.addAttribute("player2_score", this.room.getscore(1));
    model.addAttribute("handm1", this.room.getm1(cnt));
    model.addAttribute("logoutflag", this.room.getlogout());
    model.addAttribute("login_user", loginUser);
    model.addAttribute("login_users", this.room.getUsers());
    this.room.setHand("みず", cnt);
    model.addAttribute("hand", this.room.getHand(cnt));
    model.addAttribute("count", this.room.getCount());
    model.addAttribute("result_count", this.room.getResult());
    return "battle.html";
  }

  @GetMapping("mizu2")
  public String mizu2(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    int cnt = this.room.checkGetUser(loginUser);
    this.room.resetResult();
    this.room.setm2(cnt);
    model.addAttribute("player1_score", this.room.getscore(0));
    model.addAttribute("player2_score", this.room.getscore(1));
    model.addAttribute("handm2", this.room.getm2(cnt));
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
    this.room.setk(cnt);
    model.addAttribute("player1_score", this.room.getscore(0));
    model.addAttribute("player2_score", this.room.getscore(1));
    model.addAttribute("handk", this.room.getk(cnt));
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
    int flag1 = this.room.getflag(0);
    int flag2 = this.room.getflag(1);
    this.room.setResult(cnt);
    model.addAttribute("handm", this.room.getm(cnt));
    model.addAttribute("handm1", this.room.getm1(cnt));
    model.addAttribute("handm2", this.room.getm2(cnt));
    model.addAttribute("handk", this.room.getk(cnt));
    model.addAttribute("handh", this.room.geth(cnt));
    model.addAttribute("login_user", loginUser);
    model.addAttribute("login_users", this.room.getUsers());
    model.addAttribute("hand", this.room.getHand(cnt));
    model.addAttribute("count", this.room.getCount());
    model.addAttribute("result_count", this.room.getResult());
    model.addAttribute("logoutflag", this.room.getlogout());
    model.addAttribute("player1_score", this.room.getscore(0));
    model.addAttribute("player2_score", this.room.getscore(1));
    if (cnt == 0) {
      String result2 = resultMapper.selectp1(this.room.getHand(0), this.room.getHand(1));
      model.addAttribute("result2", result2);
      model.addAttribute("player1_hand", this.room.getHand(0));
      model.addAttribute("player2_hand", this.room.getHand(1));
      if (flag1 == 0) {
        switch (result2) {
          case "かち":
            if (this.room.getHand(0) == "ほのお" && this.room.getHand(1) == "くさ") {
              this.room.setscore(cnt, 10);
            } else {
              this.room.setscore(cnt, 3);
            }
            break;
          case "あいこ":
            this.room.setscore(cnt, 2);
            break;
          case "まけ":
            this.room.setscore(cnt, 1);
            break;
        }
      }
    } else if (cnt == 1) {
      String result2 = resultMapper.selectp2(this.room.getHand(0), this.room.getHand(1));
      model.addAttribute("result2", result2);
      model.addAttribute("player1_hand", this.room.getHand(1));
      model.addAttribute("player2_hand", this.room.getHand(0));
      if (flag2 == 0) {
        switch (result2) {
          case "かち":
            if (this.room.getHand(1) == "ほのお" && this.room.getHand(0) == "くさ") {
              this.room.setscore(cnt, 10);
            } else {
              this.room.setscore(cnt, 3);
            }
            break;
          case "あいこ":
            this.room.setscore(cnt, 2);
            break;
          case "まけ":
            this.room.setscore(cnt, 1);
            break;
        }
      }
    }
    this.room.setflag(cnt);
    model.addAttribute("player1_score", this.room.getscore(0));
    model.addAttribute("player2_score", this.room.getscore(1));
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
