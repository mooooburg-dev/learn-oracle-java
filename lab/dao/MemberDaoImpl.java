package com.springdemoweb.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

import com.springdemoweb.mapper.MemberMapper;
import com.springdemoweb.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate;

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public void insertMember(Member member) {
			
//		sessionTemplate.insert(
//			"com.springdemoweb.mapper.MemberMapper.insertMember", member);
		
		memberMapper.insertMember(member);
		
	}
		
	@Override
	public Member selectMemberByIdAndPasswd(String id, String passwd) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("memberId", id);
		params.put("passwd", passwd);
		
//		Member member = sessionTemplate.selectOne(
//			"com.springdemoweb.mapper.MemberMapper.selectMemberByIdAndPasswd",
//			params);
		
		Member member = memberMapper.selectMemberByIdAndPasswd(params);
		
		return member;
		
	}
	
}




















