package org.example.signup.common;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import java.util.Optional;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtils {

    public String getOTPFromMail( String email, String password1) {

        String host = "imap.gmail.com"; // IMAP server
        String mailStoreType = "imap";
        String username = email;
        String password = "npya osms zbzt fcpk"; // App password if 2FA is enabled

        try {
            // Cấu hình properties cho kết nối
            Properties properties = new Properties();
            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            properties.put("mail.imap.ssl.enable", "true");

            // Cấu hình timeout
            properties.put("mail.imap.connectiontimeout", "5000"); // 5 giây cho timeout kết nối
            properties.put("mail.imap.timeout", "5000"); // 5 giây cho timeout đọc

            // Tạo session và store
            Session emailSession = Session.getDefaultInstance(properties);
            Store store = emailSession.getStore(mailStoreType);

            // Kết nối đến máy chủ email
            store.connect(host, username, password);

            // Mở thư mục INBOX
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // Xử lý các email
            Message[] messages = emailFolder.getMessages();

            for (Message message : messages) {
                if (message.getSubject().contains("Your Verification Code")) {
                    String content = getTextFromMessage(message);
                    return extractVerificationCode(content);
                }
            }
            emailFolder.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Hàm trích xuất mã xác thực từ nội dung email
    private static String extractVerificationCode(String content) {
        Pattern pattern = Pattern.compile("\\d{6}");  // Giả sử mã là 6 số
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    // Hàm lấy nội dung email
    private static String getTextFromMessage(Message message) throws Exception {
        if (message.isMimeType("text/plain")) {
            return message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) message.getContent();
            for (int i = 0; i < multipart.getCount(); i++) {
                MimeBodyPart bodyPart = (MimeBodyPart) multipart.getBodyPart(i);
                if (bodyPart.isMimeType("text/plain")) {
                    return bodyPart.getContent().toString();
                }
            }
        }
        return null;
    }
}
