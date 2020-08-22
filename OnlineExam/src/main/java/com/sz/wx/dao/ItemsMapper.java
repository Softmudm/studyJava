package com.sz.wx.dao;

import com.sz.wx.model.Items;
import com.sz.wx.model.ItemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsMapper {
    long countByExample(ItemsExample example);

    int deleteByExample(ItemsExample example);

    int deleteByPrimaryKey(Integer eid);

    int insert(Items record);

    int insertSelective(Items record);

    List<Items> selectByExample(ItemsExample example);

    Items selectByPrimaryKey(Integer eid);

    int updateByExampleSelective(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKey(Items record);
}