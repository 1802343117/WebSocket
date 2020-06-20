package com.soft1851.devoted.exception;

import com.soft1851.devoted.common.ResultCode;

/**
 * @author 12559
 */
public class JwtException extends RuntimeException {

    protected ResultCode resultCode;

    public JwtException(String msg, ResultCode resultCode) {
        super(msg);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}