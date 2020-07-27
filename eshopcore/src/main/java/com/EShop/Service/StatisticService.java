package com.EShop.Service;

import com.EShop.Filter.StatisticFilter;
import com.EShop.Model.Menu;
import com.EShop.Model.Statistic;
import com.EShop.Service.IService.IStatisticService;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StatisticService implements IStatisticService {
    Connection conn = DbConnection.getJDBCConnection();
    @Override
    public List<Statistic> GetStatistics(StatisticFilter filter) throws SQLException {

        List<Statistic> statistics = new ArrayList<>();
        if (filter.fromDate==null)
        {
            filter.fromDate=Date.valueOf("2020-01-01");
        }
        if (filter.toDate==null)
        {
            filter.toDate=Date.valueOf("2022-01-01");
        }


        String SPsql = "EXEC GetRevenueStatistic ?,?";   // for stored proc taking 3 params
        PreparedStatement ps = conn.prepareStatement(SPsql);
        ps.setEscapeProcessing(true);
        ps.setQueryTimeout(1000);
        ps.setDate(1, filter.fromDate);
        ps.setDate(2, filter.toDate);
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
