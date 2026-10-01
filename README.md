# STAJ22001 - Yazılım Test Otomasyonu Projesi

Bu depo, **STAJ22001 Mesleki Stajı** kapsamında yürütülen E-Ticaret Platformu Test Otomasyonu çalışmalarını içermektedir.

## Kullanılan Teknolojiler ve Kütüphaneler
- **Programlama Dili:** Java (JDK 11+)
- **Test Framework:** TestNG (v7.10.0)
- **Web Otomasyon Aracı:** Selenium WebDriver (v4.20.0)
- **Bağımlılık Yönetimi:** Apache Maven
- **Sürücü Yöneticisi:** WebDriverManager (v5.8.0)
- **Tasarım Deseni:** Page Object Model (POM)

## Proje Mimarisi ve Paket Yapısı
- `base`: WebDriver yaşam döngüsünü (@BeforeMethod, @AfterMethod) yöneten taban sınıf.
- `pages`: Sayfa elementlerinin (@FindBy) ve kullanıcı işlemlerinin kapsüllendiği POM sınıfları (LoginPage, SearchPage).
- `tests`: Test senaryolarının işletildiği ve TestNG assertion doğrulamalarının yapıldığı test sınıfları.

## Otomasyon Kapsamı
1. **Giriş Modülü:** Pozitif giriş ve geçersiz bilgilerle negatif doğrulama testleri.
2. **Arama ve Sepet Modülü:** Dinamik arama sonuçlarının doğrulanması, ürün seçimi ve sepete ekleme akışı.
