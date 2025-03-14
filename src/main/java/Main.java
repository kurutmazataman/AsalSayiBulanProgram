import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Kullanıcıdan sayıyı al
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sayı Giriniz : ");

        // Exception Handling
        try {
            int sayi = scanner.nextInt();

            // Asal olup olmadığını kontrol et
            if (isAsal(sayi, sayi/2)) {
                System.out.println(sayi + " sayısı ASALdır !");
            } else {
                System.out.println(sayi + " sayısı ASAL değildir !");
            }

        }catch (NullPointerException excpt){
            System.out.println("Scanner nesnesi oluşturulamadı");
        }catch(InputMismatchException excpt){
            System.out.println("Geçersiz şifre girişi !");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            scanner.close();
        }
    }

    // Recursive metot: isAsal
    public static boolean isAsal(int sayi, int tempNumber) {
        // Eğer sayi 1'den küçükse, asal olamaz
        if (sayi <= 1) {
            return false;
        }
        // Sayinin 1 dışında hiçbir kalansız böleni yoksa sayi asaldır.
        if (tempNumber <= 1) {
            return true;  // Sayı asal
        }
        // Eğer sayi, i'ye tam bölünüyorsa asal değildir
        if (sayi % tempNumber == 0) {
            return false; // Sayı asal değil
        }
        // Rekürsif olarak devam et
        return isAsal(sayi, tempNumber -1);
    }
}