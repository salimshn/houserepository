package com.housemanagement.house.management.demo.error;

import com.housemanagement.house.management.demo.entity.ErrorMessage;

public abstract class HouseException extends Exception{

    public HouseException() {
        super();
    }

    public HouseException(String message) {
        super(message);
    }

    public HouseException(String message, Throwable cause) {
        super(message, cause);
    }

    public HouseException(Throwable cause) {
        super(cause);
    }

    protected HouseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public abstract ErrorMessage getErrorMessage();
}
