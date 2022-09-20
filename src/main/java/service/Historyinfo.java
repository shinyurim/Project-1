

package service;
import java.util.List;

import Daolist.History_Dao;
import Dtolist.History_Dto;

public class Historyinfo {

		public List<History_Dto> historyList(){
			History_Dao history_dao = new History_Dao();
			return history_dao.history_dto();
		}
		
		public void InsertH(History_Dto history_dto) {
			History_Dao history_dao = new History_Dao();
			history_dao.HistoryInsert(history_dto);
		}
		public int DeleteH(int History_ID) {
			History_Dao history_dao = new History_Dao();
			return history_dao.delete(History_ID);
		
	}
	}