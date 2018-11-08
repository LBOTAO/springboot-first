package com.java56.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.java56.dao.BPurChaseDao;
import com.java56.entity.BPurChase;
import com.java56.service.BPurChaseService;

@Service("bPurChaseService")
public class BPurChaseServiceImpl implements BPurChaseService {
	@Resource
	private BPurChaseDao bPurChaseDao;
	public List<BPurChase> findAll(BPurChase bPurChase) {
			 return bPurChaseDao.findAll(bPurChase);
	}
	public void deleteBPurChase(String id) {
		 bPurChaseDao.deleteBPurChase(id);
	}
	public Boolean addBPurChase(BPurChase bPurChase) {
		return bPurChaseDao.addBPurChase(bPurChase);
	}
	@Override
	public Boolean updateBPurChase(BPurChase bPurChase) {
		return bPurChaseDao.updateBPurChase(bPurChase);
	}
	@Override
	public BPurChase findBPurChase(String id) {
		return bPurChaseDao.findBPurChase(id);
	}
}
