package com.bolion.tower.service;

import java.util.List;
import java.util.Map;

import com.bolion.common.service.ScoreService;
import com.bolion.tower.bean.TowerBaseInfo;
import com.bolion.tower.bean.TowerIndex;
import com.bolion.tower.bean.TowerInfo;
import com.bolion.tower.bean.TowerList;
import com.bolion.tower.bean.TowerPage;

public interface TowerService extends ScoreService {

public TowerList getTowers(TowerPage towerPage);
	
	public TowerInfo getTowerInfo(Map map);
	
	public int updateTowerFavourite(int useatrid,int towerid,int state);
	
	public TowerBaseInfo getTowerBaseInfo(int towerid);
	
	public int updateTowerState(int towerid,int state);
	
	List<TowerIndex> searchbsTowers(Map searchMap);
	
}
