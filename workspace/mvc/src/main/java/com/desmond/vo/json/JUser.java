package com.desmond.vo.json;

import java.io.Serializable;

/**
 * Created by presleyli on 2017/6/9.
 */
public class JUser implements Serializable{
    private long id;
    private String name = "";

    public JUser() {
    }

    public JUser(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
