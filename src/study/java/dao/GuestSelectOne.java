package study.java.dao;

import org.apache.ibatis.session.SqlSession;

import study.java.mybatis.MyBatisConnectionFactory;
import study.java.vo.Guest;

public class GuestSelectOne {

	public static void main(String[] args) {
		
		// 1. DB 접속
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		
		// 2. 조회할 데이터
		Guest input = new Guest();
		input.setLoginID("latte");
		System.out.println("input : " + input.toString());
		
		// 3. 데이터 조회
		Guest output = sqlSession.selectOne("GuestMapper.selectItem", input);
		
		// 4. 결과 확인
		if(output == null) {
			System.out.println("조회 결과 없음");
		} else {
			System.out.println(output.toString());
		}
		
		sqlSession.close();

	}

}
