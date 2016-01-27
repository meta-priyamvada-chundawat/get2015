trigger ResetOpportunityTrigger on Opportunity (after update) {

    List<Id> oppList = new List<Id>();
    List<OpportunityLineItem> lineItemList = new List<OpportunityLineItem>();
    
    for (Opportunity opp : Trigger.New) {
        if (opp.Custom_Status__c == 'Reset') {
            oppList.add(opp.Id);
        }
    }
    
    lineItemList = [SELECT Id FROM OpportunityLineItem WHERE Opportunity.Id IN :oppList];
    
    Database.delete(lineItemList);
}