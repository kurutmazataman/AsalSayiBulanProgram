### 1. **Kullanıcıdan Sayı Alma:**
   ```java
   Scanner scanner = new Scanner(System.in);
   System.out.print("Sayı Giriniz : ");
   ```
- Kullanıcıdan bir sayı girmesini isteyen bir mesaj basılır.
- `Scanner` sınıfı, kullanıcıdan girdi almayı sağlar.

### 2. **Exception Handling (Hata Yakalama):**
   ```java
   try {
       int sayi = scanner.nextInt();
       // ...
   } catch (NullPointerException excpt) {
       System.out.println("Scanner nesnesi oluşturulamadı");
   } catch (InputMismatchException excpt) {
       System.out.println("Geçersiz şifre girişi !");
   } catch (Exception e) {
       System.out.println(e.getMessage());
   } finally {
       scanner.close();
   }
   ```
- Burada `try-catch` bloğu kullanılarak, olası hatalar yakalanır.
- Eğer kullanıcı geçerli bir sayı girmezse, `InputMismatchException` hatası meydana gelir ve hata mesajı gösterilir.
- Eğer başka bir hata oluşursa, bu `Exception` bloğu tarafından yakalanır.
- `finally` bloğunda `scanner.close()` kullanılarak, scanner nesnesi kapatılır.

### 3. **Asallık Kontrolü:**
   ```java
   if (isAsal(sayi, sayi / 2)) {
       System.out.println(sayi + " sayısı ASALdır !");
   } else {
       System.out.println(sayi + " sayısı ASAL değildir !");
   }
   ```
- Kullanıcıdan alınan sayının asal olup olmadığı `isAsal()` metodu ile kontrol edilir.
- Eğer `isAsal` metodu `true` dönerse, sayı asal olarak kabul edilir ve ekrana `"ASALdır"` yazılır; aksi takdirde `"ASAL değildir"` mesajı gösterilir.

### 4. **Asal Kontrolü İçin Recursive (Yinelemeli) Metod:**
   ```java
   public static boolean isAsal(int sayi, int i) {
       if (sayi <= 1) {
           return false;
       }
       if (i <= 1) {
           return true;
       }
       if (sayi % i == 0) {
           return false;
       }
       return isAsal(sayi, --i);
   }
   ```
- Bu metot, bir sayının asal olup olmadığını kontrol etmek için **rekürsif** bir algoritma kullanır.
- Eğer sayı 1 veya daha küçükse asal değildir, bu durumda `false` döner.
- Eğer `i` 1'e eşitse, o zaman sayı asal kabul edilir ve `true` döner.
- Eğer sayı `i` ile tam bölünüyorsa (yani kalansız bölünüyorsa), bu sayının asal olmadığını gösterir ve `false` döner.
- Eğer yukarıdaki şartlar sağlanmazsa, metot kendisini yeniden çağırarak, daha küçük bir değeri kontrol eder.

### 5. **Kodun Çalışma Mantığı:**
- Kullanıcı bir sayı girer.
- Program, bu sayıyı `isAsal` metoduyla kontrol eder.
- Eğer sayı asal ise, `"ASALdır"` mesajı yazdırılır; değilse, `"ASAL değildir"` mesajı yazdırılır.
- Hata durumları (geçersiz giriş, başka hatalar) için uygun hata mesajları gösterilir.

### Örnek:
Eğer kullanıcı 7 girerse:
- Program, 7 sayısının asal olup olmadığını `isAsal` metodu ile kontrol eder.
- 7'nin 7'den küçük bir sayı olan 3 ile bölünmediği için, sonuç "7 sayısı ASALdır !" olarak dönecektir.

Eğer kullanıcı 8 girerse:
- Program, 8 sayısının 8'e bölünebileceğini tespit edecek ve sonuç "8 sayısı ASAL değildir !" olarak dönecektir.

### Kodun Kullanım Amacı:
- **Asal Sayı Kontrolü**: Kullanıcıdan alınan bir sayının asal olup olmadığını belirlemek ve ekrana yazdırmak için kullanılan bir programdır.
