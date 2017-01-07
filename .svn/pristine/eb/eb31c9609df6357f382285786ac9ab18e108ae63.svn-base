package com.bolion.money.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolion.money.bean.Bank;
import com.bolion.money.bean.Card;
import com.bolion.money.bean.MyMoney;
import com.bolion.money.bean.TxDoinfo;
import com.bolion.money.bean.TxRecord;
import com.bolion.money.bean.TxRecordTower;
import com.bolion.money.bean.TxSource;
import com.bolion.money.bean.UserTxRecordInfo;
import com.bolion.money.common.StrUtil;
import com.bolion.money.mapper.MoneyMapper;

@Service
public class MoneyServiceImpl implements MoneyService {

	@Autowired
	private MoneyMapper moneyMapper;

	@Override
	public MyMoney getweGetUserMoney(int userid) {
		// TODO Auto-generated method stub
		MyMoney myMoney = moneyMapper.getMyMoney(userid);
		if(myMoney==null){
			return null;
		}
		Card card = moneyMapper.getDefaultCard(userid);
		if (card == null) {
			myMoney.setBankmessage("暂无默认的银行卡");
		} else {
			myMoney.setBankid(card.getId());
			myMoney.setBankaccount(card.getBankaccount());
			myMoney.setBankcardid(card.getBankcardid());
			myMoney.setBankname(card.getBankname());
		}
		return myMoney;
	}

	@Override
	public List<Bank> getBanks() {
		// TODO Auto-generated method stub
		return moneyMapper.getBanks();
	}

	@Override
	public Card getCardInfo(int id) {
		// TODO Auto-generated method stub
		return moneyMapper.getCard(id);
	}

	@Override
	public List<Card> weGetBankList(int userid) {
		// TODO Auto-generated method stub
		return moneyMapper.getCards(userid);
	}

	@Override
	public int deleteBankCard(int id) {
		// TODO Auto-generated method stub
		return moneyMapper.deleteCard(id);
	}

	@Override
	@Transactional
	public int SetDefault(Map map) {
		// TODO Auto-generated method stub
		int count = moneyMapper.CancelDefault(map);
		if (count == 0)
			throw new RuntimeException();
		Card card = new Card();
		card.setId(Integer.valueOf(map.get("id").toString()));
		card.setUserid(Integer.valueOf(map.get("userid").toString()));
		card.setIsdefault(1);
		count = moneyMapper.updateCard(card);
		if (count == 0)
			throw new RuntimeException();
		return count;
	}

	@Override
	public int updateCard(Card card) {
		// TODO Auto-generated method stub
		int count = 0;
		if (card.getId() == 0) {
			count = moneyMapper.getCardNumber(card.getUserid());
			// 只有一张卡时设置默认
			if (count == 0) {
				card.setIsdefault(1);
			} else {
				card.setIsdefault(0);
			}
			count = moneyMapper.addCard(card);
		} else {
			count = moneyMapper.saveupdateCard(card);
		}
		return count;
	}

	@Override
	@Transactional
	public int txMoney(Map map) {
		// TODO Auto-generated method stub
		// 获取默认银行卡ID
		Card card = moneyMapper.getDefaultCard(Integer.valueOf(map.get("userid").toString()).intValue());
		if (card == null) {
			return -1;
		}
		// 获取提现编号
		String txid = map.get("txid").toString();
		// 更新用户可提现金额来源表
		int fee = moneyMapper.getReturnMoney(Integer.valueOf(map.get("userid").toString()).intValue());
		if (fee == 0)
			return 0;
		// 生成提现记录表
		UserTxRecordInfo txinfo = new UserTxRecordInfo();
		txinfo.setWxid("testest");
		txinfo.setUserid(Integer.valueOf(map.get("userid").toString()).intValue());
		txinfo.setTxid(txid);
		txinfo.setCardid(card.getId());
		txinfo.setFee(fee);
		int count = moneyMapper.insertUserTxRecord(txinfo);
		if (count == 0)
			return 0;
		map.put("id", txinfo.getId());
		count = moneyMapper.updateUserChargeTxid(map);
		if (count == 0)
			throw new RuntimeException();
		// 总金额和提现金额都减去提现钱数
		// 提现中加上金额
		map.put("txfee", fee);
		count = moneyMapper.updateUserChargeByTx(map);
		if (count == 0)
			throw new RuntimeException();
		return count;
	}
	
