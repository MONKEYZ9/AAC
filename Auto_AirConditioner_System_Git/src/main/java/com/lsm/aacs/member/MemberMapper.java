package com.lsm.aacs.member;

import java.util.List;

public interface MemberMapper {
	public abstract int join(Member m);
	public abstract List<Member> checkLogin();
	public abstract List<Member> getMemberNkNNLogin(Member m);
	public abstract List<Member> getMemberByEmail(Member m);
	public abstract int updateSerialByEmail(Member m);
	public abstract int dropOutByEmail(Member m);
}
