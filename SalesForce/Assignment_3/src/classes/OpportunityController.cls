public class OpportunityController {

    public static void populateInOpportunity(List<Opportunity> oppList) {
     
        for(Opportunity opp:oppList){
             System.debug(opp.BillToContact__c);
            System.debug(opp.Manager__c);
            System.debug('ghdshkj');
            if(opp.BillToContact__c != null && opp.Manager__c == null)
            {
                System.debug(opp.AccountId);
                System.debug(opp.BillToContact__c);
                opp.Manager__c =opp.AccountId;
                   System.debug(opp.Manager__c);
            }
            
        }
     
    }
}