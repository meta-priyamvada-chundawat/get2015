trigger OnCloseOpportunityTrigger on Opportunity (before update) {
   List<opportunity> opportunityList;
   for(Opportunity opp : Trigger.New){
       if(opp.stageName =='Closed Won' || opp.StageName=='Closed Lost'){
           opp.CloseDate = Date.today();
       }
   }
}