package com.desmond.service;

import com.desmond.model.PccArticleUserRef;
import com.desmond.model.PccArticleUserRefExample;
import com.desmond.model.PccUser;
import com.desmond.model.PccUserExample;
import com.desmond.repository.PccArticleUserRefMapper;
import com.desmond.repository.PccUserMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Li.Xiaochuan on 17/6/1.
 */
@Service
public class PccArticleUserRefService {

    @Autowired
    private PccArticleUserRefMapper pccArticleUserRefMapper;

    public int add(PccArticleUserRef ref) {
        int result = 0;
        try {
            result = pccArticleUserRefMapper.insertSelective(ref);
        } catch (Exception e) {
            // do nothing
        }

        return result;
    }

    public boolean isLiked(Long articleId, Long userId) {
        PccArticleUserRefExample ex = new PccArticleUserRefExample();

        ex.createCriteria().andArticleIdEqualTo(articleId)
                .andUserIdEqualTo(userId);

        List<PccArticleUserRef> pccArticleUserRefList = pccArticleUserRefMapper.selectByExample(ex);

        return CollectionUtils.isNotEmpty(pccArticleUserRefList);
    }

    public int countByArticleId(Long articleId) {
        PccArticleUserRefExample ex = new PccArticleUserRefExample();
        ex.createCriteria().andArticleIdEqualTo(articleId);

        return pccArticleUserRefMapper.countByExample(ex);
    }
}
