package com.sushank.loginregistermaterial.model;

/**
 * Created by sushank_dahiwadkar on 3/10/2016.
 */
public class TestScore {

    int id, testId, userId, score, totalMarks;


    public TestScore() {
        super();
    }

    public TestScore(int id, int testId, int userId, int score, int totalMarks) {
        super();
        this.id = id;
        this.testId = testId;
        this.userId = userId;
        this.score = score;
        this.totalMarks = totalMarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    @Override
    public String toString() {
        return "TestScore [id=" + id + ", testId=" + testId + ", userId=" + userId + ", score=" + score
                + ", totalMarks=" + totalMarks + "]";
    }

}
