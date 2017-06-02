package com.desmond.repository;

import com.desmond.model.PccUser;
import com.desmond.model.PccUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PccUserMapper {
    int countByExample(PccUserExample example);

    int deleteByExample(PccUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PccUser record);

    int insertSelective(PccUser record);

    List<PccUser> selectByExample(PccUserExample example);

    PccUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PccUser record, @Param("example") PccUserExample example);

    int updateByExample(@Param("record") PccUser record, @Param("example") PccUserExample example);

    int updateByPrimaryKeySelective(PccUser record);

    int updateByPrimaryKey(PccUser record);

    List<PccUser> selectByLike(@Param("articleId") Long articleId);
}