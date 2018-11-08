package com.java56.service;
import java.util.List;

import com.java56.entity.BPurChase;

public interface BPurChaseService {
	public List<BPurChase>  findAll(BPurChase bPurChase);
	public void deleteBPurChase(String id);
	public Boolean addBPurChase(BPurChase bPurChase);
	public Boolean updateBPurChase(BPurChase bPurChase);
	public BPurChase findBPurChase(String id);
}
