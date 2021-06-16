package org.rates_api;

import GUI_Currency_Exchanger.ApiConnection;

import java.io.IOException;

public class testing {
    public static void main(String[] args) {
        try {
            ApiConnection myobj = new ApiConnection();
            System.out.println(myobj.CNY);
        }
        catch (IOException e){
            System.out.println("Error");
        }

    }
}
