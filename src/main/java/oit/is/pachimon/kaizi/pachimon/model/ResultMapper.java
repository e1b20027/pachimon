package oit.is.pachimon.kaizi.pachimon.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ResultMapper {
  @Select("SELECT p1result from result where p1type = #{p1type} and p2type = #{p2type}")
  String selectp1(String p1type, String p2type);

  @Select("SELECT p2result from result where p1type = #{p1type} and p2type = #{p2type}")
  String selectp2(String p1type, String p2type);
}
