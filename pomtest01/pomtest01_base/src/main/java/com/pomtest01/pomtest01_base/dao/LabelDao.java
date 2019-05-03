package com.pomtest01.pomtest01_base.dao;

import com.pomtest01.pomtest01_base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 标签数据访问接口
 * */
public interface LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {

}
