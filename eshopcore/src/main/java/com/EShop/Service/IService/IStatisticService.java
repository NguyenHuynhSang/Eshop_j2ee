package com.EShop.Service.IService;

import com.EShop.Model.Product;
import com.EShop.Model.Statistic;

import java.sql.SQLException;
import java.util.List;

public interface IStatisticService {
    public List<Statistic> GetStatistics(String fromDate, String toDate)throws SQLException;
}
