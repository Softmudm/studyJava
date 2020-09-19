package com.sz.ccms.dao;

import com.sz.ccms.entity.Manager;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ManagerDao extends Mapper<Manager> {
}
