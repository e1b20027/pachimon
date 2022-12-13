package oit.is.pachimon.kaizi.pachimon.model;

public class Result {
  String p1type;
  String p2type;
  String p1result;
  String p2result;

  // Thymeleafでフィールドを扱うためにはgetter/setterが必ず必要
  // vscodeのソースコード右クリック->ソースアクションでsetter/getterを簡単に追加できる

  public String getp1type() {
    return this.p1type;
  }

  public void setp1type(String p1) {
    this.p1type = p1;
  }

  public String getp2type() {
    return this.p2type;
  }

  public void setp2type(String p2) {
    this.p2type = p2;
  }

  public String getp1result() {
    return this.p1result;
  }

  public void setp1result(String p1) {
    this.p1result = p1;
  }

  public String getp2result() {
    return this.p2result;
  }

  public void setp2result(String p2) {
    this.p2result = p2;
  }

}
