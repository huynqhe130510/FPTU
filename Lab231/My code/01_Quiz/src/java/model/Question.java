/*
* Question.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package model;
import java.sql.Date;

/**
 * Question.<br>
 *
 * <pre>
 * Class mô tả đối tượng Question
 * Trong class này sẽ tiến hành các xử lí dưới đây
 *
 * . getId.
 * . setId.
 * . getQuestion.
 * . setQuestion.
 * . getO1.
 * . setO1.
 * . getO2.
 * . setO2.
 * . getO3.
 * . setO3.
 * . getO4.
 * . setO4.
 * . getAnswer.
 * . setAnswer.
 * . getCreatedDate.
 * . setCreatedDate.
 * . getTeacherId
 * . setTeacherId
 *
 * </pre>
 *
 * @author FU HuyNQHE130510
 * @version 1.0
 */
public class Question {

    /**
     * Store id.
     */
    private int id;
    /**
     * Store question.
     */
    private String question;
    /**
     * Store o1.
     */
    private String o1;
    /**
     * Store o2.
     */
    private String o2;
    /**
     * Store o3.
     */
    private String o3;
    /**
     * Store o4.
     */
    private String o4;
    /**
     * Store answer.
     */
    private String answer;
    /**
     * Store createdDate.
     */
    private Date createdDate;
    /**
     * Store teacherId.
     */
    private int teacherId;

    /**
     * get id <br>
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id.<br>
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get question <br>
     *
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Set question.<br>
     *
     * @param question the question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * get o1 <br>
     *
     * @return the o1
     */
    public String getO1() {
        return o1;
    }

    /**
     * Set o1.<br>
     *
     * @param o1 the o1
     */
    public void setO1(String o1) {
        this.o1 = o1;
    }

    /**
     * get o2 <br>
     *
     * @return the o2
     */
    public String getO2() {
        return o2;
    }

    /**
     * Set o2.<br>
     *
     * @param o2 the o2
     */
    public void setO2(String o2) {
        this.o2 = o2;
    }

    /**
     * get o3 <br>
     *
     * @return the o3
     */
    public String getO3() {
        return o3;
    }

    /**
     * Set o3.<br>
     *
     * @param o3 the o3
     */
    public void setO3(String o3) {
        this.o3 = o3;
    }

    /**
     * get o4 <br>
     *
     * @return the o4
     */
    public String getO4() {
        return o4;
    }

    /**
     * Set o4.<br>
     *
     * @param o4 the o4
     */
    public void setO4(String o4) {
        this.o4 = o4;
    }

    /**
     * get answer <br>
     *
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Set answer.<br>
     *
     * @param answer the answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * get createdDate <br>
     *
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Set createdDate.<br>
     *
     * @param createdDate the createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * get teacherId <br>
     *
     * @return the teacherId
     */
    public int getTeacherId() {
        return teacherId;
    }

    /**
     * Set teacherId.<br>
     *
     * @param teacherId the teacherId
     */
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

}
