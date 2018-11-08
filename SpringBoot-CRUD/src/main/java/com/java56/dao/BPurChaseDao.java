package com.java56.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java56.entity.BPurChase;
@Repository
public interface BPurChaseDao {
	public List<BPurChase> findAll(BPurChase bPurChase);
	public void deleteBPurChase(String id);
	public Boolean addBPurChase(BPurChase bPurChase);
	public Boolean updateBPurChase(BPurChase bPurChase);
	public BPurChase findBPurChase(String id);
}
