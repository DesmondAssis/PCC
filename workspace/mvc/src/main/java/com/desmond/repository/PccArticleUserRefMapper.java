package com.desmond.repository;

import com.desmond.model.PccArticleUserRef;
import com.desmond.model.PccArticleUserRefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PccArticleUserRefMapper {
    int countByExample(PccArticleUserRefExample example);

    int deleteByExample(PccArticleUserRefExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PccArticleUserRef record);

    int insertSelective(PccArticleUserRef record);

    List<PccArticleUserRef> selectByExample(PccArticleUserRefExample example);

    PccArticleUserRef selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PccArticleUserRef record, @Param("example") PccArticleUserRefExample example);

    int updateByExample(@Param("record") PccArticleUserRef record, @Param("example") PccArticleUserRefExample example);

    int updateByPrimaryKeySelective(PccArticleUserRef record);

    int updateByPrimaryKey(PccArticleUserRef record);
}