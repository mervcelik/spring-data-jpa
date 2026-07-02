package com.example.handler;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.exception.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private List<String> addMapValue(List<String> list, String newValue) {
		list.add(newValue);
		return list;

	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex, WebRequest request) {
		Map<String, List<String>> errorsMap = new HashMap<>();

		for (ObjectError objError : ex.getBindingResult().getAllErrors()) {
			String fieldName = ((FieldError) objError).getField();
			if (errorsMap.containsKey(fieldName)) {
				errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), fieldName));
			} else {
				errorsMap.put(fieldName, addMapValue(new ArrayList<>(), objError.getDefaultMessage()));
			}
		}

		return ResponseEntity.badRequest().body(createApiError(errorsMap,request));

	}

	@ExceptionHandler(value = { BaseException.class })
	public ResponseEntity<ApiError<String>> handleBaseException(BaseException exception, WebRequest request) {
		return ResponseEntity.badRequest().body(createApiError(exception.getMessage(),request));
	}

	private String getHostname() {
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			System.out.println("hata oluştu " + e.getMessage());

		}

		return null;

	}

	private <T> ApiError<T> createApiError(T message, WebRequest request) {
		ApiError<T> apiError = new ApiError<T>();
		apiError.setStatus(HttpStatus.BAD_REQUEST.value());

		Exception<T> exception = new Exception<>();
		exception.setCreateTime(new Date());
		exception.setHostName(getHostname());
		exception.setPath(request.getDescription(false));
		exception.setMessage(message);

		apiError.setErrors(exception);
		return apiError;

	}
}
