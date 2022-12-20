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
public class ImgController {
  @GetMapping("/")
  public String getIndex() {
    return "image";
  }
/*
  @RequestMapping("/getImg")
  @ResponseBody
  public HttpEntity<byte[]> getImg(@RequestParam("name") String fileName) {
    File fileImg = new File("img/" + fileName + ".png");

    byte[] byteImg = null;
    HttpHeaders headers = null;
    try {
      // バイト列に変換
      byteImg = Files.readAllBytes(fileImg.toPath());
      headers = new HttpHeaders();

      // Responseのヘッダーを作成
      headers.setContentType(MediaType.IMAGE_PNG);
      headers.setContentLength(byteImg.length);
    } catch (IOException e) {
      return null;
    }
    return new HttpEntity<byte[]>(byteImg, headers);
  }*/
}
