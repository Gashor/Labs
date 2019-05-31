package com.filatov;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class Test {
    String siteHomePage="https://pn.com.ua";
    @Steps
    StepsForSerenity stepsForSerenity;

    @org.junit.Test
    public void verifySubCategory() {
        stepsForSerenity.a_user_visits_a_page_(siteHomePage);
        stepsForSerenity.the_user_chooses_category_Computer();
        stepsForSerenity.the_user_can_see_subcategory_ITService("IT услуги");
    }
}
