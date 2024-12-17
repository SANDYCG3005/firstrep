package com.example.demo.Exception;

public class QuestionsNotFoundException extends RuntimeException{
	public QuestionsNotFoundException(String msg)
	{
		super(msg);
	}

}
