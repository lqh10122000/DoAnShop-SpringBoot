package com.huyle.shop.Exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BadRequestExceptionAlert extends AbstractThrowableProblem{

    private final String message;

    private final List<ErrorResponse>
}
