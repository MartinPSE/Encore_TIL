// DB관련 자질구레한 것들은 여기다가 넣어놓자.
/*
 *  JNDI API를 이용해서 DataSource를 하나 반환받아온다.
 *  싱글톤 구상
 * 
 */

package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceManager {
	private DataSource ds;
	
	private static DataSourceManager instance = new DataSourceManager();
	
	private DataSourceManager() {
		// 이 안에서 Naming 서비스 로직을 작성한다.
		try {
			Context ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql"); // 외부이름 접근법
			
			System.out.println("DataSource Lookup!!");
		}catch(NamingException e){
			System.out.println(" <<<<< DataSource Lookup ERROR!! >>>>>");
		}
		
	}
	
	public static DataSourceManager getInstance() {
		return instance;
	}
	
	// 추가    DataSource를 하나 반환 받아온다.
	public DataSource getConnection() {
		return ds;
		
	}
	

}
