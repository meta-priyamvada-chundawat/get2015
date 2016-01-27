trigger ClassTriggerOnDelete on Class__c (before delete) {
   List<Student__c> studentList = [Select id,class__r.id from Student__c where Sex__c='Female' AND Class__c In :Trigger.old];
   for(Class__c classDetail : Trigger.old){
       Integer numberOfFemaleStudents = 0;
       for(Student__C s : studentList){
          if(classDetail.id == s.class__r.id){
              numberOfFemaleStudents++;
               if(numberOfFemaleStudents > 1){
                Trigger.oldMap.get(classDetail.id).adderror('Cannot delete a Class having more than female 1 female student');
               	break;
				}
			}
		}
	}
}