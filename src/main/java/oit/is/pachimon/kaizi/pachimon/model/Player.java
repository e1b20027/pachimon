package oit.is.pachimon.kaizi.pachimon.model;

import java.util.ArrayList;
import java.util.concurrent.Flow.Publisher;

import org.springframework.stereotype.Component;

@Component
public class Player {
  int winflag = 0;
  int loseflag = 0;
  int evenflag = 0;
  int[] hp = new int[2];

  public void resetw() {
    this.winflag = 0;
  }

  public void setw() {
    this.winflag++;
  }

  public int getw() {
    return this.winflag;
  }

  public void resetl() {
    this.loseflag = 0;
  }

  public void setl() {
    this.loseflag++;
  }

  public int getl() {
    return this.loseflag;
  }

  public void resete() {
    this.evenflag = 0;
  }

  public void sete() {
    this.evenflag++;
  }

  public int gete() {
    return this.evenflag;
  }
}
