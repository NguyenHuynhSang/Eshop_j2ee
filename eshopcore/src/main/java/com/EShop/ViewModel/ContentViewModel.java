/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.ViewModel;

import com.EShop.Model.Content;
import com.EShop.Model.ContentCategory;

/**
 *
 * @author nhatminh
 */
public class ContentViewModel {

    public ContentViewModel(Content content, ContentCategory category) {
        this.content = content;
        this.category = category;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public ContentCategory getCategory() {
        return category;
    }

    public void setCategory(ContentCategory category) {
        this.category = category;
    }

    public ContentViewModel() {
    }
    Content content;
    ContentCategory category;
}
