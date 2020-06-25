/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.IService;

import com.EShop.Mapper.RowMapper;
import java.util.List;

/**
 *
 * @author nhatminh
 */
public interface IDbConnection<T>{
    <T> List<T> query(String sql, RowMapper<T> rowMapper,Object... parameters);
    void Update(String sql,Object... parameters);
}
