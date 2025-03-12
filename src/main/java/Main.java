import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Kullanıcıdan sayıyı al
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sayı Giriniz : ");
        int sayi = scanner.nextInt();

        // Asal olup olmadığını kontrol et
        if (isAsal(sayi, sayi/2)) {
            System.out.println(sayi + " sayısı ASALdır !");
        } else {
            System.out.println(sayi + " sayısı ASAL değildir !");
        }
    }

    // Recursive metot: isAsal
    public static boolean isAsal(int sayi, int i) {
        // Eğer sayi 1'den küçükse, asal olamaz
        if (sayi <= 1) {
            return false;
        }
        // Sayinin 1 dışında hiçbir kalansız böleni yoksa sayi asaldır.
        if (i <= 1) {
            return true;  // Sayı asal
        }
        // Eğer sayi, i'ye tam bölünüyorsa asal değildir
        if (sayi % i == 0) {
            return false; // Sayı asal değil
        }
        // Rekürsif olarak devam et
        return isAsal(sayi, --i);
    }
}