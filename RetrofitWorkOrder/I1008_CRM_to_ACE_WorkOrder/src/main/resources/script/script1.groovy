import com.sap.gateway.ip.core.customdev.util.Message;
import groovy.xml.*;
import java.util.regex.*;

import java.util.HashMap;
def Message processData(Message message) {
    def body = message.getBody(java.lang.String) as String;
    def messageLog = messageLogFactory.getMessageLog(message);
    if(messageLog != null){
        def bodyNice = XmlUtil.serialize(body);
        messageLog.setStringProperty("Logging#1", "Printing Payload As Attachment")
        messageLog.addAttachmentAsString("1. WorkOrderOdataResponse", bodyNice , "text/plain");
     }
    return message;
}