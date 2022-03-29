package com.service.impl;

import com.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/*
    Created by Trinh Khai
    Date: 29/03/2022
    Time: 15:27
*/
@Service
public class DictionaryService implements IDictionaryService {
    List<String> vietnameseList = Arrays.asList("con chó", "con mèo", "điện thoại");
    List<String> englishList = Arrays.asList("dog", "cat", "phone");

    @Override
    public String convertToEnglish(String vietnamese) {
        int index = -1;
        boolean check = false;
        for (int i = 0; i < vietnameseList.size(); i++) {
            if (vietnamese.equals(vietnameseList.get(i))) {
                index = i;
                check = true;
            }
        }
        if (check) {
            return englishList.get(index);
        } else {
            return "404 - Not found";
        }
    }
}
