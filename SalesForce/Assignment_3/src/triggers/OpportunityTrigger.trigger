trigger OpportunityTrigger on Opportunity (before update) {
    List<Opportunity> opportunityList = [Select Id, Account.Id, BillToContact__c,Manager__c from Opportunity where Id in : Trigger.new];
    OpportunityController.populateInOpportunity(opportunityList);
}