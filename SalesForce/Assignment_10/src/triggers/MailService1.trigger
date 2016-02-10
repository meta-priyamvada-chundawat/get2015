trigger MailService1 on Loan__c (before update) {
    List<Messaging.SingleEmailMessage> mails = new List<Messaging.SingleEmailMessage>();
    for(Loan__c loan : Trigger.new) {
        if((loan.Loan_Status__c == 'Approved' || loan.Loan_Status__c == 'Rejected')) {
            try{
                Messaging.SingleEmailMessage email = new Messaging.SingleEmailMessage();                
                String[] toAddress = new List<String>() ;
                toAddress.add(loan.ApplicantEmail__c);
                email.setSenderDisplayName(loan.Manager__c);  
                email.setToAddresses(toAddress);
                email.plainTextBody = 'Hii Your Loan is '+loan.Loan_Status__c;
                mails.add(email);
                
            }catch(Exception e) {
                System.debug(e);
            }
        }
    }
    Messaging.sendEmail(mails);
}