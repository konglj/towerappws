package com.bolion.money.service.impl;

import java.util.List;
import java.util.Map;

import com.bolion.money.bean.Bank;
import com.bolion.money.bean.Card;
import com.bolion.money.bean.MyMoney;
import com.bolion.money.bean.TxRecord;
import com.bolion.money.bean.TxSource;

public interface MoneyService {
	
	public MyMoney getweGetUserMoney(int userid);
	
	public List<Bank> getBanks();
	
	public List<Card> weGetBankList(int userid);
	
	public Card getCardInfo(int id);
	
	public int updateCard(Card card);
	
	public int deleteBankCard(int id);
	
	public int SetDefault(Map map);
	
	public int txMoney(Map map);
	
	public int updateTxRecodeState(Map map);
	
	public List<TxSource> weGetGetNowMoenys(int userid);
	
	public TxSource weGetGetNowInfos(int txid);
	
	public List<TxRecord> weGetGettingNowMoneys(int userid);
	
	public TxRecord weGetGettingNowInfos(int id);
	
	public List<TxRecord> weGetAllGettingMoenys(int userid);
	
	public TxRecord weGetAllGettingInfos(int id);
	
}
