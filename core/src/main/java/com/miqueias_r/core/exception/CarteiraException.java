package com.miqueias_r.core.exception;

import com.miqueias_r.core.exception.enums.message.CarteiraMessageEnum;

public class CarteiraException extends RuntimeException {
    private final int statusCode;

    public CarteiraException(CarteiraMessageEnum carteiraMessageEnum) {
        super(carteiraMessageEnum.getMessage());
        this.statusCode = carteiraMessageEnum.getStatusCode();
    }

    public int getStatusCode() {
        return statusCode;
    }
}
