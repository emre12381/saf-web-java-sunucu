# Saf Java Web Sunucusu

Bu proje, herhangi bir 3. parti kütüphane veya framework kullanılmadan, tamamen standart Java kütüphaneleri (`java.net` ve `java.io`) kullanılarak geliştirilmiş bir Socket tabanlı web sunucusudur.

## ⚙️ Teknik Özellikler ve Çalışma Prensibi
* **Port Numarası:** 1989
* **Protokol:** HTTP/1.1
* **İletişim Kuralları:** `ServerSocket` ve `Socket` nesneleri kullanılarak TCP bağlantısı sağlanmış, gelen HTTP istekleri `BufferedReader` ile okunmuş ve `PrintWriter` aracılığıyla tarayıcıya HTML yanıtı döndürülmüştür.

## 🚀 Proje Nasıl Çalıştırılır?
1. Projeyi klonlayın veya indirin.
2. `SimpleWebServer.java` dosyasını herhangi bir Java IDE'sinde (IntelliJ IDEA, Eclipse vb.) açın.
3. `main` metodunu çalıştırarak sunucuyu başlatın.
4. Tarayıcınızı açarak **`http://localhost:1989`** adresine gidin.
