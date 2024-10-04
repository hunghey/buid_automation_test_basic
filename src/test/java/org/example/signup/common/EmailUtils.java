package org.example.signup.common;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtils {

    public static String getOTPFromMail(String email, String password, String titleEmail) {

        String host = "imap.gmail.com"; // IMAP server
        String mailStoreType = "imap";

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
            store.connect(host, email, password);

            // Mở thư mục INBOX
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // Xử lý các email
            Message[] messages = emailFolder.getMessages();

            for (int i = messages.length - 1; i >= 0; i--) {
                Message message = messages[i];

                if (message.getSubject().contains(titleEmail)) {
                    // Lấy nội dung của email
                    String content = getTextFromMessage(message);

                    // Trích xuất mã OTP từ nội dung
                    String otpCode = extractVerificationCode(content);

                    return otpCode;
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
        Pattern otpPattern = Pattern.compile(">(\\d{6})<");
        Matcher matcher = otpPattern.matcher(content);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    // Hàm lấy nội dung email
    private static String getTextFromMessage(Message message) throws Exception {
        if (message.isMimeType("text/plain")) {
            return message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            String result = "";
//            MimeMultipart xu li email co cau truc da phan
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
//            lay so luong phan noi dung
            int count = mimeMultipart.getCount();
            for (int i = 0; i < count; i++) {
                BodyPart bodyPart = mimeMultipart.getBodyPart(i);
                if (bodyPart.isMimeType("text/plain")) {
                    result = result + "\n" + bodyPart.getContent();
                } else if (bodyPart.isMimeType("text/html")) {
                    result = result + "\n" + bodyPart.getContent();
                }
            }
            return result;
        } else if (message.isMimeType("text/html")) {
            return message.getContent().toString();
        }
        return null;
    }
}
