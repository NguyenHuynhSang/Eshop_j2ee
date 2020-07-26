package com.EShop.Service;

import com.EShop.Model.Menu;
import com.EShop.Model.Statistic;
import com.EShop.Service.IService.IStatisticService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StatisticService implements IStatisticService {
    Connection conn = DbConnection.getJDBCConnection();
    @Override
    public List<Statistic> GetStatistics(String fromDate, String toDate) throws SQLException {

        List<Statistic> statistics = new ArrayList<>();
        fromDate="02/27/2020";
        toDate="07/30/2020";
        String SPsql = "EXEC GetRevenueStatistic ?,?";   // for stored proc taking 3 params
        PreparedStatement ps = conn.prepareStatement(SPsql);
        ps.setEscapeProcessing(true);
        ps.setQueryTimeout(1000);
        ps.setString(1, fromDate);
        ps.setString(2, toDate);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            Statistic statistic=new Statistic();
            statistic.setDate(rs.getString("Date"));
            statistic.setBenefis(rs.getInt("Benefis"));
            statistic.setRevenunes(rs.getInt("Revenunes"));
            statistics.add(statistic);
        }
        rs.close();
        ps.close();
        conn.close();
        return statistics;

    }
}
