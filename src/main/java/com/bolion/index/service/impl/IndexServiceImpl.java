package com.bolion.index.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolion.common.TowerConfig;
import com.bolion.common.bean.Province;
import com.bolion.common.mapper.AreaMapper;
import com.bolion.index.bean.Banner;
import com.bolion.index.bean.District;
import com.bolion.index.bean.IndexInfo;
import com.bolion.index.mapper.IndexMapper;
import com.bolion.index.service.IndexService;
import com.bolion.tower.bean.TowerIndex;
import com.bolion.tower.mapper.TowerMapper;

@Service
public class IndexServiceImpl implements IndexService{

	@Autowired
	private AreaMapper areaMapper;
	
	@Autowired
	private IndexMapper indexMapper;
	
	@Autowired
	private TowerMapper towerMapper;
	
	/**
	 * 获取所有的地区
	 */
	@Override
	public List<Province> getProvinces() {
		return areaMapper.getProvices();
	}

	@Override
	public void getIndexInfo(IndexInfo indexInfo) {
		//获取banners
		List<Banner> banners=indexMapper.getBanners();
		indexInfo.setBanners(banners);
		//获取推荐站址
		Map map=new HashMap();
		int cityid= indexInfo.getCityid();
		System.out.println(cityid);
		if(cityid>0&&cityid/100==0)
			cityid=cityid*100+1;
		map.put("cityid",cityid);
		System.out.println(cityid);
		
		
		map.put("showcount",TowerConfig.index_show_tower_count);
		List<TowerIndex> offers=towerMapper.getIndexOfferTowers(map);
		indexInfo.setOffers(offers);
	}

	@Override
	public List<District> getDistricts(int cityid) {
		// TODO Auto-generated method stub
		return indexMapper.getDistricts(cityid);
	}

	@Override
	public List<TowerIndex> searchTowers(Map searchMap) {
		// TODO Auto-generated method stub
		return towerMapper.searchTowers(searchMap);
	}
	
}
