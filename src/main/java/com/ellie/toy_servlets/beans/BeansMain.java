package com.ellie.toy_servlets.beans;

public class BeansMain {
    public static void main(String[] args) {
        DatasInfor datasInfor = new DatasInfor();
        MemberBean memberBean = datasInfor.getDataWithMemberBean();

        System.out.println(memberBean.getFirstQuesion() + "\n"
        + memberBean.getSecondQuestion() + "\n"
        + memberBean.getThirdQustion() + "\n"
        + memberBean.getFourthQustion() + "\n"
        + memberBean.getFifthQustion());    }
}