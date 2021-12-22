package me.TheTealViper.ticketmanager.Utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLShit {
	public Connection connection = null;
	
	public SQLShit(String host, String port, String database, String username, String password){
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testTable(String table, String database){
		try{
			Statement statement = (Statement) connection.createStatement();
			statement.executeUpdate("CREATE TABLE `" + table + "` (PRIMARYKEY VARCHAR(100) NOT NULL, PRIMARY KEY (PRIMARYKEY));");
		}catch(Exception e){
//			e.printStackTrace();
		}
	}
	
	public void delete(TableSlot slot){
		try {
			Statement statement = (Statement) connection.createStatement();
			statement.executeUpdate("DELETE FROM `" + slot.table + "` WHERE " + slot.columnID + " = '" + slot.PRIMARYKEY + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object get(TableSlot slot, Object defaultValue){
		try{
			Statement statement = (Statement) connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM " + slot.table + " WHERE PRIMARYKEY = '" + slot.PRIMARYKEY + "';");
			result.next();
			return result.getObject(slot.columnID);
		}catch(Exception e){
			try{
			Statement statement = (Statement) connection.createStatement();
			statement.executeUpdate("ALTER TABLE " + slot.table + " ADD COLUMN " + slot.columnID + " " + slot.dataType + " DEFAULT " + defaultValue);
			}catch(Exception e1){
				
			}
			return defaultValue;
		}
	}
	
	public void set(TableSlot slot, String value, String defaultValue){
		try{
			Statement statement = (Statement) connection.createStatement();
			DatabaseMetaData md = connection.getMetaData();
			ResultSet rs = md.getColumns(null, null, slot.table, slot.columnID);
			if (rs.next()) {
//				Bukkit.broadcastMessage("Checkpoint 1");
//				statement.executeUpdate("UPDATE `" + slot.table + "` SET " + slot.columnID + " = '" + value + "' WHERE PRIMARYKEY = '" + slot.PRIMARYKEY + "'");
			}else{
//				Bukkit.broadcastMessage("Checkpoint 2");
				statement.executeUpdate("ALTER TABLE `" + slot.table + "` ADD " + slot.columnID + " " + slot.dataType);
				statement.executeUpdate("INSERT INTO `" + slot.table + "` (PRIMARYKEY, " + slot.columnID + ") VALUES ('" + slot.PRIMARYKEY + "', '" + value + "')");
			}
		}catch(Exception e1){
			try{
//				e1.printStackTrace();
				Statement statement = (Statement) connection.createStatement();
				statement.executeUpdate("UPDATE `" + slot.table + "` SET " + slot.columnID + " = '" + value + "' WHERE PRIMARYKEY = '" + slot.PRIMARYKEY + "'");
//				Statement statement = (Statement) connection.createStatement();
////				Bukkit.broadcastMessage("Checkpoint 3");
//				statement.executeUpdate("INSERT INTO `" + slot.table + "` ('PRIMARYKEY', '" + slot.columnID + "') VALUES ('" + slot.PRIMARYKEY + "', '" + value + "');");
////				Bukkit.broadcastMessage("Checkpoint 4");
			}catch (Exception e2){
//				e2.printStackTrace();
//				try{
//					Statement statement = (Statement) connection.createStatement();
////					Bukkit.broadcastMessage("Checkpoint 5");
//					statement.executeUpdate("ALTER TABLE `" + slot.table + "` ADD " + slot.columnID + " " + slot.dataType + " NOT NULL DEFAULT " + defaultValue + ";");
////					Bukkit.broadcastMessage("Checkpoint 6");
//					statement.executeUpdate("INSERT INTO " + slot.table + " (PRIMARYKEY, " + slot.columnID + ") VALUES ('" + slot.PRIMARYKEY + "', " + value + ");");
////					Bukkit.broadcastMessage("Checkpoint 7");
//				}catch(Exception e3){
//					e3.printStackTrace();
//				}
			}
		}
	}
	
	public class TableSlot{
		public String table = null, PRIMARYKEY = null, columnID = null, dataType = null;
		public TableSlot(String table, String PRIMARYKEY, String columnID, String dataType){
			this.table = table;
			this.PRIMARYKEY = PRIMARYKEY;
			this.columnID = columnID;
			this.dataType = dataType;
		}
	}
	
}
