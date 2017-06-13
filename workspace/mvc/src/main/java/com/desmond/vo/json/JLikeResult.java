package com.desmond.vo.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Like接口result
 * Created by presleyli on 2017/6/9.
 */
public class JLikeResult implements Serializable{
    private long oid;
    private long uid;

    @JsonProperty("like_list")
    private List<JUser> jUserList = new ArrayList<>();

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

    public List<JUser> getjUserList() {
        return jUserList;
    }

    public void setjUserList(List<JUser> jUserList) {
        this.jUserList = jUserList;
    }
}
