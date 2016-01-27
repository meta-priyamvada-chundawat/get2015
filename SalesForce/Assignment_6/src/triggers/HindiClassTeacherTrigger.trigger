trigger HindiClassTeacherTrigger on Contact (before insert,before update) {
   for(Contact contact : Trigger.new)
   {
       if(contact.Subjects__c.Contains('Hindi'))
       {
           contact.addError('Hindi Teacher is not allowed to insert/update');
       }
   }
}