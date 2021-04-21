package com.encore.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDaoTemplate {
	// itemid --> itemNumber
	ArrayList<Item> getAllItem() throws SQLException;
	Item getItem(int itemid) throws SQLException;
	boolean updateRecordCount(int itemid) throws SQLException;
	

}
