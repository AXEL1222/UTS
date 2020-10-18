import java.util.Scanner;

public class Pengisian_ovo_menggunakan_BCA {

    Scanner scn = new Scanner(System.in);

    public static String label;
    public static String trfname;
    public static double balance = 100000;
    public static String name = "Axel Mikaya";
    public static String trsCode = "5277778611";

    public void spacing() {
        for (int i = 1; i < 60; i++) {
            System.out.println();
        }
        System.out.println(label);
        System.out.println("==============================");
    }

    public boolean pin(int a) {
        int pin1 = 123456;

        return a != pin1;
    }

    public boolean ovoNames(String a) {
        boolean found = false;

        String[] names = { "Axel Mikaya" };
        String[] codes = { "39358081285681506"};
        for (int i = 0; i < names.length; i++) {
            if (a.equals(codes[i])) {
                trfname = names[i];
                found = true;
                break;
            }
        }
        return found;
    }

    public void infoMain() {
        label = "Info Saldo";
        spacing();
        System.out.println(name + " " + trsCode);
        System.out.println("Saldo anda Rp. " + balance);
        System.out.println("\nTekan enter untuk melanjutkan..");
        try {
            System.in.read();
        } catch (Exception e) {

        }
    }

    public void vaMenu() {
        String codein, chs;
        double send = 0;

        label = "Virtual Account";
        spacing();

        do {
            do {
                System.out.print("Silahkan masukkan kode!: ");
                codein = scn.nextLine();
            } while (codein.matches("[a-z]") || codein.length() < 15 || codein.length() > 20);


            if (!ovoNames(codein)) {
                System.out.println("Kode yang anda masukkan tidak ada di Bank!");
                do {
                    System.out.print("Apakah anda ingin memasukkan kode kembali? ya/tidak?: ");
                    chs = scn.nextLine();
                } while (!chs.equalsIgnoreCase("ya") && !chs.equalsIgnoreCase("tidak"));
                if (chs.equalsIgnoreCase("tidak")) {
                    break;
                }
            }
        } while (!ovoNames(codein));

        if (ovoNames(codein)) {
            spacing();
            do {
                System.out.print("Anda akan mentransfer ke OVO (" + trfname + "). ya/tidak?: ");
                chs = scn.nextLine();
            } while (!chs.equalsIgnoreCase("ya") && !chs.equalsIgnoreCase("tidak"));

            if (chs.equalsIgnoreCase("tidak")) {
                System.out.println("Anda membatalkan transaksi, tekan enter untuk melanjutkan..");
                try {
                    System.in.read();
                } catch (Exception e) {

                }
            } else {
                if (balance < 25000) {
                    System.out.println("Saldo anda kurang dari minimum transaksi!");
                    System.out.println("Tekan enter untuk melanjutkan..");
                    try {
                        System.in.read();
                    } catch (Exception e) {

                    }
                } else {
                    do {
                        System.out.println("Silahkan masukkan saldo yang anda ingin kirimkan:");
                        System.out.print("Rp. ");
                        try {
                            send = scn.nextDouble();
                        } catch (Exception e) {
                            System.out.println("Input harus nominal!");
                        }
                        scn.nextLine();

                        if (send < 25000) {
                            System.out.println("Minimal nominal Rp. 25000!");
                        } else if (send > balance) {
                            System.out.println("Nominal melebihi saldo!");
                        }
                    } while (send < 25000 || send > balance);
                    balance -= send;
                    System.out.println("Berhasil mengirim saldo sebesar Rp. " +
                            send + " kepada OVO (" + trfname + ").");
                    System.out.println("Tekan enter untuk melanjutkan..");
                    try {
                        System.in.read();
                    } catch (Exception e) {

                    }
                }
            }
        }
    }

    public Pengisian_ovo_menggunakan_BCA() {
        int pinin = 0;
        int chs;
        String chs1;

        label = "Selamat datang di BCA m-Banking!";
        spacing();
        do {
            System.out.print("Masukkan PIN anda! (6 digit) : ");
            try {
                pinin = scn.nextInt();
            } catch (Exception e) {
                System.out.println("Input harus angka!");
            }
            scn.nextLine();
        } while (pin(pinin));

        System.out.println();
        do {
            do {
                chs = 0;
                label = "Main Menu";
                spacing();
                System.out.println("1. Info");
                System.out.println("2. Virtual Account");
                System.out.println("3. Keluar");
                System.out.print(">> ");
                try {
                    chs = scn.nextInt();
                } catch (Exception e) {
                    System.out.println("Input harus angka");
                }
                scn.nextLine();
            } while (chs < 1 || chs > 3);

            if (chs == 1) {
                infoMain();
            } else if (chs == 2) {
                vaMenu();
            } else if (chs == 3) {
                label = "Keluar";
                spacing();
                do {
                    System.out.print("Apakah anda ingin keluar? ya/tidak?: ");
                    chs1 = scn.nextLine();
                } while (!chs1.equalsIgnoreCase("ya") && !chs1.equalsIgnoreCase("tidak"));

                if (chs1.equalsIgnoreCase("ya")) {
                    System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                    break;
                }
            }

        } while (chs != 0);
    }

    public static void main(String[] args) {
        new Pengisian_ovo_menggunakan_BCA();

    }
}