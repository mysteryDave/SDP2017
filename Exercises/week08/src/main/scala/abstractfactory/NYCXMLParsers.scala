package abstractfactory

/**
  * Created by DT on 10/05/2017.
  */
class NYCERRORParser extends NYCXMLParser with ErrorXMLParser

class NYCFEEDBACKParser extends NYCXMLParser with FeedbackXMLParser

class NYCORDERParser extends NYCXMLParser with OrderXMLParser

class NYCRESPONSEParser extends NYCXMLParser with ResponseXMLParser