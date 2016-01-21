public class PaginationController {
public list <account> accountList {get;set;}  
   public string str {get;set;}
   public string BillingCitystring {get;set;}  
   public string BillingStatestring {get;set;}  
   public string BillingCountrystring {get;set;}  
   private integer totalRecs = 0;
   private integer OffsetSize = 0;
   private integer LimitSize = 10;
    
   public PaginationController(ApexPages.StandardController controller) {  
  
       totalRecs = [select count() from account];
       BillingCitystring = '';
       BillingStatestring = '';
       BillingCountrystring ='';
   }  
   public void search(){
      
      
          String str = 'SELECT Name, BillingCity, BillingState, BillingCountry FROM Account WHERE ';
        
        if(!String.IsBlank(BillingCitystring)) {
            str += 'Billingcity LIKE \'%' + BillingCitystring + '%\' AND ';
        }
        
        if(!String.IsBlank(BillingStatestring)) {
            str += 'BillingState LIKE \'%' + BillingStatestring  + '%\' AND ';
        }
        
        if(!String.IsBlank(BillingCountrystring)) {
            str += 'BillingCountry LIKE \'%' + BillingCountrystring + '%\' AND ';
        }
        
        str = str.substring(0, str.length() - 4);
        str += ' LIMIT ' + LimitSize + ' OFFSET ' + OffsetSize;                      
       
      accountList = Database.query(str);
      totalRecs = accountList.size();
  }   
    
   public void clear(){  
   accountList.clear();  
   } 
    
      public void FirstPage() {
        OffsetSize = 0;
        search();
    }
    
    public void previous() {
        OffsetSize = OffsetSize - LimitSize;
        search();
    }
    
    public void next() {
        OffsetSize = OffsetSize + LimitSize;
        search();
    }
    
    public void LastPage() {
        OffsetSize = totalrecs - math.mod(totalRecs,LimitSize);
        search();
    }
    
    public boolean getprev() {
        if(OffsetSize == 0)
            return true;
        else
            return false;
    }
    
    public boolean getnxt() {
        if((OffsetSize + LimitSize) > totalRecs)
            return true;
        else
            return false;
    }
}