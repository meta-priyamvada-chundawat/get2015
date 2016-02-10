global class MailServiceClass implements Messaging.InboundEmailHandler {    
    global Messaging.InboundEmailResult handleInboundEmail(Messaging.InboundEmail email, Messaging.InboundEnvelope envelope) {        
        Messaging.InboundEmailResult result = new Messaging.InboundEmailResult();
        String fname;
        list<Contact>contactList=new list<Contact>();
        for (Messaging.Inboundemail.TextAttachment file : email.textAttachments) {            
            String fileBody = (String)file.body;            
            Dom.Document doc = new Dom.Document();
            doc.load(fileBody);            
            for(DOM.XMLNode xmlnodeobj:doc.getRootElement().getChildElements())
            {          Contact con = new Contact();
             if(xmlnodeobj.getChildElement('fname',null) != null){  
                 fName = xmlnodeobj.getChildElement('fname', null).getText();
             }
             String lName = xmlnodeobj.getChildElement('lname', null).getText();             
             con.FirstName = fName;
             con.LastName = lName;
             contactList.add(con);            
            }            
        }
        insert contactList;        
        return result;
    }
}