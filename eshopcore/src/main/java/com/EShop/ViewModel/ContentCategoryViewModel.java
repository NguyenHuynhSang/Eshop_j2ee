/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.ViewModel;

import com.EShop.Model.ContentCategory;

public class ContentCategoryViewModel {

    public ContentCategoryViewModel() {
    }

    public ContentCategory getCategory() {
        return Category;
    }

    public void setCategory(ContentCategory Category) {
        this.Category = Category;
    }

    public ContentCategory getParentCategory() {
        return ParentCategory;
    }

    public void setParentCategory(ContentCategory ParentCategory) {
        this.ParentCategory = ParentCategory;
    }

    public ContentCategoryViewModel(ContentCategory Category, ContentCategory ParentCategory) {
        this.Category = Category;
        this.ParentCategory = ParentCategory;
    }
    ContentCategory Category;
    ContentCategory ParentCategory;
}
