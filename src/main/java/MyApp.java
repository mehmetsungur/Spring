//1. Message classını oluşturalım.

import domain.Message;
import domain.Sms;
import service.MailService;
import service.MessageService;
import service.SmsService;

public class MyApp {
    public static void main(String[] args) {
        Message message = new Message();
        message.setMessage("Siparişiniz kargoya verildi.");

        //2. Servis classı oluşturalım.
        //Messajı mail ile gönderimi
        //MailService mailService = new MailService();
        //mailService.sendMessage(message);

        //3. Servis classı oluşturalım.
        //sms mail ile gönderimi
        //SmsService smsService = new SmsService();
        //smsService.sendMessage(message);

        // Interface yapısı
        //MessageService smsService1 = new SmsService();
        //smsService1.sendMessage(message);

        //MessageService mailService1 = new MailService();
        //mailService1.sendMessage(message);

        //run timeda servis objesini belirleyelim
        MessageService service1 = null;
        String serviceName = "MailService";

        if(args.length>0){
            serviceName = args[0];
        }

        if(serviceName.equalsIgnoreCase("MailService")){
            service1 = new MailService();
        }else if(serviceName.equalsIgnoreCase("SmsService")){
            service1 = new SmsService();
        }
        service1.sendMessage(message);

        //message ı kalıcı hale getirmek
        MessageService messageService = new MailService();
        messageService.sendMessage(message);
        messageService.saveMessage(message);

        MessageService messageService1 = new SmsService();
        messageService1.sendMessage(message);
        messageService1.saveMessage(message);
    }
}
