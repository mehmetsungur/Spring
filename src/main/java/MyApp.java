//1. Message classını oluşturalım.

import domain.Message;
import service.MailService;
import service.MessageService;
import service.SmsService;

public class MyApp {
    public static void main(String[] args) {
        Message message = new Message();
        message.setMessage("Siparişiniz kargoya verildi.");

        //2. Servis classı oluşturalım.
        //Messajı mail ile gönderimi
        MailService mailService = new MailService();
        mailService.sendMessage(message);

        //3. Servis classı oluşturalım.
        //sms mail ile gönderimi
        SmsService smsService = new SmsService();
        smsService.sendMessage(message);

        // Interface yapısı
        MessageService smsService1 = new SmsService();
        smsService1.sendMessage(message);

        MessageService mailService1 = new MailService();
        mailService1.sendMessage(message);

        //run timeda servis objesini belirleyelim
        MessageService service1 = null;
        String serviceName = "Mail Service";

        if(args.length>0){
            serviceName = args[0];
        }

        if(serviceName.equalsIgnoreCase("Mail Service")){
            service1 = new MailService();
        }else if(serviceName.equalsIgnoreCase("Sms Service")){
            service1 = new SmsService();
        }
    }
}
