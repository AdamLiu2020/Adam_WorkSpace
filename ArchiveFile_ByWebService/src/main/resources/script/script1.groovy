import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

def Message processData(Message message) {
    //Body 
       def body = message.getBody(java.lang.String) as String;
       def messageLog = messageLogFactory.getMessageLog(message);
       if(messageLog != null){
            body = body.replaceAll("<","&lt;").replaceAll(">","&gt;");
            messageLog.addAttachmentAsString("MsgBody", body, "text/plain");
        }
        message.setProperty("EnCodeBody", body);
        def dateNow = new Date().format("yyyyMMddHHmmss");
        message.setProperty("FilePath", "\\\\DISFileshare_Dev\\BizTalk_DEV\\EAI\\TestArchive\\TestMsg_"+dateNow);
       return message;
}