package com.sushank.loginregistermaterial.model;

/**
 * Created by sushank_dahiwadkar on 2/3/2016.
 */
public class TestDetail {
    int testId;
    int userId;
    String testName;
    String subject;
    int totalQuestions;
    boolean activated;


    public TestDetail() {
        super();
        // TODO Auto-generated constructor stub
    }


    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "TestDetail [testId=" + testId + ", userId=" + userId + ", testName=" + testName + ", subject="
                + subject + ", totalQuestions=" + totalQuestions + ", activated=" + activated + "]";
    }

}
