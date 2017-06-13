package com.desmond.controller;

import com.desmond.converter.LikedConvert;
import com.desmond.model.PccArticleUserRef;
import com.desmond.model.PccUser;
import com.desmond.service.PccArticleUserRefService;
import com.desmond.service.PccUserService;
import com.desmond.service.UserService;
import com.desmond.util.MediaType;
import com.desmond.util.PaginationUtil;
import com.desmond.vo.json.*;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by presleyli on 2017/6/9.
 */

@RequestMapping("/server_ip/pcc")
@RestController
public class ArticleControlloer {
    @Autowired
    private PccArticleUserRefService pccArticleUserRefService;

    @Autowired
    private PccUserService pccUserService;

    @Autowired
    private UserService userService;

    @Autowired
    private LikedConvert likedConvert;

    @RequestMapping(params = {"action=like"}, produces = MediaType.APPLICATION_JSON)
    public Object dolike(@RequestParam(value = "oid", required = true) long oid, @RequestParam(value = "uid", required = true) long uid) {
        PccArticleUserRef ref = new PccArticleUserRef();
        ref.setArticleId(oid);
        ref.setUserId(uid);

        int addedCount = pccArticleUserRefService.add(ref);

        if(addedCount > 0) {
            List<PccArticleUserRef> userRefList =
                    pccArticleUserRefService.findByArtcileId(oid, 0 , 20);
            List<Long> userIdList = userRefList.stream()
                    .mapToLong(PccArticleUserRef::getUserId)
                     .boxed()
                    .collect(Collectors.toList());
            List<PccUser> pccUserList = pccUserService.findByIds(userIdList);

            return likedConvert.convertToLikeResult(oid, uid, pccUserList);
        } else {
            return new JErrorResult("501", "article already been liked.");
        }
    }

    @RequestMapping(params = "action=is_like", produces = MediaType.APPLICATION_JSON)
    public JIsLikeResult isLike(@RequestParam(value = "oid", required = true) long oid, @RequestParam(value = "uid", required = true) long uid) {
        boolean isLiked = pccArticleUserRefService.isLiked(oid, uid);

        return new JIsLikeResult(oid, uid, isLiked ? 1 : 0);
    }

    @RequestMapping(params = "action=count", produces = MediaType.APPLICATION_JSON)
    public JCountResult getCountResult(@RequestParam(value = "oid", required = true) long oid, @RequestParam(value = "uid", required = false) long uid) {
        long cnt = pccArticleUserRefService.countByArticleId(oid);

        return new JCountResult(oid, cnt);
    }

    @RequestMapping(params = "action=list", produces = MediaType.APPLICATION_JSON)
    public JLikeListResult getLikeList(@RequestParam(value = "oid", required = true) long oid,
                                       @RequestParam(value = "uid", required = true) long uid,
                                       @RequestParam(value = "cursor", required = true) long cursor,
                                       @RequestParam(value = "page_size", required = true) int pageSize,
                                       @RequestParam(value = "is_friend", required = true) int isFriend) {

        long nextCursor = 0;
        List<PccUser> pccUserList = new ArrayList<>();
        List<PccArticleUserRef> pccArticleUserRefList = null;

        if(1 == isFriend) {
            pccArticleUserRefList
                    = pccArticleUserRefService.findByArtcileIdByFriend(oid, uid, cursor, pageSize);
        } else {
           pccArticleUserRefList
                    = pccArticleUserRefService.findByArtcileId(oid, cursor, pageSize);
        }

        long actSize = CollectionUtils.isNotEmpty(pccArticleUserRefList) ? Math.min(pccArticleUserRefList.size(), pageSize) : 0;
        pccUserList = pccUserService.findByIds(
                Optional.ofNullable(pccArticleUserRefList).orElse(new ArrayList<>())
                        .stream()
                        .mapToLong(PccArticleUserRef::getUserId)
                        .boxed()
                        .collect(Collectors.toList())
        );

        nextCursor = PaginationUtil.getOffset(cursor, actSize);
        return likedConvert.convertToListResult(oid, nextCursor, pccUserList);
    }
}
