import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
def Message processData(Message message) {
    def body = message.getBody(java.lang.String) as String;
    def OrderGuid = message.getProperty("OrderGuid");
    def orderGuidQuery = OrderGuid[0..7] + '-' + OrderGuid[8..11] + '-' + OrderGuid[12..15] + '-' + OrderGuid[16..19] + '-' + OrderGuid[20..31];
    message.setProperty ("orderGuidQuery", orderGuidQuery);
    return message;
}

