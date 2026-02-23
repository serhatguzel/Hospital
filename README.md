# Hospital

Hastane yönetim kurallarına göre hasta, doktor, hemşire ve ameliyat bilgilerini işleyen basit bir Java uygulaması.

## Kurallar

- Hastanede **20 doktor** ve **50 hemşire** bulunur.
- Ameliyata yalnızca **operatör (cerrah)** doktorlar girebilir; tüm hemşireler ameliyata girebilir.
- Bir ameliyatta **en az 1 doktor**, **en fazla 5 hemşire** yer alabilir.
- Hastalar **yılda en fazla 1 kez** ameliyat olabilir, **ayda en fazla 3 kez** muayene olabilir.
- **Ameliyat maliyeti** = (ameliyat malzeme adedi × birim fiyat) + doktor ücreti toplamı

## Uygulamanın Cevapladığı Sorular

1. Bir yılda **en çok muayene olan hasta** kimdir?
2. Bir ameliyatta oluşan **en yüksek maliyet** nedir?

## Proje Yapısı

| Dosya        | Açıklama                                      |
|-------------|------------------------------------------------|
| `Main.java` | Giriş noktası; örnek hasta/ameliyat verisi ve sonuç çıktısı |
| `Hospital.java` | Hastane; doktor/hemşire listesi, hasta ekleme, ameliyat ve raporlama |
| `Patient.java`  | Hasta; ad, muayene/ameliyat sayıları ve limitler |
| `Doctor.java`   | Doktor; rol (cerrah, uzman, pratisyen) ve ücret |
| `Nurse.java`    | Hemşire modeli                                |
| `Surgery.java`  | Ameliyat; doktor/hemşire listesi, malzeme maliyeti |

## Gereksinimler

- Java 8 veya üzeri (JDK)

## Derleme ve Çalıştırma

Proje kök dizininde (`Hospital` klasöründe):

```bash
# Tüm .java dosyalarını derle
javac *.java

# Uygulamayı çalıştır
java Main
```

### Örnek Çıktı

```
Most checkups in a year: Can
Max surgery cost: 3200
Hospital project started.
```

## Lisans

Bu proje eğitim amaçlıdır.
