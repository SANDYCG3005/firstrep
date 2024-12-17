package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ErrorResponse;
import com.example.demo.Exception.QuestionIdNotFoundException;
import com.example.demo.Exception.QuestionsNotFoundException;
import com.example.demo.Exception.SurveyIdNotFoundException;
import com.example.demo.Model.Question;
import com.example.demo.Model.Survey;
import com.example.demo.service.ServiceLayer;

@RestController
public class Controller {
	
	@Autowired
	private ServiceLayer service;
	
	@RequestMapping("/surveys/{survid}")
	public Survey retrieveSurvey(@PathVariable String survid)
	{
		return service.retrieveSpecficSurvey(survid);
	}
	@RequestMapping("/surveys")
	public List<Survey> retrieveAllSurvey()
	{
		
		return service.retrieveAllSurveys();
	}
	@RequestMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveAllQuestions(@PathVariable String surveyId)
	{
		return service.retrieveAllQuestions(surveyId);
	}
	@RequestMapping("/surveys/questions/{surveyId}-{questionId}")
	public Question retrievespecificQuestion(@PathVariable String surveyId,@PathVariable String questionId)
	{
		return service.retrieveSpecificQuestion(surveyId,questionId);
	}
	@RequestMapping(value="/surveys/{id}",method = RequestMethod.POST)
	public void addQues(@PathVariable String id,@RequestBody Question q)
	{
		service.addques(id, q);
	}
	@RequestMapping(value="/surveys/{surveyid}/questions-{questionId}",method=RequestMethod.DELETE)
	public ResponseEntity<Object> deletequest(@PathVariable String surveyid,@PathVariable String questionId)
	{
		service.deleteques(surveyid, questionId);
		return ResponseEntity.ok().build();
	}
	@RequestMapping(value="/surveys/{surveyid}/questions-{questionId}",method = RequestMethod.PUT)
	public ResponseEntity<Object> updateques(@PathVariable String surveyid,@PathVariable String questionId,@RequestBody Question q)
	{
		service.updatequest(surveyid, questionId, q);
		return ResponseEntity.ok().build();
	}
	
//	@ExceptionHandler
//	public ResponseEntity<ErrorResponse> handleException(SurveyIdNotFoundException exe)
//	{
//		//create ErrorResponse obj
//		ErrorResponse err= new ErrorResponse();
//		err.setTimestamp(LocalDateTime.now());
//		err.setHttp( HttpStatus.NOT_FOUND);
//		err.setMessage( exe.getMessage());
//		return new ResponseEntity<ErrorResponse>(err,HttpStatus.NOT_FOUND);
//	}
//	@ExceptionHandler
//	public ResponseEntity<ErrorResponse> handleException(QuestionIdNotFoundException qexe)
//	{
//		//create ErrorResponse obj
//		ErrorResponse err= new ErrorResponse();
//		err.setTimestamp(LocalDateTime.now());
//		err.setHttp( HttpStatus.NOT_FOUND);
//		err.setMessage(qexe.getMessage());
//		return new ResponseEntity<ErrorResponse>(err,HttpStatus.NOT_FOUND);
//	}
//	@ExceptionHandler
//	public ResponseEntity<ErrorResponse> handleException(QuestionsNotFoundException qsexe)
//	{
//		//create ErrorResponse obj
//		ErrorResponse err= new ErrorResponse();
//		err.setTimestamp(LocalDateTime.now());
//		err.setHttp( HttpStatus.NOT_FOUND);
//		err.setMessage(qsexe.getMessage());
//		return new ResponseEntity<ErrorResponse>(err,HttpStatus.NOT_FOUND);
//	}
	

}
