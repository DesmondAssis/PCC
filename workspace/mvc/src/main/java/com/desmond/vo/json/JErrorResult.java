package com.desmond.vo.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by presleyli on 2017/6/9.
 */
public class JErrorResult implements Serializable {
    @JsonProperty("error_code")
    private String errorCode = "";

    @JsonProperty("error_message")
    private String errorMessage = "";

    public JErrorResult() {
    }

    public JErrorResult(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
