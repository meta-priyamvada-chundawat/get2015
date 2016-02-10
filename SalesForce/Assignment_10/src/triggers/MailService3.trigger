trigger MailService3 on Opportunity (before update) {
    Id templateId = [Select id from EmailTemplate where name = 'OpportunityStatusTemplate'].Id;
    List<Messaging.SingleEmailMessage> mails = new List<Messaging.SingleEmailMessage>();    
    for (Opportunity opp : Trigger.New) {
        opportunity oldOpp = trigger.oldmap.get(opp.Id);
        if (oldOpp.Custom_Status__c != opp.Custom_Status__c) {
            Messaging.SingleEmailMessage mail = new Messaging.SingleEmailMessage();          
            mail.setTargetObjectId(opp.OwnerId);
            mail.setTemplateId(templateId);
            mail.setSaveAsActivity(false);
            mails.add(mail);    
        }
    }
    Messaging.sendEmail(mails);
}