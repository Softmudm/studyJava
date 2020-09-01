package com.sz.wx.dao;

import com.sz.wx.model.Score;
import com.sz.wx.model.ScoreExample;
import java.util.List;
import java.util.Map;

import com.sz.wx.model.ScorePaper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreMapper {
    long countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    int deleteByPrimaryKey(Integer scoreid);

    int insertReturnId(Score record);

    int insert(Score record);

    int insertSelective(Score record);
    //查询我的试卷
    List<ScorePaper> selectByPaperName(Map<String,Object> map);

    List<Score> selectByExample(ScoreExample example);

    Score selectByPrimaryKey(Integer scoreid);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
}