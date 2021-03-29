package com.petrenko.lab0232;

public class Main {

    public static void main(String[] args) {
	    PhoneBook pb = new PhoneBook();

	    pb.addPhone(80675556677L, "Barchenko");
        pb.addPhone(80674448877L, "Petrichenko");
        pb.addPhone(80683334455L, "Pavlenko");
        pb.addPhone(80502223344L, "Andrushko");
        pb.addPhone(80501112299L, "Lyashenko");
        pb.addPhone(80638881155L, "Bilyk");
        pb.addPhone(80984707331L, "Petrichenko");

        pb.checkAll();

        pb.removePhone(80683334455L);
        pb.checkAll();

        pb.fingByNumber(80638881156L);
        pb.fingByNumber(80638881155L);

        pb.findBySurname("Petrichenk");
        pb.findBySurname("Petrichenko");
    }
}
