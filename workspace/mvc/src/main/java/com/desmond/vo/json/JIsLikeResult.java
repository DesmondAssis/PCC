package com.desmond.vo.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * is like结果
 * Created by presleyli on 2017/6/9.
 */
public class JIsLikeResult implements Serializable{
    private long oid;
    private long uid;

    public JIsLikeResult() {
    }

    public JIsLikeResult(long oid, long uid, int isLike) {
        this.oid = oid;
        this.uid = uid;
        this.isLike = isLike;
    }

    @JsonProperty("is_like")
    private int isLike;

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public int getIsLike() {
        return isLike;
    }

    public void setIsLike(int isLike) {
        this.isLike = isLike;
    }
}
