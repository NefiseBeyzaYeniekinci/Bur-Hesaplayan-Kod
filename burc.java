import java.util.Scanner;

public class burc {
    public static void main(String[] args) {
        Scanner giris = new Scanner(System.in);

        System.out.println("1\\OCAK\n2\\ŞUBAT\n3\\MART\n4\\NİSAN\n5\\MAYIS\n6\\HAZİRAN\n7\\TEMMUZ\n8\\AĞUSTOS\n9\\EYLÜL\n10\\EKİM\n11\\KASIM\n12\\ARALIK");

        System.out.println("Doğduğunuz yılı giriniz: ");
        int yil = giris.nextInt();
        System.out.println("Doğduğunuz ayın numarasını giriniz: ");
        int ay = giris.nextInt();
        System.out.println("Doğduğunuz günü giriniz: ");
        int gun = giris.nextInt();
        
        if (yil < 1900 || yil > 2100) {
            System.out.println("Geçersiz yıl girişi. Lütfen 1900 ile 2100 arasında bir yıl giriniz.");
            return;
        }

        int[] ayinGunleri = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int Gun = ayinGunleri[ay - 1];

        if (yil % 4 == 0 && (yil % 100 != 0 || yil % 400 == 0)) {
            ayinGunleri[1] = 29;
        }

        if (gun < 1 || gun > Gun) {
            System.out.println("Geçersiz gün girişi. Lütfen seçtiğiniz ay için geçerli bir gün giriniz.");
            return;
        }

        String burc = bulBurc(ay, gun);
        if (burc != null) {
            System.out.println("Burcunuz: " + burc);
        } else {
            System.out.println("Geçersiz giriş. Lütfen geçerli bir ay (1-12), gün ve yıl giriniz.");
        }
    }

    public static String bulBurc(int ay, int gun) {
        int[] burcBaslangicGunleri = {21, 20, 21, 21, 22, 23, 23, 23, 23, 23, 22, 22};
        ay = (gun < burcBaslangicGunleri[ay - 1]) ? ((ay - 2 + 12) % 12 + 1) : ay;

        if (ay == 1) {
            return (gun < 20) ? "OĞLAK" : "KOVA";
        } else if (ay == 2) {
            return (gun < 19) ? "KOVA" : "BALIK";
        } else if (ay == 3) {
            return (gun < 21) ? "BALIK" : "KOÇ";
        } else if (ay == 4) {
            return (gun < 20) ? "KOÇ" : "BOĞA";
        } else if (ay == 5) {
            return (gun < 21) ? "BOĞA" : "İKİZLER";
        } else if (ay == 6) {
            return (gun < 22) ? "İKİZLER" : "YENGEÇ";
        } else if (ay == 7) {
            return (gun < 23) ? "YENGEÇ" : "ASLAN";
        } else if (ay == 8) {
            return (gun < 23) ? "ASLAN" : "BAŞAK";
        } else if (ay == 9) {
            return (gun < 23) ? "BAŞAK" : "TERAZİ";
        } else if (ay == 10) {
            return (gun < 23) ? "TERAZİ" : "AKREP";
        } else if (ay == 11) {
            return (gun < 22) ? "AKREP" : "YAY";
        } else if (ay == 12) {
            return (gun < 22) ? "YAY" : "OĞLAK";
        } else {
            return null;
        }
    }
}
