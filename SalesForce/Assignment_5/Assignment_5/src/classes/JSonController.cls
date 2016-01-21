public class JSonController {
   public String text {get;set;}   
   public JSonController()
   {
     text='';   
   }    
   public void parseJson()
   {
       String soqlQuery = 'SELECT Name FROM Account LIMIT 5';
       List<Account> accountList = Database.Query(soqlQuery); 
       text = JSON.serializePretty(accountList);
   }    
}