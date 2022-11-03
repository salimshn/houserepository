package com.housemanagement.house.management.demo.error.shareholder;

import com.housemanagement.house.management.demo.entity.ErrorMessage;
import com.housemanagement.house.management.demo.error.HouseException;
import org.springframework.http.HttpStatus;

public class AddressExistException extends HouseException {
    public AddressExistException() {
        super();
    }

    public AddressExistException(String message) {
        super(message);
    }

    public AddressExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressExistException(Throwable cause) {
        super(cause);
    }

    protected AddressExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public ErrorMessage getErrorMessage() {
        return new ErrorMessage(HttpStatus.BAD_REQUEST,this.getMessage());
    }
}
