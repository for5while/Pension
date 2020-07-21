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
	public Integer getRoomStatus(String date, int roomNum) {
		HashMap<String, Object> param = new HashMap<>();
		
		param.put("date", date);
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

	@Override
	public Integer getNight(String room) {
		return sqlSession.selectOne(nameSpace + ".getNight", room);
	}

	@Override
	public List<ReserveVO> getPeoples(String room) {
		return sqlSession.selectList(nameSpace + ".getPeoples", room);
	}

	@Override
	public List<Object> getOptions(String room) {
		return sqlSession.selectList(nameSpace + ".getOptions", room);
	}

	@Override
	public String getOptionName(int optionNum) {
		return sqlSession.selectOne(nameSpace + ".getOptionName", optionNum);
	}

	@Override
	public int getRoomDefaultPrice(String room) {
		return sqlSession.selectOne(nameSpace + ".getRoomDefaultPrice", room);
	}

	@Override
	public int getRoomFriPrice(String room) {
		return sqlSession.selectOne(nameSpace + ".getRoomFriPrice", room);
	}

	@Override
	public int getRoomSatPrice(String room) {
		return sqlSession.selectOne(nameSpace + ".getRoomSatPrice", room);
	}

	@Override
	public Integer getRoomMidSeasonPrice(String date) {
		return sqlSession.selectOne(nameSpace + ".getRoomMidSeasonPrice", date);
	}

	@Override
	public Integer getRoomBusiestSeasonPrice(String date) {
		return sqlSession.selectOne(nameSpace + ".getRoomBusiestSeasonPrice", date);
	}

	@Override
	public int getRoomMidSeasonPriceAdd(String room) {
		return sqlSession.selectOne(nameSpace + ".getRoomMidSeasonPriceAdd", room);
	}

	@Override
	public int getRoomBusiestSeasonPriceAdd(String room) {
		return sqlSession.selectOne(nameSpace + ".getRoomBusiestSeasonPriceAdd", room);
	}

	@Override
	public Integer getOptionPrice(int optionNum) {
		return sqlSession.selectOne(nameSpace + ".getOptionPrice", optionNum);
	}

	@Override
	public void insertCustomer(String name, String phone) {
		HashMap<String, String> param = new HashMap<>();
		
		param.put("name", name);
		param.put("phone", phone);
		
		sqlSession.insert(nameSpace + ".insertCustomer", param);
	}

	@Override
	public void insertReserve(ReserveVO reserveVO) {
		sqlSession.insert(nameSpace + ".insertReserve", reserveVO);
	}

	@Override
	public void insertReserveStatus(ReserveVO reserveVO) {
		System.out.println(reserveVO.getCheckInDate());
		sqlSession.insert(nameSpace + ".insertReserveStatus", reserveVO);
	}
}
