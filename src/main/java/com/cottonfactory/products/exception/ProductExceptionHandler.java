package com.cottonfactory.products.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cottonfactory.products.responses.BaseResponse;
import com.cottonfactory.products.responses.ProductError;

@RestControllerAdvice
public class ProductExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public BaseResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		BaseResponse response = new BaseResponse();
		exception.getBindingResult().getAllErrors()
				.forEach(e -> response.addProductError((new ProductError(e.getDefaultMessage()))));
		return response;
	}
}
