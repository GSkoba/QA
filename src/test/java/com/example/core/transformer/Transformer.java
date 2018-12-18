package com.example.core.transformer;

import com.example.core.wrapper.Wrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Transformer {

    public static List<Wrapper> wrap(List<WebElement> elements, WebDriver driver){
        if (elements.isEmpty()){
            return Collections.<Wrapper>emptyList();
        }
        List<Wrapper> listOfElements = new ArrayList<Wrapper>();
        for(WebElement element: elements){
            listOfElements.add(new Wrapper(element, driver));
        }
        return listOfElements;
    }
}
