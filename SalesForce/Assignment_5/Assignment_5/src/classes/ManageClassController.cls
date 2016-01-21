public with sharing class ManageClassController {
    
    // To Display the Records
    public Class__c recordsToDisplay { get; private set; }
    // To save the Records
    public Class__c saveRecords { get; private set; }
    // To Update the Record
    public String idToUpdate {get;set;}
    // To display the Popup
    public boolean displayPopup {get; set;} 
    
    public String thisClass {get; set;}
    // Query to get the Details
    String query = 'SELECT Id, Name, fee__c, board__c FROM Class__c ';
    // Constructor
    public ManageClassController(ApexPages.StandardController controller) {
        idToUpdate ='';
    }
    
    public void saveDetails() {  
        displayPopup = false;
        update saveRecords;
        
    }  
    
    public void deleteDetails() { 
        saveRecords = [SELECT 
                       id,name,fee__C 
                       FROM
                       Class__c 
                       WHERE id = :idToUpdate];
        delete saveRecords;
    }  
    
    public void ShowDataToEdit() { 
        // Query to fetch the Records
        saveRecords = [SELECT
                       id, name, fee__c,board__C 
                       FROM Class__c 
                       WHERE id = :idToUpdate];
        displayPopup = true;    
    }   
    
    public List<Class__C> getRecords() 
    {
        return Database.query(query);
    }  
}