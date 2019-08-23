package utlilities;

import org.junit.After;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.websocket.OnClose;
import javax.xml.ws.Action;
import java.util.Properties;

public class SendingEmail extends ExtentReporterNG {

//    void compress() throws IOException {
//
//        String sourceFile = System.getProperty("user.dir")+"\\Reports\\Test_Report"+timeStamp+".html";
//        //String sourceFile = "test1.txt";
//        FileOutputStream fos = new FileOutputStream("compressed.zip");
//        ZipOutputStream zipOut = new ZipOutputStream(fos);
//        File fileToZip = new File(sourceFile);
//        FileInputStream fis = new FileInputStream(fileToZip);
//        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
//        zipOut.putNextEntry(zipEntry);
//        byte[] bytes = new byte[1024];
//        int length;
//        while((length = fis.read(bytes)) >= 0) {
//            zipOut.write(bytes, 0, length);
//        }
//        zipOut.close();
//        fis.close();
//        fos.close();
//    }

        public void SendReport() throws InterruptedException {
        System.out.println("On email function");
            Thread.sleep(10000);

            // Create object of Property file
            Properties props = new Properties();

            // this will set host of server- you can change based on your requirement
            props.put("mail.smtp.host", "smtp.gmail.com");

            // set the port of socket factory
            props.put("mail.smtp.socketFactory.port", "465");

            // set socket factory
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

            // set the authentication to true
            props.put("mail.smtp.auth", "true");

            // set the port of SMTP server
            props.put("mail.smtp.port", "465");

            // This will handle the complete authentication
            Session session = Session.getDefaultInstance(props,

                    new javax.mail.Authenticator() {

                        protected PasswordAuthentication getPasswordAuthentication() {

                            return new PasswordAuthentication("testactivity62@gmail.com", "appium@123");

                        }

                    });

            try {

                // Create object of MimeMessage class
                Message message = new MimeMessage(session);

                // Set the from address
                message.setFrom(new InternetAddress("testactivity62@gmail.com"));

                // Set the recipient address
                message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("umairhassan7860@gmail.com"));

                // Add the subject link
                message.setSubject("Automation Execution Test Report");

                // Create object to add multimedia type content
                BodyPart messageBodyPart1 = new MimeBodyPart();

                // Set the body of email
                messageBodyPart1.setText("Test execution has been done");

                // Create another object to add another content
                MimeBodyPart messageBodyPart2 = new MimeBodyPart();

                ExtentReporterNG exrep = new ExtentReporterNG();

                // Mention the file which you want to send
                // System.out.println("Report name is "+timeStamp);
                String filename = System.getProperty("user.dir")+"\\Reports\\Test_Report"+timeStamp+".html";

                // Create data source and pass the filename
                DataSource source = new FileDataSource(filename);

                // set the handler
                messageBodyPart2.setDataHandler(new DataHandler(source));

                // set the file
                messageBodyPart2.setFileName(filename);

                // Create object of MimeMultipart class
                Multipart multipart = new MimeMultipart();

                // add body part 1
                multipart.addBodyPart(messageBodyPart2);

                // add body part 2
                multipart.addBodyPart(messageBodyPart1);

                // set the content
                message.setContent(multipart);

                // finally send the email
                Transport.send(message);

                System.out.println("Test Report has been delivered");

            } catch (MessagingException e) {

                throw new RuntimeException(e);
            }

        }
    }
