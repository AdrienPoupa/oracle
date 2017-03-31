package com.efrei.oracle.project.core;

import com.efrei.oracle.project.gui.*;

/**
 * Created by Adrien on 24/03/2017.
 */
class Routing {

    public static Object route(String gui, int card){
        Object page = null;

        switch (gui) {

            case "login":
                page = new Welcome();
                break;

            case "home":
                page = new Home();
                break;

            case "addMoney":
                page = new AddMoney();
                break;

            case "withdraw":
                page = new Withdraw();
                break;

            case "checkAccount":
                page = new CheckAccount(card);
                break;
        }

        return page;
    }
}
