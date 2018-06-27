package com.demo;

import com.demo.dao.QuestionDAO;
import com.demo.dao.UserDAO;
import com.demo.model.Question;
import com.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InitDatabaseTests {

    @Autowired
    QuestionDAO questionDAO;

    @Autowired
    UserDAO userDAO;

    @Test
    public void contextLoads(){
        for(int i = 0; i<11; i++){
            User user = new User();
            user.setName(String.format("user%d", i));
            Random random = new Random();
            user.setHeadUrl("");
            user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
            user.setPassword("newpassword");
            user.setSalt("");
            userDAO.addUser(user);
            Question question = new Question();
            question.setCommentCount(i);;
            question.setTitle(String.format("TITLE%d", i));
            question.setUserId(i + 1);
            question.setContent(String.format("balabalabala%d", i));
            Date date = new Date();
            date.setTime(date.getTime() + i*1000);
            question.setCreatedDate(date);
            questionDAO.addQuestion(question);
        }
        //System.out.print(questionDAO.selectLatestQuestions(0,0,10));
        //System.out.print(String.format("111111111111111111111111111%s",userDAO.selectById(1)));
        //Question question = new Question();
        //question.setUserId(12);
        //System.out.print(String.format("11111111111111111111111  %d",question.getUserId()));
    }

}
