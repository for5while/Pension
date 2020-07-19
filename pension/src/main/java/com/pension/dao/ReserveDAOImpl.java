package com.pension.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pension.vo.ReserveVO;

@Repository
public class ReserveDAOImpl implements ReserveDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static String nameSpace = "com.pension.sqlmap.mappers.reserveMapper";

	@Override
	public List<ReserveVO> getRoomList() {
		return sqlSession.selectList(nameSpace + ".getRoomList");
	}

	@Override
	public Integer getRoomStatus(int day, int roomNum) {
		HashMap<String, Integer> param = new HashMap<>();
		
		param.put("day", day);
		param.put("roomNum", roomNum);
		
		return sqlSession.selectOne(nameSpace + ".getRoomStatus", param);
	}

	@Override
	public Integer getRoomIsPayment(int roomNum) {
		return sqlSession.selectOne(nameSpace + ".getRoomIsPayment", roomNum);
	}

	@Override
	public String getRoomName(int roomNum) {
		return sqlSession.selectOne(nameSpace + ".getRoomName", roomNum);
	}

	@Override
	public String isMidSeason(String date) {
		return sqlSession.selectOne(nameSpace + ".isMidSeason", date);
	}

	@Override
	public String isBusiestSeason(String date) {
		return sqlSession.selectOne(nameSpace + ".isBusiestSeason", date);
	}
}
