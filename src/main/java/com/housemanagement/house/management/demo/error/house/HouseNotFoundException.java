package com.housemanagement.house.management.demo.error.house;

import com.housemanagement.house.management.demo.entity.ErrorMessage;
import com.housemanagement.house.management.demo.error.HouseException;
import org.springframework.http.HttpStatus;

public class HouseNotFoundException extends HouseException {

    public HouseNotFoundException() {
        super();
    }

    public HouseNotFoundException(String message) {
        super(message);
    }

    public HouseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public HouseNotFoundException(Throwable cause) {
        super(cause);
    }

    protected HouseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    @Override
    public ErrorMessage getErrorMessage() {

        return new ErrorMessage(HttpStatus.NOT_FOUND,this.getMessage());
    }
}
