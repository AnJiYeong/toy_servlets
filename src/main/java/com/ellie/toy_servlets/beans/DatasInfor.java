package com.ellie.toy_servlets.beans;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;

public class DatasInfor {
    public MemberBean getDataWithMemberBean() {
        MemberBean memberBean = new MemberBean();
        memberBean.setFirstQuesion("해당 매장을 방문시 매장은 청결 하였습니까?");
        memberBean.setSecondQuestion("주문시 직원은 고객님께 친절 하였습니까?");
        memberBean.setThirdQustion("주문하신 음료가 나오기까지 시간이 적당하였습니까?");
        memberBean.setFourthQustion("해당 매장을 다음에도 재방문 하실 의향이 있으십니까?");
        memberBean.setFifthQustion("직원이 제조한 음료에 대해 맛은 좋았습니까?");

        return memberBean;
    }

    public ArrayList<MemberBean> getDataListWithMemberBean() {
        ArrayList<MemberBean> membersList = new ArrayList<>();
        
        MemberBean memberBean02 = new MemberBean();
        memberBean02.setFifthAnswer("전혀 아니다");
        memberBean02.setSecondAnswer("아니다");
        memberBean02.setThirdAnswer("보통이다");
        memberBean02.setFourthAnswer("그렇다");
        memberBean02.setFifthAnswer("매우 그렇다");

        return membersList;
    }
}
