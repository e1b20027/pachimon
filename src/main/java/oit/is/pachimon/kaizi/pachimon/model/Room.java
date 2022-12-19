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
  int[] count = new int[2];

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

  public int checkGetUser(String name) {
    int cnt = this.users.indexOf(name);
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

  public void setHand(String hand, int cnt) {
    this.hands.set(cnt, hand);
    this.count[cnt]++;
  }

  public void setCount() {
    this.count[0] = 0;
    this.count[1] = 0;
  }

  public int getCount() {
    for(int i=0;i<2;i++){
      if(this.count[i]==0)
        return 1;
    }
    return 2;
  }

  public void resetHand() {
    this.hands.add("なし");
    this.hands.add("なし");
  }

  public String getHand(int cnt) {
    return this.hands.get(cnt);
  }

}
