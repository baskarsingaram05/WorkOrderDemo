import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import groovy.xml.*;


def Message log01(Message message) {processData("1", "Log01_WorkOrderOdataResponse", " WorkOrderOdataResponse ", message);}
def Message log02(Message message) {processData("2", "Log02_ACEWorkOrderStatus", "ACEWorkOrderStatus", message);}
def Message log03(Message message) {processData("3", "Log03_ACEWorkOrderStructure_AM", " ACEWorkOrderStructure_AM", message);}
def Message processData(String id, String logProperty, String name, Message message) {
    def map = message.getProperties();
	def body = message.getBody(java.lang.String) as String;
	if(map.get(logProperty).equals("true")) {
    	def logConfig = map.get("SAP_MessageProcessingLogConfiguration");
    	def logLevel = (String) logConfig.logLevel;
    	
    	def messageLog = messageLogFactory.getMessageLog(message);
            
        if(messageLog != null)   {  
    	  if((logLevel.equals("DEBUG") || logLevel.equals("TRACE"))) {
    	        def bodyNice = XmlUtil.serialize(body); //Pretty Print
                messageLog.setStringProperty("Logging#" + id, "Printing Payload As Attachment");
                messageLog.addAttachmentAsString(id + ":" + name,bodyNice, "text/plain");
            }
        }      
	}
    return message;
}