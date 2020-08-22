package com.sz.wx.dao;

import com.sz.wx.model.ScoreDetail;
import com.sz.wx.model.ScoreDetailExample;
import java.util.List;

import com.sz.wx.model.ScoreDetailItems;
import org.apache.ibatis.annotations.Param;

public interface ScoreDetailMapper {
    long countByExample(ScoreDetailExample example);

    int deleteByExample(ScoreDetailExample example);

    int deleteByPrimaryKey(Integer detailid);

    int insertList(List<ScoreDetail> list);

    int insert(ScoreDetail record);

    int insertSelective(ScoreDetail record);
    //查询
    List<ScoreDetailItems> getDetailList(Integer scoreId);

    List<ScoreDetail> selectByExample(ScoreDetailExample example);

    ScoreDetail selectByPrimaryKey(Integer detailid);

    int updateByExampleSelective(@Param("record") ScoreDetail record, @Param("example") ScoreDetailExample example);

    int updateByExample(@Param("record") ScoreDetail record, @Param("example") ScoreDetailExample example);

    int updateByPrimaryKeySelective(ScoreDetail record);

    int updateByPrimaryKey(ScoreDetail record);
}