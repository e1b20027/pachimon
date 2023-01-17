package oit.is.pachimon.kaizi.pachimon.model;

import java.util.ArrayList;
import java.util.concurrent.Flow.Publisher;

import org.springframework.stereotype.Component;

@Component
public class Room {
  ArrayList<String> users = new ArrayList<>();
  ArrayList<String> hands = new ArrayList<>();
  String hand;
  int[] flag = new int[2];
  int[] count = new int[2];
  int[] result = new int[2];
  int logoutflag = 0;
  int[] hflag = new int[2];
  int[] kflag = new int[2];
  int[] mflag = new int[2];
  int[] m1flag = new int[2];
  int[] m2flag = new int[2];
  int[] score = new int[2];

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

  public void adminUser(String name) {
    this.users.add(name);
  }

  public int checkGetUser(String name) {
    int cnt = this.users.indexOf(name);
    return cnt;
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

  public void resetCount() {
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

  public void firstSetHand() {
    this.hands.add("なし");
    this.hands.add("なし");
  }

  public void resetHand() {
    hands.set(0, "なし");
    hands.set(1, "なし");
  }

  public String getHand(int cnt) {
    return this.hands.get(cnt);
  }

  public void setResult(int cnt) {
    this.result[cnt]++;
  }

  public int getResult() {
    for (int i = 0; i < 2; i++) {
      if (this.result[i] == 0)
        return 1;
    }
    return 2;
  }

  public void resetResult() {
    this.result[0] = 0;
    this.result[1] = 0;
  }

  public void removeUser(int cnt) {
    this.users.remove(cnt);
  }

  public void resetlogout() {
    this.logoutflag = 0;
  }

  public void setlogout() {
    this.logoutflag = 1;
  }

  public int getlogout() {
    return this.logoutflag;
  }

  public void reseth() {
    this.hflag[0] = 0;
    this.hflag[1] = 0;
  }

  public void seth(int cnt) {
    this.hflag[cnt]=1;
  }

  public int geth(int cnt) {
    return this.hflag[cnt];
  }

  public void resetm() {
    this.mflag[0] = 0;
    this.mflag[1] = 0;
  }

  public void setm(int cnt) {
    this.mflag[cnt]=1;
  }

  public int getm(int cnt) {
    return this.mflag[cnt];
  }

  public void resetm1() {
    this.m1flag[0] = 0;
    this.m1flag[1] = 0;
  }

  public void setm1(int cnt) {
    this.m1flag[cnt] = 1;
  }

  public int getm1(int cnt) {
    return this.m1flag[cnt];
  }

  public void resetm2() {
    this.m2flag[0] = 0;
    this.m2flag[1] = 0;
  }

  public void setm2(int cnt) {
    this.m2flag[cnt] = 1;
  }

  public int getm2(int cnt) {
    return this.m2flag[cnt];
  }

  public void resetk() {
    this.kflag[0] = 0;
    this.kflag[1] = 0;
  }

  public void setk(int cnt) {
    this.kflag[cnt]=1;
  }

  public int getk(int cnt) {
    return this.kflag[cnt];
  }

  public void resetscore() {
    this.score[0] = 0;
    this.score[1] = 0;
  }

  public void setscore(int cnt,int add) {
    this.score[cnt]=this.score[cnt]+add;
  }

  public int getscore(int cnt) {
    return this.score[cnt];
  }

  public void resetflag() {
    this.flag[0] = 0;
    this.flag[1] = 0;
  }

  public void setflag(int cnt) {
    this.flag[cnt] = 1;
  }

  public int getflag(int cnt) {
    return this.flag[cnt];
  }

}
