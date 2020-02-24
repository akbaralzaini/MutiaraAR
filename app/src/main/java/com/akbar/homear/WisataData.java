package com.akbar.homear;

import java.util.ArrayList;

public class WisataData {

    private static String[] wisataNames = {
            "Rumah Type 36 (plus)",
            "Rumah Type 38",
            "Rumah Type 36 (Standar)",
    };

    private static int[] heroesImages = {
            R.drawable.rtp36,
            R.drawable.rtp38,
            R.drawable.tpe36st,
    };

    private static String[] wisataLocation = {
            "Mutiara Barangan III",
            "Mutiara Barangan III",
            "Mutiara Barangan III",
    };

    private static String[] wisataDetails = {
                    "Pondasi \t\t\t\t\t\t: Batu bata\n" +
                    "Dinding"+"\t\t\t\t\t\t\t:"+" Batu bata, plaster luar dalam, cat luar dalam\n" +
                    "Lantai Utama : Kramik 40x40\n" +
                    "KM/WC\t\t\t\t\t\t\t: Lantai Kramik 20x20\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tDinding Kramik 20x25\n" +
                    "Plafond \t\t\t\t\t\t\t: Gypsum Rangka Hollow\n" +
                    "Atap\t\t\t\t\t\t\t\t\t\t: Genteng Metal Berpasir\n" +
                    "\t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\trangka baja ringan\n" +
                    "Kusen\t\t\t\t\t\t\t\t\t: kayu kelas II\n" +
                    "Pintu\t\t\t\t\t\t\t\t\t\t: Panel\n" +
                    "Air \t\t\t\t\t\t\t\t\t\t\t\t: Air sumur /PDAM\n" +
                    "Jalan\t\t\t\t\t\t\t\t\t\t: Cor beton",

            "Pondasi \t\t\t\t\t\t: Batu bata\n" +
                    "Dinding"+"\t\t\t\t\t\t\t:"+" Batu bata, plaster luar dalam, cat luar dalam\n" +
                    "Lantai Utama : Kramik 40x40\n" +
                    "KM/WC\t\t\t\t\t\t\t: Lantai Kramik 20x20\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tDinding Kramik 20x25\n" +
                    "Plafond \t\t\t\t\t\t\t: Gypsum Rangka Hollow\n" +
                    "Atap\t\t\t\t\t\t\t\t\t\t: Genteng Metal Berpasir\n" +
                    "\t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\trangka baja ringan\n" +
                    "Kusen\t\t\t\t\t\t\t\t\t: kayu kelas II\n" +
                    "Pintu\t\t\t\t\t\t\t\t\t\t: Panel\n" +
                    "Air \t\t\t\t\t\t\t\t\t\t\t\t: Air sumur /PDAM\n" +
                    "Jalan\t\t\t\t\t\t\t\t\t\t: Cor beton",

            "Pondasi \t\t\t\t\t\t: Batu bata\n" +
                    "Dinding"+"\t\t\t\t\t\t\t:"+" Batu bata, plaster luar dalam, cat luar dalam\n" +
                    "Lantai Utama : Kramik 40x40\n" +
                    "KM/WC\t\t\t\t\t\t\t: Lantai Kramik 20x20\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tDinding Kramik 20x25\n" +
                    "Plafond \t\t\t\t\t\t\t: Gypsum Rangka Hollow\n" +
                    "Atap\t\t\t\t\t\t\t\t\t\t: Genteng Metal Berpasir\n" +
                    "\t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\trangka baja ringan\n" +
                    "Kusen\t\t\t\t\t\t\t\t\t: kayu kelas II\n" +
                    "Pintu\t\t\t\t\t\t\t\t\t\t: Panel\n" +
                    "Air \t\t\t\t\t\t\t\t\t\t\t\t: Air sumur /PDAM\n" +
                    "Jalan\t\t\t\t\t\t\t\t\t\t: Cor beton"
                };



    static ArrayList<Wisata> getListData() {
        ArrayList<Wisata> list = new ArrayList<>();
        for (int position = 0; position < wisataNames.length; position++) {
            Wisata wisata = new Wisata();
            wisata.setName(wisataNames[position]);
            wisata.setLocation(wisataLocation[position]);
            wisata.setDetail(wisataDetails[position]);
            wisata.setPhoto(heroesImages[position]);
            list.add(wisata);
        }
        return list;
    }

}
