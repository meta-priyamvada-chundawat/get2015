public class SearchController {
public list <account> accountList {get;set;}  
   public string str {get;set;}
   public string BillingCitystring {get;set;}  
   public string BillingStatestring {get;set;}  
   public string BillingCountrystring {get;set;}  
   public Searchcontroller(ApexPages.StandardController controller) {  
       BillingCitystring = '';
       BillingStatestring = '';
       BillingCountrystring ='';
   }  
   public void searchAnd(){
      accountList= new list<Account>();
      if(string.isBlank(BillingCitystring) && string.isBlank(BillingStatestring) && string.isBlank(BillingCountrystring)) 
     {
          accountList= Database.query('SELECT id,name,billingcity,billingCountry,billingState FROM Account limit 100');
     }    
      else 
      {
          accountList= Database.query('SELECT id,name,billingcity,billingCountry,billingState FROM Account WHERE billingcity LIKE \'%'+BillingCitystring.trim()+'%\' AND billingcountry  LIKE  \'%'+BillingCountrystring.trim()+'%\' AND billingstate LIKE  \'%'+BillingStatestring.trim()+'%\' Limit 100');                      
      }
  }
    
     public void searchOr(){
      accountList= new list<Account>();
      if(string.isBlank(BillingCitystring) && string.isBlank(BillingStatestring) && string.isBlank(BillingCountrystring)) 
     {
          accountList= Database.query('SELECT id,name,billingcity,billingCountry,billingState FROM Account limit 100');
 	 }    
      else 
      {   
          str=str='SELECT id,name,billingcity,billingCountry,billingState FROM Account WHERE ';
         if(!string.isBlank(BillingCitystring))
         	  str=str+'billingcity LIKE  \'%'+BillingCitystring.trim();
         if(!string.isBlank(BillingCountrystring))
			  str=str+'%\' OR billingCountry LIKE  \'%'+BillingCountrystring.trim();
         if(!string.isBlank(BillingStatestring))
              str=str+'%\' OR billingState LIKE  \'%'+BillingStatestring.trim();
          str=str+'%\' Limit 100';
          accountList= Database.query(str);
      }
  }
    
   public void clear(){  
   accountList.clear();  
   }  
}