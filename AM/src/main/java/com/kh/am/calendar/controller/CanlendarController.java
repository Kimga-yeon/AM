package com.kh.am.calendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kh.am.calendar.model.service.CalendarService;
import com.kh.am.calendar.model.vo.Calendar;
import com.kh.am.member.model.vo.Member;

@SessionAttributes({"loginMember"})
@Controller
@RequestMapping("/calendar/*")
public class CanlendarController {

	@Autowired
	private CalendarService calendarService;
	
	// 알바생, 파트타임 목록 가져오기
	// 근무 관리 페이지 이동
	@RequestMapping("workList")
	public String workList(Model model) {
		
		Member loginMember = (Member)model.getAttribute("loginMember");
		
		// 사장님 회원번호
		int memberNo = loginMember.getMemberNo();
		
		// 가게번호 얻어오기
		int storeNo = calendarService.selectStoreNo(memberNo);
		
		System.out.println("조회" + storeNo);
		
		// 알바생 목록 조회
		
		// 기다려~vo만들고 올게!~
		
		
		// 파트타임 목록 조회
		
		
		
		
		return "calendar/workList";
	}
	// 고정스케쥴 관리 페이지 이동
	@RequestMapping("pixSchedule")
	public String pixSchedule() {
		return "calendar/pixSchedule";
	}
	// 파트타임 관리 페이지 이동
	@RequestMapping("partTime")
	public String partTime() {
		return "calendar/partTime";
	}
	
	// 사장님 캘린더 조회
	@ResponseBody
	@RequestMapping("master/calendarView")
	public String calendarView(Model model) {
		
		Member loginMember = (Member)model.getAttribute("loginMember");
		
		System.out.println(loginMember.getMemberNo() + "/" + loginMember.getMemberGrade());
		
		int memberNo = loginMember.getMemberNo();
		
		//스케쥴 정보를 List<vo> 에 넣어서 가져옴
		List<Calendar> list = calendarService.selectList(memberNo);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		return gson.toJson(list);
		
	}
	
	// 알바생 캘린더 조회
	@ResponseBody
	@RequestMapping("staff/calendarView")
	public String calendarView2(Model model) {
		
		Member loginMember = (Member)model.getAttribute("loginMember");
		
		System.out.println(loginMember.getMemberNo() + "/" + loginMember.getMemberGrade());
		
		int memberNo = loginMember.getMemberNo();
		
		//스케쥴 정보를 List<vo> 에 넣어서 가져옴
		List<Calendar> list = calendarService.selectListStaff(memberNo);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		return gson.toJson(list);
		
	}
	
	
	// 스케쥴 등록
	@RequestMapping("insertCalendar")
	public String insertCalendar() {
		
		return "calendar/workList";
	}
	
}