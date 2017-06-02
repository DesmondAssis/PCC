package com.desmond.repository;

import com.desmond.model.PccFriend;
import com.desmond.model.PccFriendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PccFriendMapper {
    int countByExample(PccFriendExample example);

    int deleteByExample(PccFriendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PccFriend record);

    int insertSelective(PccFriend record);

    List<PccFriend> selectByExample(PccFriendExample example);

    PccFriend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PccFriend record, @Param("example") PccFriendExample example);

    int updateByExample(@Param("record") PccFriend record, @Param("example") PccFriendExample example);

    int updateByPrimaryKeySelective(PccFriend record);

    int updateByPrimaryKey(PccFriend record);
}