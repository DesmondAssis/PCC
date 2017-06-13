package com.desmond.vo.json;

import java.io.Serializable;

/**
 * count结果
 * Created by presleyli on 2017/6/9.
 */
public class JCountResult implements Serializable{
    private long oid;
    private long count;

    public JCountResult() {
    }

    public JCountResult(long oid, long count) {
        this.oid = oid;
        this.count = count;
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
