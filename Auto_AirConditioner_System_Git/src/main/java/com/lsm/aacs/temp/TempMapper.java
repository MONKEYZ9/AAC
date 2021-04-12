package com.lsm.aacs.temp;

import java.util.List;

import com.lsm.aacs.member.Member;

public interface TempMapper {
	public abstract int regTempkNN(Temp t);
//	public abstract List<Temp> getTempNkNNJoin(Member m);
	public abstract List<Temp> getTempNkNNLogin(Member m);
	public abstract List<Temp> checkSerial(Temp t);
}
