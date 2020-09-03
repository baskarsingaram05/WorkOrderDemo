import com.sap.it.api.mapping.*;
def String getProperty(String propertyName, MappingContext context) {
    def propValue= context.getProperty(propertyName);
    return propValue;
}