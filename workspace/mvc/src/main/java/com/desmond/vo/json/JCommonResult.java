package com.desmond.vo.json;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by presleyli on 2017/6/9.
 */
public class JCommonResult implements Serializable{
    private String status = "sucess";
    private Object result = new HashMap<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
