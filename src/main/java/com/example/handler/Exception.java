package com.example.handler;


import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exception<T> {

	private String hostName;
	private String path;
	private Date createTime;
	private  T message;
}
