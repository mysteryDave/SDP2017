package abstractfactory

/**
  * Created by DT on 10/05/2017.
  */
class LondonERRORParser extends LondonXMLParser with ErrorXMLParser //Composition.

class LondonFEEDBACKParser extends LondonXMLParser with FeedbackXMLParser

class LondonORDERParser extends LondonXMLParser with OrderXMLParser

class LondonRESPONSEParser extends LondonXMLParser with ResponseXMLParser
