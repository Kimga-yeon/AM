package com.kh.am.calendar.model.service;

import java.util.List;

import com.kh.am.calendar.model.vo.Calendar;
import com.kh.am.member.model.vo.Member;

public interface CalendarService{

	/** 사장님 전체 스케쥴 조회
	 * @param memberNo
	 * @return list
	 */
	List<Calendar> selectList(int memberNo);

	/** 알바생 스케쥴 조회
	 * @param memberNo
	 * @return list
	 */
	List<Calendar> selectListStaff(int memberNo);

	/** 사장님 가게번호 조회
	 * @param memberNo
	 * @return storeNo
	 */
	int selectStoreNo(int memberNo);

}