package com.EShop.IService.IClientService;

import com.EShop.Model.Content;
import com.EShop.Model.Product;
import com.EShop.Model.Slide;
import com.EShop.Model.ViewModel.ProductViewModel;

import java.sql.SQLException;
import java.util.List;

public interface ICHomePageService {
    public List<Product> GetHotProducts() throws SQLException;
    public List<ProductViewModel> GetNewProducts() throws SQLException;
    public List<Slide> GetSlide() throws SQLException;
    public List<Content> GetNewBlog() throws SQLException;

}
