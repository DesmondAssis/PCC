package com.desmond.vo.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by presleyli on 2017/6/9.
 */
public class JLikeListResult implements Serializable{
    private long oid;

    @JsonProperty("like_list")
    private List<JUser> likeList = new ArrayList<>();

    @JsonProperty("next_cursor")
    private long nextCursor;

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public List<JUser> getLikeList() {
        return likeList;
    }

    public void setLikeList(List<JUser> likeList) {
        this.likeList = likeList;
    }

    public long getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(long nextCursor) {
        this.nextCursor = nextCursor;
    }
}
