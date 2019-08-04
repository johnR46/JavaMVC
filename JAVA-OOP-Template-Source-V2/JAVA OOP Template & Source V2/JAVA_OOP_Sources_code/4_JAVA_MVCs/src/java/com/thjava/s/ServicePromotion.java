package com.thjava.s;

import com.thjava.m.Books;
import java.util.ArrayList;
import java.util.List;

public class ServicePromotion {
    
    public static List<Books> discount(List<Books> bList) {
        List<Books> newPriceList = new ArrayList<>();
        
        for (int i = 0; i < bList.size(); i++) {
            
            // เช็คราคาที่ลด ต้องไม่เท่ากับ 0
            if(bList.get(i).getPrice() != 0) {
                bList.get(i).setPrice(bList.get(i).getPrice() - 5);
            }
            // ใส่ราคาใหม่ลงไปใน ส่วนของ Model
            Books book = new Books(bList.get(i).getId(),
                                   bList.get(i).getTitle(),
                                   bList.get(i).getPrice());
            // นำ Model ใส่ใน List
            newPriceList.add(book);
        }
        
        return newPriceList;
    }

} // class ServicePromotion
