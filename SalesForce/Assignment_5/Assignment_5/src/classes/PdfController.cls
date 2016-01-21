public class PdfController {
	Public attachment objAttachment{get; set;}
    Public Student__c objStudent{get; set;}
    Public PdfController(apexpages.standardcontroller stdCon){
        objAttachment = new Attachment();
        objStudent = new Student__c();
    }
    Public void saveStudent(){
        insert objStudent;
       
        objAttachment.ParentId = objStudent.id;
        insert objAttachment;
    }
}