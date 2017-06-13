package com.desmond.service;

import com.desmond.model.PccUser;
import com.desmond.model.PccUserExample;
import com.desmond.model.User;
import com.desmond.repository.PccUserMapper;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Li.Xiaochuan on 17/6/1.
 */
@Service
public class PccUserService {

    @Autowired
    private PccUserMapper pccUserMapper;

    public List<PccUser> findByIds(List<Long> idList) {
        if(CollectionUtils.isEmpty(idList)) {
            return null;
        }

        PccUserExample ex = new PccUserExample();
        ex.createCriteria().andIdIn(idList);

        return pccUserMapper.selectByExample(ex);
    }
}
