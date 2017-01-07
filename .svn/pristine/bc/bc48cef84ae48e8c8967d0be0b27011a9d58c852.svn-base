package com.bolion.money.mapper;

import java.util.List;
import java.util.Map;

import com.bolion.money.bean.Bank;
import com.bolion.money.bean.Card;
import com.bolion.money.bean.MyMoney;
import com.bolion.money.bean.TxDoinfo;
import com.bolion.money.bean.TxRecord;
import com.bolion.money.bean.TxRecordTower;
import com.bolion.money.bean.TxSource;
import com.bolion.money.bean.UserTxRecordInfo;


public interface MoneyMapper {
	
	public MyMoney getMyMoney(int userid);
	
	public List<Bank> getBanks();
	
	public List<Card> getCards(int userid);
	
	public Card getCard(int id);
	
	public int deleteCard(int id);
	
	public int CancelDefault(Map map);
	
	public int updateCard(Card card);
	
	public int addCard(Card card);
	
	public int saveupdateCard(Card card);
	
	public int getCardNumber(int userid);
	
	/**
	 * 
	 * @param 获取用户默认的银行卡
	 * @return
	 */
	public Card getDefaultCard(int userid);
	
	public int getReturnMoney(int userid);
	
	public int insertUserTxRecord(UserTxRecordInfo UserTxRecordInfo);
	
	public int updateUserChargeTxid(Map map);
	
	public int updateUserChargeByTx(Map map);
	
	public int updateTxRecodeState(Map map);
	
	public Map getUserInfoByTxid(int txid);
	
	public int addTxdoinfo(TxDoinfo txDoinfo);
	
	public List<TxSource> weGetGetNowMoenys(int userid);
	
	public TxSource weGetGetNowInfos(int txid);
	
	public List<TxRecord> weGetGettingNowMoneys(int userid);
	
	public TxRecord weGetGettingNowInfos(int id);
	
	public List<TxRecord> weGetAllGettingMoenys(int userid);
	
	public List<TxRecordTower> GetTxRecordTower(int id);
	
}
