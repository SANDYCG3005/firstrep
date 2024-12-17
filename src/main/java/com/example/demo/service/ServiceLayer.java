package com.example.demo.service;

import java.util.*;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.example.demo.Exception.QuestionIdNotFoundException;
import com.example.demo.Exception.QuestionsNotFoundException;
import com.example.demo.Exception.SurveyIdNotFoundException;
import com.example.demo.Model.Question;
import com.example.demo.Model.Survey;

@Service
public class ServiceLayer {
private static List<Survey> surveys= new ArrayList<>();
	
	static
	{
		
		Question question1 = new Question("Question1",
		        "Most Popular Cloud Platform Today", Arrays.asList(
		                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2",
		        "Fastest Growing Cloud Platform", Arrays.asList(
		                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3",
		        "Most Popular DevOps Tool", Arrays.asList(
		                "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");
		
		List<Question> lq=new ArrayList<>(Arrays.asList(question1,question2,question3  ));
		
		Survey survey1=new Survey("Survey1","Cloud","Devops",lq);
		
		surveys.add(survey1);
		
		List<Question> lqs=new ArrayList<>();
		
		Survey survey2=new Survey("Survey2","JavaSQL","Backend",lqs);
		
		surveys.add(survey2);
		
	}
	public Survey retrieveSpecficSurvey(String surveyId)
	{
		Predicate<Survey> predicate=s->s.getId().equalsIgnoreCase(surveyId);
		Optional<Survey> opt= surveys.stream().filter(predicate).findFirst();
		if(opt.isEmpty())
			throw new SurveyIdNotFoundException(surveyId + " not found");
		else
			return opt.get();

	}
	public List<Survey> retrieveAllSurveys()
	{
		return surveys;
		
	}
	public List<Question> retrieveAllQuestions(String surveyId)
	{
		List<Question> lq = new ArrayList<>();
		
		Survey s = retrieveSpecficSurvey(surveyId);	
		for(Survey s1:surveys)
		{
			if(s1.getId().equalsIgnoreCase(surveyId))
			{
				lq.addAll(s1.getQuestions());
			}
			if(lq.isEmpty())
			{
				throw new QuestionsNotFoundException("List of Questions in " + surveyId + " is Empty");
			}
		}
			return lq;
		}
		
		
	public Question retrieveSpecificQuestion(String surveyId,String quesid)
	{
		boolean check = false;
		Survey s1 = retrieveSpecficSurvey(surveyId);
		List<Question> lq = retrieveAllQuestions(surveyId);
			for(Question q:lq)
			{
				if(q.getId().equalsIgnoreCase(quesid))
				{
					check=true;
					return q;
				}
				if(check==false)
				{
					throw new QuestionIdNotFoundException(quesid + " Not found");
				}
			}
		return null;
	}
	public void addques(String surveyId,Question ques)
	{
		for(Survey s:surveys)
		{
			if(s.getId().equalsIgnoreCase(surveyId))
			{
				s.getQuestions().add(ques);
			}
		}
	}
	public void deleteques(String surveyid,String quesid)
	{
		List<Question> lq = retrieveAllQuestions(surveyid);
		lq.remove(retrieveSpecificQuestion(surveyid, quesid));
	}
	public void updatequest(String surveyid,String quesid,Question q)
	{
		List<Question> lq = retrieveAllQuestions(surveyid);
		lq.remove(retrieveSpecificQuestion(surveyid, quesid));
		lq.add(q);
	}

}