	@Override
	@Transactional
	public int updateTxRecodeState(Map map) {
		int count = 0;
		count = moneyMapper.updateTxRecodeState(map);
		// 插入用户确认日志
		if (count > 0) {
			//获取体现确认操作人 信息 
			Map mapUser=moneyMapper.getUserInfoByTxid(Integer.valueOf(map.get("id").toString()));
			// tower_user_tx_doinfo
			TxDoinfo txdoinfo = new TxDoinfo();
			txdoinfo.setTxid((String)mapUser.get("txid"));
			txdoinfo.setDouserid((String)mapUser.get("username"));
			txdoinfo.setDousername((String)mapUser.get("username"));
			txdoinfo.setDousertele((String)mapUser.get("usertele"));
			txdoinfo.setUsertype(0);
			txdoinfo.setNowstate(Integer.valueOf(map.get("state").toString()));
			count = moneyMapper.addTxdoinfo(txdoinfo);
			if(count==0)
				throw new RuntimeException();
		}
		return count;
	}

	@Override
	public List<TxSource> weGetGetNowMoenys(int userid) {
		// TODO Auto-generated method stub
		return moneyMapper.weGetGetNowMoenys(userid);
	}

	@Override
	public TxSource weGetGetNowInfos(int txid) {
		// TODO Auto-generated method stub
		return moneyMapper.weGetGetNowInfos(txid);
	}

	@Override
	@Transactional
	public List<TxRecord> weGetGettingNowMoneys(int userid) {
		// TODO Auto-generated method stub
		List<TxRecord> list = moneyMapper.weGetGettingNowMoneys(userid);
		if(list==null){
			return null;
		}
		for(int i=0;i<list.size();i++){
			List<TxRecordTower> listTx =  moneyMapper.GetTxRecordTower(list.get(i).getId());
			if(listTx==null){
				list.get(i).setRecordDetails(new ArrayList<TxRecordTower>());
			}else{
				if(listTx.size()>0){
					for(int j=0;j<listTx.size();j++){
						String temp = StrUtil.FormatStr(listTx.get(j).getTowerimg());
						listTx.get(j).setTowerimg(temp);		
					}
				}
				list.get(i).setRecordDetails(listTx);
				/*if(listTx.size()>0){
					list.get(i).setTowertypeimg(listTx.get(0).getTowerimg());
				}*/
			}
		}
		return list;
	}

	@Override
	public TxRecord weGetGettingNowInfos(int id) {
		// TODO Auto-generated method stub
		return moneyMapper.weGetGettingNowInfos(id);
	}

	@Override
	@Transactional
	public List<TxRecord> weGetAllGettingMoenys(int userid) {
		// TODO Auto-generated method stub
		List<TxRecord> list = moneyMapper.weGetAllGettingMoenys(userid);
		if(list==null){
			return null;
		}
		for(int i=0;i<list.size();i++){
			List<TxRecordTower> listTx =  moneyMapper.GetTxRecordTower(list.get(i).getId());
			if(listTx==null){
				list.get(i).setRecordDetails(new ArrayList<TxRecordTower>());
			}else{
				if(listTx.size()>0){
					for(int j=0;j<listTx.size();j++){
						String temp = StrUtil.FormatStr(listTx.get(j).getTowerimg());
						listTx.get(j).setTowerimg(temp);		
					}
				}
				list.get(i).setRecordDetails(listTx);
				/*if(listTx.size()>0){
					list.get(i).setTowertypeimg(listTx.get(0).getTowerimg());
				}*/
			}
		}
		return list;
	}

	@Override
	public TxRecord weGetAllGettingInfos(int id) {
		// TODO Auto-generated method stub
		return moneyMapper.weGetGettingNowInfos(id);
	}
	
}
