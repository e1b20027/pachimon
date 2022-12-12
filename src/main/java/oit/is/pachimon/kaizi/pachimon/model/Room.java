package oit.is.pachimon.kaizi.pachimon.model;

import java.util.ArrayList;
import java.util.concurrent.Flow.Publisher;

import org.springframework.stereotype.Component;

@Component
public class Room {
  ArrayList<String> users = new ArrayList<>();
  int roomNo = 99;
  ArrayList<String> hands = new ArrayList<>();
  String hand;

  public void addUser(String name) {
    // 同名のユーザが居たら何もせずにreturn
    for (String s : this.users) {
      if (s.equals(name)) {
        return;
      }
    }
    // 同名のユーザが居なかった場合はusersにnameを追加する
    this.users.add(name);
  }

  public int checkSetUser(String name) {
    int cnt = 0;
    for (String s : this.users) {
      if (s.equals(name)) {
        break;
      }
      cnt++;
    }
    return cnt;
  }

  // 以降はフィールドのgetter/setter
  // これらがないとThymeleafで値を取得できない
  public int getRoomNo() {
    return roomNo;
  }

  public void setRoomNo(int roomNo) {
    this.roomNo = roomNo;
  }

  public ArrayList<String> getUsers() {
    return this.users;
  }

  public int getUsersNum() {
    return this.users.size();
  }

  public void setHand(String hand,int cnt) {
    this.hands.add(cnt,hand);
  }

  public String getHand(int cnt) {
    return this.hands.get(cnt);
  }

  public int getHandsNum() {
    return this.hands.size();
  }

}
