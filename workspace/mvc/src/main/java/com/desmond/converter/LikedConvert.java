package com.desmond.converter;

import com.desmond.model.PccUser;
import com.desmond.vo.json.JLikeListResult;
import com.desmond.vo.json.JLikeResult;
import com.desmond.vo.json.JUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by presleyli on 2017/6/12.
 */
@Component
public class LikedConvert {

    public JLikeResult convertToLikeResult(long articleId, long userId, List<PccUser> pccUserList) {
        JLikeResult jLikeResult = new JLikeResult();
        jLikeResult.setOid(articleId);
        jLikeResult.setUid(userId);

        for(PccUser user : pccUserList) {
            jLikeResult
                    .getjUserList()
                    .add(transformToUser(user));
        }

        return jLikeResult;
    }

    public JLikeListResult convertToListResult(long articleId, long nextCursor, List<PccUser> pccUserList) {
        JLikeListResult jLikeListResult = new JLikeListResult();
        jLikeListResult.setOid(articleId);
        jLikeListResult.setNextCursor(nextCursor);

        if(pccUserList != null) {
            for(PccUser user : pccUserList) {
                jLikeListResult
                        .getLikeList()
                        .add(transformToUser(user));
            }
        }

        return jLikeListResult;
    }

    private JUser transformToUser(PccUser user) {
        return new JUser(user.getId(), user.getName());
    }
}
