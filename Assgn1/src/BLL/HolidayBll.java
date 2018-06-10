package BLL;

import java.sql.SQLException;

import javax.swing.JTable;

import ProductModel.HolidayQuery;
import entities.Cruise;
import entities.Holiday;
import entities.Stay;
import entities.Tour;

public class HolidayBll {

	public static void viewHoliday(JTable table) throws Exception
	{
		HolidayQuery.viewHoliday(table);
	}
	
	public static boolean deleteTour(Tour c)
	{
		return HolidayQuery.deleteTour(c);
	}
	
	public static boolean reserveTour(Tour c) throws SQLException, Exception
	{
		return HolidayQuery.reserveTour(c);
	}
	
	public static boolean deleteStay(Stay c)
	{
		return HolidayQuery.deleteStay(c);
	}
	
	public static boolean reserveStay(Stay c) throws SQLException, Exception
	{
		return HolidayQuery.reserveStay(c);
	}
	
	public static boolean deleteCruise(Cruise c)
	{
		return HolidayQuery.deleteCruise(c);
	}
	
	public static boolean reserveCruise(Cruise c) throws SQLException, Exception
	{
		return HolidayQuery.reserveCruise(c);
	}
	
}
