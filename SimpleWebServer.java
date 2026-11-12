import java.io.*;
import java.net.*;

public class SimpleWebServer {
    public static void main(String[] args) {
        int port = 1989;
        System.out.println("Web sunucusu baslatiliyor...");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Sunucu " + port + ". port üzerinden dinlemede.");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String line = in.readLine();
                    while (line != null && !line.isEmpty()) {
                        line = in.readLine();
                    }

                    // Tarayıcıda görünecek HTML içeriği
                    String htmlContent = "<!DOCTYPE html>\n" +
                            "<html lang=\"tr\">\n" +
                            "<head>\n" +
                            "<meta charset='UTF-8'>\n" +
                            "<title>Final Değerlendirme Ödevi - 2</title>\n" +
                            "<style>\n" +
                            "  body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f4f6f9; color: #333; text-align: center; padding-top: 80px; }\n" +
                            "  h1 { color: #2c3e50; font-size: 2.8em; margin-bottom: 5px; }\n" +
                            "  h2 { color: #16a085; font-size: 1.6em; margin-top: 0; }\n" +
                            "  .bio-box { background: #ffffff; padding: 30px; border-radius: 12px; display: inline-block; box-shadow: 0 6px 15px rgba(0,0,0,0.1); max-width: 650px; text-align: left; margin-top: 25px; }\n" +
                            "  p { line-height: 1.6; color: #555; }\n" +
                            "</style>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "  <h1>Emre Çeğil</h1>\n" +
                            "  <h2>1250505056</h2>\n" +
                            "  <div class=\"bio-box\">\n" +
                            "    <h3>Hakkımda / Biyografi</h3>\n" +
                            "    <p>Kırklareli Üniversitesi Mühendislik Fakültesi Yazılım Mühendisliği bölümünde lisans eğitimime devam etmekteyim. Düşük seviyeli sistem programlama, nesne yönelimli programlama ve web teknolojileri alanlarında akademik projeler geliştirmekteyim.</p>\n" +
                            "  </div>\n" +
                            "</body>\n" +
                            "</html>";

                    out.println("HTTP/1.1 200 OK");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println("Content-Length: " + htmlContent.getBytes("UTF-8").length);
                    out.println("Connection: close");
                    out.println();

                    out.println(htmlContent);
                } catch (IOException e) {
                    System.err.println("Bağlantı hatası: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Port açılamadı: " + e.getMessage());
        }
    }
}