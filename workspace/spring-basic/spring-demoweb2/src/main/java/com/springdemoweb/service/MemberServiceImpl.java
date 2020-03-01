package com.springdemoweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springdemoweb.common.Util;
import com.springdemoweb.dao.MemberDao;
import com.springdemoweb.vo.Member;

@Service("memberService") // == @Component("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	@Qualifier("memberDao")
	private MemberDao memberDao;

	@Override
	public void registerMember(Member member) {
		
		//String passwd = Util.getHashedString(member.getPasswd(), "SHA-256"); //패스워드 암호화 (복원불가능)
		String passwd = member.getPasswd();
		member.setPasswd(passwd);
		
		memberDao.insertMember(member);
	}

	@Override
	public Member findMemberByIdAndPasswd(String memberId, String passwd) {

		//passwd = Util.getHashedString(passwd, "SHA-256"); //암호화
		Member member = memberDao.selectMemberByIdAndPasswd(memberId, passwd);

		return member;
	}

}
