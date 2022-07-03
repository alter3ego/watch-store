package com.watch.store.model.dao;

import com.watch.store.model.entity.Color;
import com.watch.store.model.entity.MechanicalWatch;
import com.watch.store.model.entity.QuartzWatch;
import com.watch.store.model.entity.SolarWatch;
import com.watch.store.model.entity.Watch;
import com.watch.store.model.exception.IncorrectDataException;

import java.util.ArrayList;
import java.util.List;

public class FillDB {
    public static List<Watch> watches() {
        List<Watch> list = new ArrayList<>();
        try {
            list.add(new QuartzWatch("CASIO MTP-13", "2560", Color.GRAY,
                    "05.12.2021", "CASIO", 12, 150));
            list.add(new QuartzWatch("DIESEL DZ1437", "4990", Color.BLACK,
                    "12.10.2020", "DIESEL", 8, 160));
            list.add(new QuartzWatch("DIESEL DZ1436", "4990", Color.WHITE,
                    "11.10.2020", "DIESEL", 7, 150));
            list.add(new QuartzWatch("CASIO MTP-13", "2560", Color.GRAY,
                    "05.12.2021", "CASIO", 12, 166));
            list.add(new MechanicalWatch("RAYMOND WEIL 2760-SR1-20001", "76650", Color.BLACK
                    , "03.05.2011", "Raymond Weil", 172));
            list.add(new MechanicalWatch("TISSOT LE LOCLE POWERMATIC 80", "22600", Color.BLUE
                    , "05.05.2010", "Tissot", 150));
            list.add(new MechanicalWatch("ZENITH DEFY CLASSIC 95", "320360", Color.BLUE
                    , "05.05.2022", "Zenith", 155));
            list.add(new SolarWatch("Jacko Boot Polish", "679", Color.YELLOW
                    , "01.09.2017", "India"));
            return list;

        } catch (IncorrectDataException e) {
            return list;
        }
    }
}
