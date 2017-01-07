package com.bolion.index.service;

import java.util.List;
import java.util.Map;

import com.bolion.common.bean.Province;
import com.bolion.index.bean.District;
import com.bolion.index.bean.IndexInfo;
import com.bolion.tower.bean.TowerIndex;

public interface IndexService {
	
	public List<Province> getProvinces();
	
	public void getIndexInfo(IndexInfo indexInfo);
	
	public List<District> getDistricts(int cityid);

	public List<TowerIndex> searchTowers(Map searchMap);
	
}
