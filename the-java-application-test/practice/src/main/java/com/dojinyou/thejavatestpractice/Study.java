package com.dojinyou.thejavatestpractice;

public class Study {
    private StudyStatus status;
    private int numOfMaximumMembers;

    @Override
    public String toString() {
        return "Study{" +
                "numOfMaximumMembers=" + numOfMaximumMembers +
                ", name='" + name + '\'' +
                '}';
    }

    private String name;

    public Study(int numOfMaximumMembers, String name) {
        this.numOfMaximumMembers = numOfMaximumMembers;
        this.name = name;
    }


    public Study(int numOfMaximumMembers) {
        if(numOfMaximumMembers <= 0) {
            throw new IllegalArgumentException("number of maxnimum member is must bigger than 0");
        }
        this.numOfMaximumMembers = numOfMaximumMembers;
    }

    public StudyStatus getStatus() {
        return this.status;
    }

    public int getNumOfMaximumMembers() {
        return this.numOfMaximumMembers;
    }

    public String getName() {
        return name;
    }
}
